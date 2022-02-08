
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.ConnectionManager;
import model.Department;

public class DPTSQL {
    String dptid,dptPass,dptName,dptTell,dptEmail,dptAddress;
       static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
        
        public String authenticateUser (Department loginBean){
        String dptid = loginBean.getDptid();
        String dptPass = loginBean.getDptPass();
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String sql = "SELECT DPTID, DPTPASS FROM DEPARTMENT";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while( resultSet.next()){
                userNameDB = resultSet.getString("dptid");
                passwordDB = resultSet.getString("dptPass");
                if(dptid.equals(userNameDB) && dptPass.equals(passwordDB) )
                    return "SUCCESS";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }    
        public boolean isExist(String cdtid) {
        String sql = "SELECT * FROM CANDIDATE WHERE CDTID = '" + cdtid + "'";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
   
        public boolean updateDPT(Department p){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE DEPARTMENT SET DPTPASS = ?, DPTNAME = ?, DPTTELL = ?, DPTADDRESS = ?,DPTEMAIL=? WHERE DPTID = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setString(1, p.getDptPass());
            pstmt.setString(2, p.getDptName());
            pstmt.setString(3, p.getDptTell());
            pstmt.setString(4, p.getDptAddress());
            pstmt.setString(5, p.getDptEmail());
            pstmt.setString(6, p.getDptid());
           
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
