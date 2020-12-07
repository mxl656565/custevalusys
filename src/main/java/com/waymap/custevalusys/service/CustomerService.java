/**
 * 公司:
 * 文件名:CustomerService
 * 作者：Tiger
 * 时间：2020/11/30 17:15
 * 描述：
 */
package com.waymap.custevalusys.service;

import com.waymap.custevalusys.dto.CreateCountParm;
import com.waymap.custevalusys.dto.CustLoginParm;
import com.waymap.custevalusys.dto.ResetPasswordParam;
import com.waymap.custevalusys.model.Customer;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author : tiger
 * @description : 用户service
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/30
 */
public interface CustomerService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 生成的Jtw的token
     */
    String login(String username,String password);

    /**
     * 添加账号
     */
    Customer createCount(CreateCountParm createCountParm);

    /**
     * 通过username获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    Customer getCustByUsername(String username);

    /**
     * 添加客户的意见反馈
     * @param customer 客户
     */
    void insertCustomerFeedBack(Customer customer);

    /**
     * 刷新token
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    Customer getCustById(Integer id);

    /**
     * 修改密码
     * @param updatePasswordParam
     * @return 修改成功返回1，失败返回0
     */
    int updatePassword(ResetPasswordParam updatePasswordParam);

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return security的UserDetails
     */
    UserDetails getUserDetailsByusername(String username);
}
