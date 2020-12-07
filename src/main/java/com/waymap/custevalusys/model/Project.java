package com.waymap.custevalusys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)
@Data
public class Project implements Serializable {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "项目id")
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String projectname;

    private static final long serialVersionUID = 1L;
}