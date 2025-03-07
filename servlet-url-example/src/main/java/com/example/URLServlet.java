package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        String protocol = req.getParameter("protocol");

        if(protocol == null)
            protocol="https";

        String host = req.getParameter("host");

        if(host == null)
             host = "example.com";

        String sPort = req.getParameter("port");

        int port = 443;
        if(sPort != null)
            port=Integer.parseInt(sPort);

        String file = "/";

        URL url = new URL(protocol, host, port, file);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        resp.setContentType("text/html");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             PrintWriter out = resp.getWriter()) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
        }
    }
}

