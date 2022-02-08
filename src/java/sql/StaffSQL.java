package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.ConnectionManager;
import model.Staff;

public class StaffSQL {
    String staffId,staffPass,staffName,staffTel,staffEMail,staffAddress;
    static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
        
        public String authenticateUser (Staff loginBean){
        String staffId = loginBean.getStaffId();
        String staffPass = loginBean.getStaffPass();
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String sql = "SELECT STAFFID, STAFFPASS FROM STAFF";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while( resultSet.next()){
                userNameDB = resultSet.getString("staffId");
                passwordDB = resultSet.getString("staffPass");
                if(staffId.equals(userNameDB) && staffPass.equals(passwordDB) )
                    return "SUCCESS";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }    
        public boolean isExist(String staffId) {
        String sql = "SELECT * FROM STAFF WHERE STAFFID = '" + staffId + "'";
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
       
    
        
        public boolean updateStaff(Staff s){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE STAFF SET STAFFNAME = ?, STAFFTEL = ?, STAFFADDRESS = ?, STAFFMAIL = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setString(1, s.getStaffName());
            pstmt.setString(2, s.getStaffTel());
            pstmt.setString(3, s.getStaffAddress());
            pstmt.setString(4, s.getStaffEMail());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
