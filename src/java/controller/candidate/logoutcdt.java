
/*@WebServlet(name = "logoutcdt", urlPatterns = {"/logoutcdt.do"})
public class logoutcdt extends HttpServlet {*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.candidate;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "logoutcdt", urlPatterns = {"/logoutcdt.do"})
public class logoutcdt extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if(session!= null){
            session.invalidate();
            request.setAttribute("errMessage", "You have logged out successfully!");
            request.getRequestDispatcher("logincdt.jsp").forward(request, response);
            System.out.println("Logged Out");
        }
    }
}
