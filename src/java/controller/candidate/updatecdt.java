
package controller.candidate;

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
import model.Candidate;
import sql.CDTSQL;




@WebServlet(name = "updatecdt", urlPatterns = {"/updatecdt.do"})
public class updatecdt extends HttpServlet {

    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            String cdtId = request.getParameter("cdtid");
            String cdtPass = request.getParameter("cdtPass");
            String cdtName = request.getParameter("cdtName");
            String cdtTell = request.getParameter("cdtTell");
            String cdtEmail = request.getParameter("cdtEmail");
            String cdtAddress = request.getParameter("cdtAddress");
            
            //form verification
            if(cdtId==null || cdtId.trim().length()==0){
                errorMsgs.add("Please enter your IC Number.");
            }
            if(cdtName==null || cdtName.trim().length()==0){
                errorMsgs.add("Please enter Name.");
            }
            if(cdtTell==null || cdtTell.trim().length()==0){
                errorMsgs.add("Please enter Phone Number.");
            }
            if(cdtEmail==null || cdtEmail.trim().length()==0){
                errorMsgs.add("Please enter Email.");
            }
            else if (!cdtTell.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") &&
                     !cdtTell.trim().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid Phone Number.");
            }
            
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs",errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/updatecdt.jsp");
                view.forward(request,response);
                return;
            }
            
            Candidate d = new Candidate(cdtId,cdtPass,cdtName,cdtTell,cdtAddress, cdtEmail);
            updatecdt(d);
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Update successful');");
                out.println("location='indexcdt.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/updatecdt.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/updatecdt.jsp");
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
    
    private void updatecdt(Candidate d) throws SQLException{
        CDTSQL cdt= new CDTSQL();
        cdt.updateCDT(d);
    }

    

}
