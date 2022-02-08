/*

*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.candidate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Candidate;
import sql.CDTSQL;



@WebServlet(name = "logincdt", urlPatterns = {"/logincdt.do"})
public class logincdt extends HttpServlet {

private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cdtid = request.getParameter("cdtid");
        String cdtPass = request.getParameter("cdtPass");
        
        Candidate bean = new Candidate();
        bean.setCdtid(cdtid);
        bean.setCdtPass(cdtPass);
        
       CDTSQL loginDao = new CDTSQL();
        
        String UserValidate = loginDao.authenticateUser(bean);
        
        if(UserValidate.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	    session.setAttribute("currentSessionUser", cdtid);
            request.setAttribute("admIC", cdtid);
            request.getRequestDispatcher("indexcdt.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", UserValidate);
            request.getRequestDispatcher("logincdt.jsp").forward(request, response);
        }
    }

}


