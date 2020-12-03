/**
 * 公司:
 * 文件名:CreateCountParm
 * 作者：Tiger
 * 时间：2020/12/2 15:02
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/2
 */
@Getter
@Setter
public class CreateCountParm {
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @NotEmpty
    @ApiModelProperty(value = "昵称",required = true)
    private String nickname;

    @NotEmpty
    @ApiModelProperty(value = "项目名称",required = true)
    private String projectname;
}
