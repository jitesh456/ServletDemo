import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        description = "login servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name ="name",value = "Jitesh"),
                @WebInitParam(name="password",value = "jitesh123")
        }
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String actualName = req.getParameter("username");
        String actualPassword = req.getParameter("password");
        String expectedName=getServletConfig().getInitParameter("name");
       String expectedPassword=getServletConfig().getInitParameter("password");

        if(actualName.equals(expectedName) && actualPassword.equals(expectedPassword)){
            req.setAttribute("username",actualName);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req,resp);
        }
        else{
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=resp.getWriter();
            out.println("<font color=red>Entered username or password is wrong</font>");
            dispatcher.include(req,resp);
        }
    }
}
