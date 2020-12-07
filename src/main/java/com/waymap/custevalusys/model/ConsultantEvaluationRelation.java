package com.waymap.custevalusys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)
@Data
public class ConsultantEvaluationRelation implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "顾问id")
    private Integer consultantId;

    @ApiModelProperty(value = "评价id")
    private Integer evaluationId;

    private static final long serialVersionUID = 1L;
}