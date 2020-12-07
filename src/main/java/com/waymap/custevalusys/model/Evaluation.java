package com.waymap.custevalusys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Accessors(chain = true)
@Data
public class Evaluation implements Serializable {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "评价id")
    private Integer id;

    @ApiModelProperty(value = "问题(1~4)")
    private Integer question;

    @ApiModelProperty(value = "分值(1~5)")
    private Integer points;

    @ApiModelProperty(value = "评估时间")
    private Date evaluatime;

    private static final long serialVersionUID = 1L;
}