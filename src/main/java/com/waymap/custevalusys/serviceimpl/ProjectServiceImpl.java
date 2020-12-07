/**
 * 公司:
 * 文件名:ProjectServiceImpl
 * 作者：Tiger
 * 时间：2020/12/2 17:32
 * 描述：
 */
package com.waymap.custevalusys.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waymap.custevalusys.mapper.ConsultantMapper;
import com.waymap.custevalusys.mapper.ConsultantProjectRelationMapper;
import com.waymap.custevalusys.mapper.ProjectMapper;
import com.waymap.custevalusys.model.Consultant;
import com.waymap.custevalusys.model.ConsultantProjectRelation;
import com.waymap.custevalusys.model.ConsultantProjectRelationExample;
import com.waymap.custevalusys.model.Project;
import com.waymap.custevalusys.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/2
 */
@Service
@SuppressWarnings("all")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ConsultantMapper consultantMapper;
    @Autowired
    private ConsultantProjectRelationMapper consultantProjectRelationMapper;
    @Override
    public Project findProjectByProjectName(String projectName) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("projectname",projectName);
        return projectMapper.selectOne(queryWrapper);
    }

    @Override
    public int insertProject(Project project) {
        return projectMapper.insertOneRecAndGetId(project);
    }

    @Override
    public List<Consultant> selectConsultantInProject(Integer projectId) {
        List<Integer> consultantId = consultantProjectRelationMapper.selectConsultantInProject(projectId);
        List<Consultant> consultants = new ArrayList<>();
        for(int i=0;i<consultantId.size();i++){
            Consultant consultant = consultantMapper.selectByPrimaryKey(consultantId.get(i));
            consultants.add(consultant);
        }
        return consultants;
    }
}
