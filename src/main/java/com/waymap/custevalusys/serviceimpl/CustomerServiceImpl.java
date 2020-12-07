/**
 * 公司:
 * 文件名:CustomerServiceimpl
 * 作者：Tiger
 * 时间：2020/12/1 9:42
 * 描述：
 */
package com.waymap.custevalusys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waymap.custevalusys.bo.CustUserDetails;
import com.waymap.custevalusys.common.Asserts;
import com.waymap.custevalusys.dto.CreateCountParm;
import com.waymap.custevalusys.dto.ResetPasswordParam;
import com.waymap.custevalusys.mapper.CustomerMapper;
import com.waymap.custevalusys.model.Customer;
import com.waymap.custevalusys.model.Project;
import com.waymap.custevalusys.service.CustomerService;
import com.waymap.custevalusys.service.ProjectService;
import com.waymap.custevalusys.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/1
 */
@Service
@SuppressWarnings("all")
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProjectService projectService;

    @Override
    public String login(String username, String password) {
        String token = null;
        try{
            UserDetails userDetails = getUserDetailsByusername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e){
            LOGGER.warn("登录异常:{}",e.getMessage());
        }
        return token;
    }

    @Override
    public Customer createCount(CreateCountParm createCountParm) {
            Customer customer = new Customer();
            Project newProject = new Project();
        try{
            QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username",createCountParm.getUsername());
            List<Customer> customers = customerMapper.selectList(queryWrapper);
            if(customers.size()>0){
                return null;
            }

            String enablePasswrod = passwordEncoder.encode(createCountParm.getPassword());
            customer.setUsername(createCountParm.getUsername()).setPassword(enablePasswrod).setNickname(createCountParm.getNickname());
            Project project = projectService.findProjectByProjectName(createCountParm.getProjectname());
            if(project==null){
                newProject.setProjectname(createCountParm.getProjectname());
                Integer projectId = projectService.insertProject(newProject);
                customer.setProjectId(projectId);
            }
            customer.setProjectId(newProject.getId());
            customerMapper.insert(customer);
        }catch (Exception e){
            LOGGER.error("创建用户异常:{}",e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer getCustByUsername(String username) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Customer customer = customerMapper.selectOne(queryWrapper);
        return customer;
    }

    @Override
    public void insertCustomerFeedBack(Customer customer) {
        customerMapper.updateById(customer);
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public Customer getCustById(Integer id) {
        return customerMapper.selectById(id);
    }

    @Override
    public int updatePassword(ResetPasswordParam updatePasswordParam) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",updatePasswordParam.getUsername());
        Customer customer = customerMapper.selectOne(queryWrapper);
        if(!passwordEncoder.matches(updatePasswordParam.getOldPassword(),customer.getPassword())){
            return -1;
        }
        customer.setPassword(passwordEncoder.encode(updatePasswordParam.getNewPassword()));
        customerMapper.updateByPrimaryKey(customer);
        return 1;
    }

    @Override
    public UserDetails getUserDetailsByusername(String username) {
        Customer customer = getCustByUsername(username);
        if(customer!=null){
            return new CustUserDetails(customer);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
