/*
@WebServlet(name = "Registercdt", urlPatterns = {"/Registercdt.do"})
public class Registercdt extends HttpServlet {
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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



@WebServlet(name = "Registercdt", urlPatterns = {"/Registercdt.do"})
public class Registercdt extends HttpServlet {

    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        try{
            String cdtId = request.getParameter("cdtId");
            String cdtPass = request.getParameter("cdtPass");
            String cdtPassCom = request.getParameter("cdtPassCom");
            String cdtName = request.getParameter("cdtName");
            String cdtTell = request.getParameter("cdtTell");
            String cdtEmail = request.getParameter("cdtEmail");
            String cdtAddress = request.getParameter("cdtAddress");
            
            //form verification
            if(cdtId==null || cdtId.trim().length()==0){
                errorMsgs.add("Please enter your IC Number.");
            }
            else if(new CDTSQL().isExist(cdtId)) {
                errorMsgs.add("Donor with the same IC already existed.");
            }
            if(cdtPass==null || cdtPass.trim().length()==0){
                errorMsgs.add("Please enter the password for login.");
            }
            else if(cdtPassCom==null || cdtPassCom.trim().length()==0){
                errorMsgs.add("Please confirm the password.");
            }
            else if(!cdtPass.equals(cdtPassCom)){
                errorMsgs.add("Entered password does not match.");
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
                RequestDispatcher view = request.getRequestDispatcher("/cdtregisteration.jsp");
                view.forward(request,response);
                return;
            }
            
            Candidate d = new Candidate(cdtId,cdtPass,cdtName,cdtTell,cdtAddress, cdtEmail);
            register(d);
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Register successful');");
                out.println("location='logincdt.jsp';");
                out.println("</script>");
            }
            
        } catch(RuntimeException e){
            errorMsgs.add("An unexpected error:" + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/cdtregisteration.jsp");
            view.forward(request,response);
        }catch (Exception ex){
            errorMsgs.add("Error: " + ex.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/cdtregisteration.jsp");
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
    
    private void register(Candidate candidate) throws SQLException{
        CDTSQL cdt = new CDTSQL();
        cdt.registerCDT(candidate);    
    }

}
