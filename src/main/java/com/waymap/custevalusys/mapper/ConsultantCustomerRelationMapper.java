package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.ConsultantCustomerRelation;
import com.waymap.custevalusys.model.ConsultantCustomerRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantCustomerRelationMapper {
    long countByExample(ConsultantCustomerRelationExample example);

    int deleteByExample(ConsultantCustomerRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConsultantCustomerRelation record);

    int insertSelective(ConsultantCustomerRelation record);

    List<ConsultantCustomerRelation> selectByExample(ConsultantCustomerRelationExample example);

    ConsultantCustomerRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConsultantCustomerRelation record, @Param("example") ConsultantCustomerRelationExample example);

    int updateByExample(@Param("record") ConsultantCustomerRelation record, @Param("example") ConsultantCustomerRelationExample example);

    int updateByPrimaryKeySelective(ConsultantCustomerRelation record);

    int updateByPrimaryKey(ConsultantCustomerRelation record);
}