/**
 * 公司:
 * 文件名:EvaluationService
 * 作者：Tiger
 * 时间：2020/11/30 17:15
 * 描述：
 */
package com.waymap.custevalusys.service;

import com.waymap.custevalusys.dto.ConsultantEvalutionListParm;
import com.waymap.custevalusys.dto.SaveEvaluationParm;
import com.waymap.custevalusys.model.Evaluation;

import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/30
 */
public interface EvaluationService {
    /**
     * 保存评价表单信息
     * @param parm 评价表单json
     * @return 1保存成功,-1保存失败
     */
    int saveEvaluation(SaveEvaluationParm parm);

    /**
     * 保存一条评价记录
     * @param evaluation 评价记录
     * @return 保存的评价记录ID
     */
    Integer saveOneEvaluation(Evaluation evaluation);

    /**
     * 获取顾问评估清单
     * @param projectId 项目ID
     * @return 顾问评估清单
     */
    ConsultantEvalutionListParm selectCustEvaluationList(Integer projectId,Integer pageNum,Integer pageSize);
}
