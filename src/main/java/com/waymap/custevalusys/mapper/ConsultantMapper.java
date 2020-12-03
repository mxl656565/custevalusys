package com.waymap.custevalusys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waymap.custevalusys.model.Consultant;
import com.waymap.custevalusys.model.ConsultantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultantMapper extends BaseMapper<Consultant> {
    long countByExample(ConsultantExample example);

    int deleteByExample(ConsultantExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Consultant record);

    List<Consultant> selectByExample(ConsultantExample example);

    Consultant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Consultant record, @Param("example") ConsultantExample example);

    int updateByExample(@Param("record") Consultant record, @Param("example") ConsultantExample example);

    int updateByPrimaryKeySelective(Consultant record);

    int updateByPrimaryKey(Consultant record);
}