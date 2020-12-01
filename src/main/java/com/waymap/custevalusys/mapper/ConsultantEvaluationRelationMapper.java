package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.ConsultantEvaluationRelation;
import com.waymap.custevalusys.model.ConsultantEvaluationRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantEvaluationRelationMapper {
    long countByExample(ConsultantEvaluationRelationExample example);

    int deleteByExample(ConsultantEvaluationRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConsultantEvaluationRelation record);

    int insertSelective(ConsultantEvaluationRelation record);

    List<ConsultantEvaluationRelation> selectByExample(ConsultantEvaluationRelationExample example);

    ConsultantEvaluationRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConsultantEvaluationRelation record, @Param("example") ConsultantEvaluationRelationExample example);

    int updateByExample(@Param("record") ConsultantEvaluationRelation record, @Param("example") ConsultantEvaluationRelationExample example);

    int updateByPrimaryKeySelective(ConsultantEvaluationRelation record);

    int updateByPrimaryKey(ConsultantEvaluationRelation record);
}