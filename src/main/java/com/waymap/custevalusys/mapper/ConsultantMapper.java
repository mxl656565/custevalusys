package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.Consultant;

public interface ConsultantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consultant record);

    int insertSelective(Consultant record);

    Consultant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consultant record);

    int updateByPrimaryKey(Consultant record);
}