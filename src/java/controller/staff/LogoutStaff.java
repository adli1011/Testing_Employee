package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LogoutStaff", urlPatterns = {"/LogoutStaff.do"})
public class LogoutStaff extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if(session!= null){
            session.invalidate();
            request.setAttribute("errMessage", "You have logged out successfully!");
            request.getRequestDispatcher("loginStaff.jsp").forward(request, response);
            System.out.println("Logged Out");
        }
    }
}

