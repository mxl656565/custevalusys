package com.waymap.custevalusys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waymap.custevalusys.model.Evaluation;
import com.waymap.custevalusys.model.EvaluationExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface EvaluationMapper extends BaseMapper<Evaluation> {
    long countByExample(EvaluationExample example);

    int deleteByExample(EvaluationExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Evaluation record);

    List<Evaluation> selectByExample(EvaluationExample example);

    Integer insertOneRecAndGetId(Evaluation evaluation);

    Evaluation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByExample(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}