
/*@WebServlet(name = "logindpt", urlPatterns = {"/logindpt.do"})
public class logindpt extends HttpServlet {*/
/*

*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.department;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Department;
import sql.DPTSQL;




@WebServlet(name = "logindpt", urlPatterns = {"/logindpt.do"})
public class logindpt extends HttpServlet {

private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dptid = request.getParameter("dptid");
        String dptPass = request.getParameter("dptPass");
        
        Department bean = new Department();
        bean.setDptid(dptid);
        bean.setDptPass(dptPass);
        
        DPTSQL loginDao = new DPTSQL();
        
        String UserValidate = loginDao.authenticateUser(bean);
        
        if(UserValidate.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	    session.setAttribute("currentSessionUser", dptid);
            request.setAttribute("admIC", dptid);
            request.getRequestDispatcher("indexdpt.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", UserValidate);
            request.getRequestDispatcher("logindpt.jsp").forward(request, response);
        }
    }

}


