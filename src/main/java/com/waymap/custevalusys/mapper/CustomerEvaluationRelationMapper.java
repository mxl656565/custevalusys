package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.CustomerEvaluationRelation;
import com.waymap.custevalusys.model.CustomerEvaluationRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerEvaluationRelationMapper {
    long countByExample(CustomerEvaluationRelationExample example);

    int deleteByExample(CustomerEvaluationRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerEvaluationRelation record);

    int insertSelective(CustomerEvaluationRelation record);

    List<CustomerEvaluationRelation> selectByExample(CustomerEvaluationRelationExample example);

    CustomerEvaluationRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerEvaluationRelation record, @Param("example") CustomerEvaluationRelationExample example);

    int updateByExample(@Param("record") CustomerEvaluationRelation record, @Param("example") CustomerEvaluationRelationExample example);

    int updateByPrimaryKeySelective(CustomerEvaluationRelation record);

    int updateByPrimaryKey(CustomerEvaluationRelation record);
}