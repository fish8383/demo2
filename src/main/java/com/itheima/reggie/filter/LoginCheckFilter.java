package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已完成登陆
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    //Spring的路径匹配工具类
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        //获取本次请求URI
//        String requestURI = request.getRequestURI();
//        log.info("拦截到请求：{}", request.getRequestURI());
//
//        //不需处理的URI的数组
//        String[] urls = new String[]{"/employee/login",
//                "/employee/logout",
//                "/backend/**",
//                "/front/**",
//                "/common/**",
//                "/user/sendMsg",
//                "/user/login"
//        };
//
//        //判断路径是否需要处理
//        boolean check = check(urls, requestURI);
//
//        //页面不需处理的判断
//        if (check) {
//            filterChain.doFilter(request, response);
////            log.info("请求不需要处理：{}", request.getRequestURI());
//            return;
//        }
//
//        //已登陆放行的判断
//        if (null != request.getSession().getAttribute("employee")) {
//            Long employeeID = (Long) request.getSession().getAttribute("employee");
//            BaseContext.SetCurrentId(employeeID);
//            filterChain.doFilter(request, response);
////            log.info("登陆用户ID：{}", request.getSession().getAttribute("employee"));
//            return;
//        }
//        if (null != request.getSession().getAttribute("user")) {
//            Long userID = (Long) request.getSession().getAttribute("user");
//            BaseContext.SetCurrentId(userID);
            filterChain.doFilter(request, response);
//            log.info("登陆用户ID：{}", request.getSession().getAttribute("employee"));
//            return;
//        }
//        //用户未登陆，返回MSG到前端页面，前端页面JS根据R.MSG跳转到登陆页面
////        log.info("用户未登陆");
//        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
//        return;

    }

    /**
     * 匹配路径，是否放行
     *
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean b = PATH_MATCHER.match(url, requestURI);
            if (b) {
                return true;
            }
        }
        return false;
    }
}
