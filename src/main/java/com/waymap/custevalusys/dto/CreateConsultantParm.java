/**
 * 公司:
 * 文件名:CreateConsultant
 * 作者：Tiger
 * 时间：2020/12/3 14:18
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/3
 */
@Getter
@Setter
public class CreateConsultantParm {

    @NotEmpty
    @ApiModelProperty(value = "顾问名称",required = true)
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "项目名称",required = true)
    private String projectname;
}
