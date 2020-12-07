/**
 * 公司:
 * 文件名:ConsultantEvalution
 * 作者：Tiger
 * 时间：2020/12/4 17:55
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/4
 */
@Getter
@Setter
public class ConsultantEvalution {
    @ApiModelProperty(value = "评估日期")
    private Date evaluatime;
    @ApiModelProperty(value = "评估人")
    private String customerName;
    @ApiModelProperty(value = "顾问姓名")
    private String consultantName;
    @ApiModelProperty(value = "评估项")
    private Integer question;
    @ApiModelProperty(value = "分值")
    private Integer point;
}
