
/**/

package controller.department;

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
import model.Department;
import sql.DPTSQL;


@WebServlet(name = "updatedpt", urlPatterns = {"/updatedpt.do"})
public class updatedpt extends HttpServlet { 

    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            String dptid = request.getParameter("dptid");
            String dptPass = request.getParameter("dptPass");
            String dptName = request.getParameter("dptName");
            String dptTell = request.getParameter("dptTell");
            String dptEmail = request.getParameter("dptEmail");
            String dptAddress = request.getParameter("dptAddress");
            
            //form verification
            if(dptid==null || dptid.trim().length()==0){
                errorMsgs.add("Please enter your IC Number.");
            }
            if(dptName==null || dptName.trim().length()==0){
                errorMsgs.add("Please enter Name.");
            }
            if(dptTell==null || dptTell.trim().length()==0){
                errorMsgs.add("Please enter Phone Number.");
            }
            if(dptEmail==null || dptEmail.trim().length()==0){
                errorMsgs.add("Please enter Email.");
            }
            else if (!dptTell.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") &&
                     !dptTell.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid Phone Number.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/updatedpt.jsp");
                view.forward(request,response);
                return;
            }
            
            Department d = new Department(dptid,dptPass,dptName,dptTell,dptAddress, dptEmail);
            updatedpt(d);
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Update successful');");
                out.println("location='indexdpt.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/updatedpt.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/updatedpt.jsp");
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
    
    private void updatedpt(Department d) throws SQLException{
        DPTSQL dpt= new DPTSQL();
        dpt.updateDPT(d);
    }

}
