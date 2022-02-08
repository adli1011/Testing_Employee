package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Staff;
import sql.StaffSQL;

@WebServlet(name = "updateStaff", urlPatterns = {"/updateStaff.do"})
public class updateStaff extends HttpServlet {

    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            String staffId = request.getParameter("staffId");
            String staffPass = request.getParameter("staffPass");
            String staffName = request.getParameter("staffName");
            String staffTel = request.getParameter("staffTel");
            String staffAddress = request.getParameter("staffAddress");
            String staffMail = request.getParameter("staffMail");
            String dptid = request.getParameter("dptid");
            
            //form verification
            if(staffId==null || staffId.trim().length()==0){
                errorMsgs.add("Please enter your staff ID.");
            }
            if(staffName==null || staffName.trim().length()==0){
                errorMsgs.add("Please enter Name.");
            }
            if(staffTel==null || staffTel.trim().length()==0){
                errorMsgs.add("Please enter Phone Number.");
            }
            if(staffMail==null || staffMail.trim().length()==0){
                errorMsgs.add("Please enter Email.");
            }

            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/updateStaff.jsp");
                view.forward(request,response);
                return;
            }
            
            Staff d = new Staff(staffId, staffPass, staffName,staffTel, staffAddress, staffMail, dptid);
            updateStaff(d);
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Update successful');");
                out.println("location='indexStaff.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/updateStaff.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/updateStaff.jsp");
            view.forward(request,response);
        }
    }

    private void initializeJdbc(){
        try{
            //declare driver and connection string
            String driver = "org.apache.derby.jdbc.ClientDriver";
            //load the driver
            Class.forName(driver);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void updateStaff(Staff s) throws SQLException{
        StaffSQL staff= new StaffSQL();
        staff.updateStaff(s);
    }

}

