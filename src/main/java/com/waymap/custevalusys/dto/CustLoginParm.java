/**
 * 公司:
 * 文件名:CustomerLoginParm
 * 作者：Tiger
 * 时间：2020/12/1 13:43
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author : tiger
 * @description :用户登录参数
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/1
 */
@Data
public class CustLoginParm {
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
