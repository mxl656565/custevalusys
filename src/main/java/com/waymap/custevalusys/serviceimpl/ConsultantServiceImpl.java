/**
 * 公司:
 * 文件名:ConsultantServiceImpl
 * 作者：Tiger
 * 时间：2020/12/3 14:14
 * 描述：
 */
package com.waymap.custevalusys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waymap.custevalusys.common.Asserts;
import com.waymap.custevalusys.dto.CreateConsultantParm;
import com.waymap.custevalusys.mapper.ConsultantMapper;
import com.waymap.custevalusys.mapper.ConsultantProjectRelationMapper;
import com.waymap.custevalusys.model.*;
import com.waymap.custevalusys.service.ConsultantService;
import com.waymap.custevalusys.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/3
 */
@Service
@SuppressWarnings("all")
public class ConsultantServiceImpl implements ConsultantService {
    @Autowired
    private ConsultantMapper consultantMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ConsultantProjectRelationMapper consultantProjectRelationMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantServiceImpl.class);

    @Override
    public Consultant addConsultant(CreateConsultantParm createConsultant) {
            Consultant consultant = new Consultant();
        try {
            Project project = projectService.findProjectByProjectName(createConsultant.getProjectname());
            if(project == null){
                Asserts.fail("没有此项目,请输入正确的项目名");
            }
            consultant = findConsultantByName(createConsultant.getName());
            ConsultantProjectRelation consultantProjectRelation = new ConsultantProjectRelation();
            //没有此顾问,创建顾问,并维护顾问和项目关系表
            if(consultant == null){
                Consultant newConsultant = new Consultant();
                newConsultant.setName(createConsultant.getName());
                consultantMapper.insert(newConsultant);
                newConsultant = findConsultantByName(newConsultant.getName());
                consultantProjectRelation.setConsultantId(newConsultant.getId())
                                         .setProjectId(project.getId());
                consultantProjectRelationMapper.insert(consultantProjectRelation);
                return newConsultant;
            }else{
                //有此顾问,查询顾问和项目的关系表中是否已有记录
                ConsultantProjectRelationExample example = new ConsultantProjectRelationExample();
                example.createCriteria().andConsultantIdEqualTo(consultant.getId()).andProjectIdEqualTo(project.getId());
                List<ConsultantProjectRelation> relations = consultantProjectRelationMapper.selectByExample(example);
                //有记录
                if(relations.size()>0){
                    return null;
                }
                //没有则创建记录
                consultantProjectRelation.setConsultantId(consultant.getId())
                                         .setProjectId(project.getId());
                consultantProjectRelationMapper.insert(consultantProjectRelation);
            }
        }catch (Exception e){
            LOGGER.warn("创建顾问异常:{}",e.getMessage());
        }
        return consultant;
    }

    @Override
    public Consultant findConsultantByName(String consultantName) {
        QueryWrapper<Consultant> queryWrapper =  new QueryWrapper<>();
        queryWrapper.eq("name",consultantName);
        return consultantMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean queryConsultantIsExists(Integer consultantId) {
        Consultant consultant = consultantMapper.selectByPrimaryKey(consultantId);
        if(consultant != null){
            return true;
        }
        return false;
    }
}
