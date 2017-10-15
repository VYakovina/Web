import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ServlReg extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CommandFactory factory = CommandFactory.getInstance();
        Command com = factory.getCommand("registration");
        String page = com.execute(request, response);

            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
        }
    }


