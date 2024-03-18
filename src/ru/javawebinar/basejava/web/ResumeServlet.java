package ru.javawebinar.basejava.web;

import javax.servlet.http.*;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        //response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.getWriter().write(name == null ? "Hello Resumes!" : "Hello " + name + "!");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) {

    }
}
