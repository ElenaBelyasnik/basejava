package ru.javawebinar.basejava.web;

import javax.servlet.*;
import java.io.IOException;

// https://www.baeldung.com/tomcat-utf-8
public class CharacterSetFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
    }
}
