import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("name");
        String password=req.getParameter("password");
        PrintWriter printWriter=resp.getWriter();
        Boolean valid=true;
        String VALIDATE_USER_NAME="^[A-Z]{1}[a-z]{2,}$";
        String VALIDATE_PASSWORD= "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[^$@!#%*?&]*[$#@!%*?&][^$@!#%*?&]*$).{8,}$";

        if(userName.matches(VALIDATE_USER_NAME)==false) {
            printWriter.println("<font color=red>Username must start with caps and contain 3 character</font><br>");
            valid=false;
        }
        if(password.matches(VALIDATE_PASSWORD)==false) {
            printWriter.println("<font color=red>Password must Have at least 1 UpperCase </font><br>");
            printWriter.println("<font color=red>At least 1 Lower Case,</font><br>");
            printWriter.println("<font color=red>At least 1 numeric and exactly 1 special character,</font><br>");
            printWriter.println("<font color=red>Password must have minimum 8 character</font><br>");
            valid=false;
        }
        if(valid==true)
        {
            File file=new File("/home/jitesh/IdeaProjects/MyFirstServletProject/MyFirstServlet/src/main/resources/userData.txt");
            file.createNewFile();
            FileWriter fr=new FileWriter(file);
            fr.write(userName);
            fr.write(",");
            fr.write(password);
            fr.close();
        }

        if(valid!=true) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.html");
            dispatcher.include(req, resp);
        }
        else {
            printWriter.println("<font color=green> Registration Success</font>");
            RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/login.html");
            dispatcher2.include(req, resp);
        }

    }

}
