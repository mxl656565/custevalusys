/**
 * 公司:
 * 文件名:ProjectService
 * 作者：Tiger
 * 时间：2020/11/30 17:15
 * 描述：
 */
package com.waymap.custevalusys.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.waymap.custevalusys.model.Consultant;
import com.waymap.custevalusys.model.Project;

import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/30
 */
public interface ProjectService {
    /**
     * 通过项目名称查询项目
     */
    Project findProjectByProjectName(String projectName);

    /**
     * 插入新的项目
     */
    int insertProject(Project project);

    /**
     * 查询该项目下有哪些顾问
     */
    List<Consultant> selectConsultantInProject(Integer projectId);
}
