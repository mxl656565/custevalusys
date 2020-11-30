package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.ConsultantEvaluationRelation;

public interface ConsultantEvaluationRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsultantEvaluationRelation record);

    int insertSelective(ConsultantEvaluationRelation record);

    ConsultantEvaluationRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsultantEvaluationRelation record);

    int updateByPrimaryKey(ConsultantEvaluationRelation record);
}