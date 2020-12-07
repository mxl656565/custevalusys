/**
 * 公司:
 * 文件名:EvaluationController
 * 作者：Tiger
 * 时间：2020/12/3 16:20
 * 描述：
 */
package com.waymap.custevalusys.controller;

import com.waymap.custevalusys.common.CommonResult;
import com.waymap.custevalusys.dto.ConsultantEvalution;
import com.waymap.custevalusys.dto.ConsultantEvalutionListParm;
import com.waymap.custevalusys.dto.SaveEvaluationParm;
import com.waymap.custevalusys.service.EvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

/**
 * @author : tiger
 * @description : 评价管理
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/3
 */
@Api(tags = "EvaluationController",value = "评价管理")
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @ApiOperation("提交用户评价")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CommonResult saveEvaluation(@Validated @RequestBody @ApiParam(name = "SaveEvaluationParm",value = "保存的用户评价",required = true)SaveEvaluationParm parm){
        int number = evaluationService.saveEvaluation(parm);
        if(number == -1){
            return CommonResult.failed("该用户已经评价过了");
        }
        if(number == -2){
            return CommonResult.failed("顾问不存在,保存失败");
        }
        return CommonResult.success("保存客户评价成功");
    }

    @ApiOperation("获取顾问评估清单(以项目为维度)")
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public CommonResult getConsultantEvaluationList(@Validated @RequestParam(required = true) @ApiParam(name = "projectId",value = "项目Id",required = true)Integer projectId,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") @ApiParam(name = "PageNum",value = "当前页数")Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") @ApiParam(name = "PageSize",value = "每页显示多少条")Integer pageSize){
        ConsultantEvalutionListParm parm = evaluationService.selectCustEvaluationList(projectId,pageNum,pageSize);
        return CommonResult.success(parm,"成功获取顾问评估清单(以项目为维度)");
    }
}
