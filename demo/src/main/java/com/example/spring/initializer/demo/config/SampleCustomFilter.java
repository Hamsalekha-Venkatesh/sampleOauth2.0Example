package com.example.spring.initializer.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Component
public class SampleCustomFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init method initialized");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter method initialized");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Principal userPrinciple = request.getUserPrincipal();
        System.out.println("userPrinicple::" + userPrinciple);
    }

    @Override
    public void destroy() {
        System.out.println("destroy method initialized");
    }
}
