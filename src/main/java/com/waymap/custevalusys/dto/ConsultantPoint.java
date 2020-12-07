/**
 * 公司:
 * 文件名:consultantEvalution
 * 作者：Tiger
 * 时间：2020/12/4 11:32
 * 描述：
 */
package com.waymap.custevalusys.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/4
 */
@Getter
@Setter
public class ConsultantPoint {
    @ApiModelProperty(value = "顾问Id",required = true)
    private Integer consultantId;

    @ApiModelProperty(value = "问题1",required = true)
    private Integer question1;

    @ApiModelProperty(value = "问题2",required = true)
    private Integer question2;

    @ApiModelProperty(value = "问题3",required = true)
    private Integer question3;
}
