package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //staus
        response.setStatus(HttpServletResponse.SC_OK);

        //header
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("my-header","hello~~");

        Cookie cookie = new Cookie("myCookie", "good!!");
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        PrintWriter writer = response.getWriter();
        writer.write("OK!!!");
        writer.write("안녕하세요!!!");



    }
}
