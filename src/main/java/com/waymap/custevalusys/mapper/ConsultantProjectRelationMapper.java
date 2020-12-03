package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.ConsultantProjectRelation;
import com.waymap.custevalusys.model.ConsultantProjectRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantProjectRelationMapper {
    long countByExample(ConsultantProjectRelationExample example);

    int deleteByExample(ConsultantProjectRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConsultantProjectRelation record);

    int insertSelective(ConsultantProjectRelation record);

    List<ConsultantProjectRelation> selectByExample(ConsultantProjectRelationExample example);

    ConsultantProjectRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConsultantProjectRelation record, @Param("example") ConsultantProjectRelationExample example);

    int updateByExample(@Param("record") ConsultantProjectRelation record, @Param("example") ConsultantProjectRelationExample example);

    int updateByPrimaryKeySelective(ConsultantProjectRelation record);

    int updateByPrimaryKey(ConsultantProjectRelation record);
}