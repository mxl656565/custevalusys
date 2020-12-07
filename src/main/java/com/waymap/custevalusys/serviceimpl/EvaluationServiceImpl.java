/**
 * 公司:
 * 文件名:EvaluationServiceImpl
 * 作者：Tiger
 * 时间：2020/12/3 16:20
 * 描述：
 */
package com.waymap.custevalusys.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waymap.custevalusys.dto.ConsultantEvalution;
import com.waymap.custevalusys.dto.ConsultantPoint;
import com.waymap.custevalusys.dto.ConsultantEvalutionListParm;
import com.waymap.custevalusys.dto.SaveEvaluationParm;
import com.waymap.custevalusys.mapper.ConsultantEvaluationRelationMapper;
import com.waymap.custevalusys.mapper.CustomerEvaluationRelationMapper;
import com.waymap.custevalusys.mapper.EvaluationMapper;
import com.waymap.custevalusys.model.*;
import com.waymap.custevalusys.service.ConsultantService;
import com.waymap.custevalusys.service.CustomerService;
import com.waymap.custevalusys.service.EvaluationService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/3
 */
@Service
@SuppressWarnings("all")
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ConsultantEvaluationRelationMapper consultantEvaluationRelationMapper;

    @Autowired
    private CustomerEvaluationRelationMapper customerEvaluationRelationMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    @Override
    public int saveEvaluation(SaveEvaluationParm parm) {
        //获取数据
        Integer customerId = parm.getCustomerId();
        Integer projectId = parm.getProjectId();
        String feedback = parm.getFeedback();
        Long evaluationTime = parm.getEvaluatime();

        List<ConsultantPoint> consultantEvalutionList = parm.getConsultantPoint();
        Evaluation evaluation = new Evaluation();
        ConsultantEvaluationRelation consultantEvaluationRelation = new ConsultantEvaluationRelation();
        CustomerEvaluationRelation customerEvaluationRelation = new CustomerEvaluationRelation();
        Integer question = null;
        try {
            Customer customer = customerService.getCustById(customerId);
            if (customer.getFeedback() != null || customer.getEvaluatime() != null) {
                return -1;
            }
            for (int i = 0; i < consultantEvalutionList.size(); i++) {
                ConsultantPoint consultantEvalution = consultantEvalutionList.get(i);
                Integer consultantId = consultantEvalution.getConsultantId();
                //判断顾问是否存在
                if (!consultantService.queryConsultantIsExists(consultantId)) {
                    return -2;
                }
                for (int x = 1; x < 4; x++) {
                    switch (x) {
                        case 1:
                            question = consultantEvalution.getQuestion1();
                            break;
                        case 2:
                            question = consultantEvalution.getQuestion2();
                            break;
                        case 3:
                            question = consultantEvalution.getQuestion3();
                            break;
                        default:
                    }
                    evaluation.setQuestion(x);
                    evaluation.setPoints(question);
                    evaluation.setEvaluatime(new Date(evaluationTime));
                    //插入评价数据
                    Integer evaluationId = saveOneEvaluation(evaluation);
                    //维护顾问与评价表的关系
                    consultantEvaluationRelation.setConsultantId(consultantId)
                            .setEvaluationId(evaluationId);
                    consultantEvaluationRelationMapper.insert(consultantEvaluationRelation);
                    //维护客户与评价表的关系
                    customerEvaluationRelation.setCustomerId(customerId)
                            .setEvaluationId(evaluationId);
                    customerEvaluationRelationMapper.insert(customerEvaluationRelation);
                }
            }
            customer.setFeedback(feedback).setEvaluatime(new Date(evaluationTime));
            customerService.insertCustomerFeedBack(customer);
        } catch (Exception e) {
            LOGGER.warn("保存顾问评价异常:{}", e.getMessage());
        }
        return 1;
    }

    @Override
    public Integer saveOneEvaluation(Evaluation evaluation) {
        evaluationMapper.insertOneRecAndGetId(evaluation);
        return evaluation.getId();
    }

    @Override
    public ConsultantEvalutionListParm selectCustEvaluationList(Integer projectId, Integer PageNum, Integer PageSize) {
        Page<ConsultantEvalution> page = new Page<>(PageNum, PageSize);
        IPage<ConsultantEvalution> result = evaluationMapper.selectEvaluationByProjectId(page, projectId);
        List<ConsultantEvalution> consultantEvalutionList = result.getRecords();
        ConsultantEvalutionListParm parm = new ConsultantEvalutionListParm();
        parm.setConsultantEvalutionList(consultantEvalutionList);
        return parm;
    }
}
