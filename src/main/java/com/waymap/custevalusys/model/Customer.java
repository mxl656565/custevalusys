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
public class Customer implements Serializable {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "客户id")
    private Integer id;

    @ApiModelProperty(value = "用户名(手机号)")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "项目id")
    private Integer projectId;

    @ApiModelProperty(value = "意见反馈")
    private String feedback;

    @ApiModelProperty(value = "评估时间")
    private Date evaluatime;

    private static final long serialVersionUID = 1L;
}