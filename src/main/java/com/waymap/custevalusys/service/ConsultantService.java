/**
 * 公司:
 * 文件名:ConsultantService
 * 作者：Tiger
 * 时间：2020/11/30 17:15
 * 描述：
 */
package com.waymap.custevalusys.service;

import com.waymap.custevalusys.dto.CreateConsultantParm;
import com.waymap.custevalusys.model.Consultant;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/30
 */
public interface ConsultantService {
    /**
     * 创建顾问
     * @param createConsultant dto对象
     * @return 顾问对象
     */
    Consultant addConsultant(CreateConsultantParm createConsultant);

    /**
     * 通过顾问名获取顾问信息
     * @param consultantName 顾问名
     * @return 顾问对象
     */
    Consultant findConsultantByName(String consultantName);

    /**
     * 通过顾问id查询是否存在这个顾问
     * @param consultantId 顾问id
     * @return 是否存在
     */
    boolean queryConsultantIsExists(Integer consultantId);
}
