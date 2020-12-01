/**
 * 公司:
 * 文件名:CustomerServiceimpl
 * 作者：Tiger
 * 时间：2020/12/1 9:42
 * 描述：
 */
package com.waymap.custevalusys.serviceimpl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waymap.custevalusys.bo.CustUserDetails;
import com.waymap.custevalusys.common.Asserts;
import com.waymap.custevalusys.dto.CustLoginParm;
import com.waymap.custevalusys.dto.UpdateAdminPasswordParam;
import com.waymap.custevalusys.mapper.CustomerMapper;
import com.waymap.custevalusys.model.Customer;
import com.waymap.custevalusys.service.CustomerService;
import com.waymap.custevalusys.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String login(String username, String password) {
        String token = null;
        try{
            UserDetails userDetails = getUserDetailsByusername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(SecurityContextHolder.getContext().getAuthentication());
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (RuntimeException e){
            LOGGER.warn("登录异常:{}",e.getMessage());
        }
        return token;
    }

    @Override
    public Customer createCount(CustLoginParm custLoginParm) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(custLoginParm,customer);
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",customer.getUsername());
        List<Customer> customers =  customerMapper.selectList(queryWrapper);
        if(customers.size()>0){
            return null;
        }
        String enablePassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(enablePassword);
        customerMapper.insert(customer);
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
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public Customer getCustById(Integer id) {
        return customerMapper.selectById(id);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam updatePasswordParam) {
        if(StrUtil.isEmpty(updatePasswordParam.getUsername())||
                StrUtil.isEmpty(updatePasswordParam.getNewPassword())||
                StrUtil.isEmpty(updatePasswordParam.getOldPassword())){
            return -1;
        }
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",updatePasswordParam.getUsername());
        Customer customer = customerMapper.selectOne(queryWrapper);
        if(!passwordEncoder.matches(updatePasswordParam.getOldPassword(),customer.getPassword())){
            return -2;
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
