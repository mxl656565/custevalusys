/**
 * 公司:
 * 文件名:CorsConfig
 * 作者：Tiger
 * 时间：2020/11/10 16:44
 * 描述：
 */
package com.waymap.custevalusys.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/11/10
 */

/**
 * Created by tim on 2018/7/30.
 * 解决浏览器全局跨域的问题
 */
@SuppressWarnings("all")
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE","OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }
}
