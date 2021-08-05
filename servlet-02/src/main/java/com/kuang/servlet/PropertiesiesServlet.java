package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesiesServlet extends HttpServlet {
//    public void test() {
//        Properties properties = new Properties();
//        properties.load(); // a fixed path, not good for a web app since we are not sure the path for the resources
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        prop.load(in);
        resp.getWriter().println(prop.getProperty("username"));
    }
}
