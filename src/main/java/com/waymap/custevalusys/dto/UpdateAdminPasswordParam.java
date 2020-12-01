/**
 * 公司:
 * 文件名:UpdateAdminPasswordParam
 * 作者：Tiger
 * 时间：2020/12/1 15:15
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author : tiger
 * @description : 修改用户密码参数
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/1
 */
@Data
public class UpdateAdminPasswordParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "旧密码", required = true)
    private String oldPassword;
    @NotEmpty
    @ApiModelProperty(value = "新密码", required = true)
    private String newPassword;
}
