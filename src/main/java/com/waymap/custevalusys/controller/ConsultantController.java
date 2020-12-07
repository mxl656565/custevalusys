/**
 * 公司:
 * 文件名:ConsultantController
 * 作者：Tiger
 * 时间：2020/12/3 15:22
 * 描述：
 */
package com.waymap.custevalusys.controller;

import com.waymap.custevalusys.common.CommonResult;
import com.waymap.custevalusys.dto.CreateConsultantParm;
import com.waymap.custevalusys.model.Consultant;
import com.waymap.custevalusys.service.ConsultantService;
import com.waymap.custevalusys.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : tiger
 * @description : 顾问管理
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/3
 */
@Api(tags = "ConsultantController",value = "顾问管理")
@RestController
@RequestMapping("/consultant")
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private ProjectService projectService;

    @ApiOperation("创建顾问")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult<?> createConsultant(@Validated @RequestBody CreateConsultantParm createConsultant){
        Consultant consultant = consultantService.addConsultant(createConsultant);
        if(consultant == null){
            return CommonResult.failed("该项目下已有该顾问");
        }
        return CommonResult.success(consultant,"成功创建顾问在"+createConsultant.getProjectname()+"项目中");
    }
    @ApiOperation("获取当前项目负责的顾问")
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public CommonResult<?> getConsultantList(@RequestParam Integer projectId){
        List<Consultant> consultants =  projectService.selectConsultantInProject(projectId);
        return CommonResult.success(consultants,"当前项目下的顾问清单");
    }
}
