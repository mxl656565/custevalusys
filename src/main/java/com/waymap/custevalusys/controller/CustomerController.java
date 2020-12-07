/**
 * 公司:
 * 文件名:CustAdminController
 * 作者：Tiger
 * 时间：2020/11/30 16:46
 * 描述：
 */
package com.waymap.custevalusys.controller;

import com.waymap.custevalusys.common.CommonResult;
import com.waymap.custevalusys.dto.CreateCountParm;
import com.waymap.custevalusys.dto.CustLoginParm;
import com.waymap.custevalusys.dto.ResetPasswordParam;
import com.waymap.custevalusys.model.Customer;
import com.waymap.custevalusys.service.CustomerService;
import com.waymap.custevalusys.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : tiger
 * @description : 客户管理
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/30
 */
@Api(tags = "CustomerController",value = "客户管理")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CustomerService customerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@Validated @RequestBody CustLoginParm customerLoginParm){
        String token = customerService.login(customerLoginParm.getUsername(),customerLoginParm.getPassword());
        if(token == null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
//        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = customerService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
//        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "创建账号")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult createCount(@Validated @RequestBody CreateCountParm createCountParm){
            Customer customer = customerService.createCount(createCountParm);
            if(customer == null){
                return CommonResult.failed("用户名已存在");
            }
            return CommonResult.success(customer,"成功创建用户");
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public CommonResult resetPassword(@Validated @RequestBody ResetPasswordParam param){
        int flag = customerService.updatePassword(param);
        if(flag==-1){
            return CommonResult.failed("修改密码失败，原密码错误");
        }
        return CommonResult.success("修改密码成功");
    }

    @ApiOperation(value = "获取当前用户")
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public CommonResult getCurrentUser(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUserNameFromToken(token);
        Customer customer = customerService.getCustByUsername(username);
        return CommonResult.success(customer,"当前用户");
    }
}
