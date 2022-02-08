


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



@WebServlet(name = "cdtsearch", urlPatterns = {"/cdtsearch.do"})
public class cdtsearch extends HttpServlet {

private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cdtid = request.getParameter("cdtid");
        
        
        Candidate bean = new Candidate();
        bean.setCdtid(cdtid);
        
        
       CDTSQL loginDao = new CDTSQL();
        
        String Search = loginDao.search(bean);
        
        if(Search.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	     session.setAttribute("searchcandidate", cdtid);
            request.setAttribute("admIC", cdtid);
            request.getRequestDispatcher("cdtform.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", Search);
            request.getRequestDispatcher("cdtadminsearch.jsp").forward(request, response);
        }
    }

}



