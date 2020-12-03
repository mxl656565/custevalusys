/**
 * 公司:
 * 文件名:ProjectServiceImpl
 * 作者：Tiger
 * 时间：2020/12/2 17:32
 * 描述：
 */
package com.waymap.custevalusys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waymap.custevalusys.mapper.ProjectMapper;
import com.waymap.custevalusys.model.Project;
import com.waymap.custevalusys.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/2
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Project findProjectByProjectName(String projectName) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("projectname",projectName);
        return projectMapper.selectOne(queryWrapper);
    }

    @Override
    public int insertProject(Project project) {
        return projectMapper.insert(project);
    }
}
