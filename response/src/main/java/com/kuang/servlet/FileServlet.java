package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取下载文件的路径
        String realPath = "/Users/yinong/IdeaProjects/javaweb-02-servlet/response/src/main/resources/photo.png";
        //this.getServletContext().getRealPath("/photo.png"); // use this one will get the path of tomcat folder
        System.out.println("File path: " + realPath);
        // 下载的文件名是啥
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
        // 设置想办法让浏览器能够支持下载我们需要的东西？？ 为什么需要浏览器支持？
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        // 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 获取outputstream对象
        ServletOutputStream out = resp.getOutputStream();
        // 将file output stream流写入buffer缓冲区，使用output stream将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        // 把流关闭
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
