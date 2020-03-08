package com.mayou.community.config;

/**
 * @Author: yfzhang
 * @Description:
 * @Date: Created in 5:06 PM 2020/3/6
 * @Modified By:
 */
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 配置监控拦截器, druid监控拦截器
 */
@WebFilter(filterName="druidWebStatFilter",
        urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"), // 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {

}
