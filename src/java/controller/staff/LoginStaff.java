  
package controller.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staff;
import sql.StaffSQL;

@WebServlet(name = "LoginStaff", urlPatterns = {"/LoginStaff.do"})
public class LoginStaff extends HttpServlet {

private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String staffId = request.getParameter("staffId");
        String staffPass = request.getParameter("staffPass");
        
        Staff bean = new Staff();
        bean.setStaffId(staffId);
        bean.setStaffPass(staffPass);
        
       StaffSQL loginDao = new StaffSQL();
        
        String UserValidate = loginDao.authenticateUser(bean);
        
        if(UserValidate.equals("SUCCESS")){
            HttpSession session = request.getSession(true);

	    session.setAttribute("currentSessionUser", staffId);
            request.setAttribute("admIC", staffId);
            request.getRequestDispatcher("indexStaff.jsp").forward(request, response);
        } else{
            request.setAttribute("errMessage", UserValidate);
            request.getRequestDispatcher("loginStaff.jsp").forward(request, response);
        }
    }

}