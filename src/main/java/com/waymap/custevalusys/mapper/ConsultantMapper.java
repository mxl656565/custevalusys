package com.waymap.custevalusys.mapper;

import com.waymap.custevalusys.model.Consultant;
import com.waymap.custevalusys.model.ConsultantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantMapper {
    long countByExample(ConsultantExample example);

    int deleteByExample(ConsultantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Consultant record);

    int insertSelective(Consultant record);

    List<Consultant> selectByExample(ConsultantExample example);

    Consultant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Consultant record, @Param("example") ConsultantExample example);

    int updateByExample(@Param("record") Consultant record, @Param("example") ConsultantExample example);

    int updateByPrimaryKeySelective(Consultant record);

    int updateByPrimaryKey(Consultant record);
}