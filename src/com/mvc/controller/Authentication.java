package com.mvc.controller;

import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authentication extends HttpServlet {
    public Authentication() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RegisteredUser user = new RegisteredUser();
        HttpSession session = request.getSession();

        if(session != null){
            System.out.println("Session is not null");
            if(session.getAttribute("email") != null){
                System.out.println("Email:" + (String)session.getAttribute("email"));
                response.sendRedirect("accountPage.jsp");
            }
            else{
                response.sendRedirect("signin.jsp");
            }
        }

    }
}
