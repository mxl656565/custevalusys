/**
 * 公司:
 * 文件名:CustAdminController
 * 作者：Tiger
 * 时间：2020/11/30 16:46
 * 描述：
 */
package com.waymap.custevalusys.controller;

import com.waymap.custevalusys.common.CommonResult;
import com.waymap.custevalusys.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "用户登录校验")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@Validated @RequestBody Customer customer){
        return null;
    }
}
