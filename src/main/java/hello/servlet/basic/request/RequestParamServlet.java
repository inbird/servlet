package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Call URL : http://localhost:8080/request-param?username=hong&age=35&username=kim

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("All Parameter - Start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName-> System.out.println(paramName + ":" + request.getParameter(paramName)));
        System.out.println("All Parameter - End");
        System.out.println();
        System.out.println("Some Parameter - Start");
        System.out.println("username = " + request.getParameter("username"));
        System.out.println("age = " + request.getParameter("age"));
        System.out.println("Some Parameter - End");
        System.out.println();
        System.out.println("Same Parameter - Start");
        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        System.out.println("Same Parameter - End");

        response.getWriter().write("OK!!!");

    }
}
