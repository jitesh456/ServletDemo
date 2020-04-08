import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;


@WebServlet(
        description = "login servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name ="name",value = "Jitesh"),
                @WebInitParam(name="password",value = "Jites#12")
        }
)

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String actualName = req.getParameter("username");
        String actualPassword = req.getParameter("password");
        PrintWriter out=resp.getWriter();
        BufferedReader br= new BufferedReader(new FileReader("/home/jitesh/IdeaProjects/MyFirstServletProject/MyFirstServlet/src/main/resources/userData.txt"));
        String[] words = br.readLine().split(",");
        String expectedName =words[0];
        String expectedPassword = words[1];

        if(actualName.equals(expectedName) && actualPassword.equals(expectedPassword)){
            req.setAttribute("username",actualName);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req,resp);
        }
        else{
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color=red>Entered username or password is wrong</font>");

            dispatcher.include(req,resp);
        }
    }
}
