package com.example.web;

import com.example.ejb.GreetingRemote;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            InitialContext ctx = new InitialContext();

            GreetingRemote remote = (GreetingRemote) ctx.lookup("java:global.ejb3-maven-app.com.example-web-module-1.0-SNAPSHOT.GreetingBean!com.example.ejb.GreetingRemote");
            String message = remote.sayHello("WebLogic User");

            resp.getWriter().write(message);
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }
}

