package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.ConsultantCustomerRelation;

public interface ConsultantCustomerRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsultantCustomerRelation record);

    int insertSelective(ConsultantCustomerRelation record);

    ConsultantCustomerRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsultantCustomerRelation record);

    int updateByPrimaryKey(ConsultantCustomerRelation record);
}