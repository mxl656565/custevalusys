/**
 * 公司:
 * 文件名:CustAdminController
 * 作者：Tiger
 * 时间：2020/11/30 16:46
 * 描述：
 */
package com.waymap.custevalusys.controller;

import com.waymap.custevalusys.common.Asserts;
import com.waymap.custevalusys.common.CommonResult;
import com.waymap.custevalusys.dto.CreateCountParm;
import com.waymap.custevalusys.dto.CustLoginParm;
import com.waymap.custevalusys.dto.ResetPasswordParam;
import com.waymap.custevalusys.model.Customer;
import com.waymap.custevalusys.service.CustomerService;
import com.waymap.custevalusys.serviceimpl.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/30
 */
@Api(tags = "CustController",value = "客户管理")
@RestController
@RequestMapping("/Cust")
public class CustController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private CustomerService customerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustController.class);

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@Validated @RequestBody CustLoginParm customerLoginParm){
        String token = customerService.login(customerLoginParm.getUsername(),customerLoginParm.getPassword());
        if(token == null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "创建账号")
    @RequestMapping(value = "/createCount",method = RequestMethod.POST)
    public CommonResult createCount(@Validated @RequestBody CreateCountParm createCountParm){
            Customer customer = customerService.createCount(createCountParm);
            if(customer == null){
                return CommonResult.failed("用户名已存在");
            }
            return CommonResult.success(customer);
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public CommonResult resetPassword(@Validated @RequestBody ResetPasswordParam param){
        int flag = customerService.updatePassword(param);
        if(flag==-1){
            return CommonResult.failed("修改密码失败，原密码错误");
        }
        return CommonResult.success(null,"修改密码成功");
    }
}
