

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




@WebServlet(name = "deletecdt", urlPatterns = {"/deletecdt.do"})
public class deletecdt extends HttpServlet {

    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cdtid = request.getParameter("cdtid");
    
        
        
        CDTSQL deleteDao = new CDTSQL();
        
        String deletevalid = deleteDao.deletecCDT(cdtid);
        
        if(deletevalid.equals("user deleted"))
        {
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Delete successful');");
                out.println("location='indexAdmin.jsp';");
                out.println("</script>");
            }
        }
        else
        {
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Failed');");
                out.println("location='indexAdmin.jsp';");
                out.println("</script>");
            }
        }
        ;
        
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
    
  

    

}

