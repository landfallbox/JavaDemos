package com.example.springbootdemo.config;

import java.io.PrintWriter;


import com.example.springbootdemo.entity.Admins;
import com.example.springbootdemo.util.AdminsJwtUtils;
import com.example.springbootdemo.util.AdminsUtils;
import com.example.springbootdemo.util.ResultCode;
import com.example.springbootdemo.util.WebResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Component
public class AdminsLoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AdminsLoginInterceptor.class);
    /**
     * 在请求处理之前进行调用即调用Controller方法之前，若返回true请求将会继续执行后面的操作
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String token = request.getHeader("token");
        // 如果不是映射到方法不拦截 直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        // 验证token
        if(StringUtils.isEmpty(token) || !AdminsJwtUtils.verify(token)){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("applicaion/json; charset=utf-8");
              // 设置响应状态码 401 未授权访问
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            try{
                PrintWriter writer = response.getWriter();
                WebResult webResult = new WebResult();
                webResult.setCode(ResultCode.Failure.value());
                webResult.setMessage("没有权限访问");
                writer.print(JSON.toJSONString(webResult));
            }catch(Exception ex){
                logger.error("login token error is {}", ex.getMessage());
            }
            return false;
        }
        // 若token验证成功，把用户信息存储在ThreadLocal
        Admins admins = AdminsJwtUtils.getAdminsByToken(token);
        AdminsUtils.storeAdmins(admins);
        return true;
    }
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前即调用Controller方法之后
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了拦截器的postHandler方法");
    }
    /**
     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        // 清除线程变量
        // 将preHandle中存入ThreadLocal中的用户清除
        AdminsUtils.removeAdmins();
    }
}
