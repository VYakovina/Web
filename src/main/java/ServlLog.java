import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServlLog extends HttpServlet {

    DaoService daoService = new DaoService();
    UserPass user = new UserPass();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("logCustomer")!=null) {

            String userName = request.getParameter("userName");
            String userPass = request.getParameter("userPass");



            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
