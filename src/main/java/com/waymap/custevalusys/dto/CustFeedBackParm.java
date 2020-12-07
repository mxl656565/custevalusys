/**
 * 公司:
 * 文件名:CustFeedBackParm
 * 作者：Tiger
 * 时间：2020/12/7 14:33
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
 * @date : 2020/12/7
 */
@Getter
@Setter
public class CustFeedBackParm {
    @ApiModelProperty(value = "评估人")
    private String nickname;
    @ApiModelProperty(value = "项目名")
    private String projectname;
    @ApiModelProperty(value = "意见详情")
    private String feedback;
    @ApiModelProperty(value = "提交时间")
    private Date evaluatime;
}
