package ua.yakov;

import org.springframework.stereotype.Controller;
import ua.yakov.DaoService;
import ua.yakov.UserPass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "log", urlPatterns = "/log")
public class ServlLog extends HttpServlet {

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CommandFactory factory = CommandFactory.getInstance();
        Command com = factory.getCommand("login");
        String page = com.execute(request, response);

        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }*/
}
