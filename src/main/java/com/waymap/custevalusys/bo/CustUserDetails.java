/**
 * 公司:
 * 文件名:CustUserDetails
 * 作者：Tiger
 * 时间：2020/12/1 15:25
 * 描述：
 */
package com.waymap.custevalusys.bo;

import com.waymap.custevalusys.model.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author : tiger
 * @description :  配置security的核心用户信息
 * @email : tiger.liu@waymap.cn
 * @date : 2020/12/1
 */
public class CustUserDetails implements UserDetails {

    private Customer customer;
    private Collection<GrantedAuthority> authorities;
    public CustUserDetails(){
    }
    public CustUserDetails(Customer customer){
        this.customer = customer;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
