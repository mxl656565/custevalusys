/**
 * 公司:
 * 文件名:CustomerEvalutionListParm
 * 作者：Tiger
 * 时间：2020/12/4 16:40
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/4
 */
@Getter
@Setter
public class ConsultantEvalutionListParm {
    @ApiModelProperty("顾问评估清单")
    private List<ConsultantEvalution> consultantEvalutionList;
}
