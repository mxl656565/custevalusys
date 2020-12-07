/**
 * 公司:
 * 文件名:SaveEvaluationParm
 * 作者：Tiger
 * 时间：2020/12/4 11:29
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/4
 */
@Getter
@Setter
public class SaveEvaluationParm {
    @NotNull
    @ApiModelProperty(value = "项目Id",required = true)
    private Integer projectId;

    @NotNull
    @ApiModelProperty(value = "客户Id",required = true)
    private Integer customerId;

    @NotEmpty
    @ApiModelProperty(value = "意见反馈")
    private String feedback;

    @NotNull
    @ApiModelProperty(value = "提交时间",required = true)
    private Long evaluatime;

    @NotEmpty
    @ApiModelProperty(value = "顾问评分列表",required = true)
    private List<ConsultantPoint> consultantPoint;
}
