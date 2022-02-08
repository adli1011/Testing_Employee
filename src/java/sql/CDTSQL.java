/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.ConnectionManager;
import model.Candidate;

public class CDTSQL {
    String cdtid,cdtPass,cdtName,cdtTell,cdtEmail,cdtAddress;
       static Connection con = null;
        static ResultSet rs = null;
        static PreparedStatement ps=null;
        static Statement stmt=null;
        
        public String authenticateUser (Candidate loginBean){
        String cdtid = loginBean.getCdtid();
        String cdtPass = loginBean.getCdtPass();
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String sql = "SELECT CDTID, CDTPASS FROM CANDIDATE";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while( resultSet.next()){
                userNameDB = resultSet.getString("cdtid");
                passwordDB = resultSet.getString("cdtPass");
                if(cdtid.equals(userNameDB) && cdtPass.equals(passwordDB) )
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
        public boolean registerCDT(Candidate p){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "INSERT INTO CANDIDATE (cdtid,cdtPass,cdtName,cdtTell,cdtAddress,cdtEmail) " +
                         "VALUES (?,?,?,?,?,?)";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, p.getCdtid());
            pstmt.setString(2, p.getCdtPass());
            pstmt.setString(3, p.getCdtName());
            pstmt.setString(4, p.getCdtTell());
            pstmt.setString(5, p.getCdtAddress());
            pstmt.setString(6, p.getCdtEmail());
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        public boolean updateCDT(Candidate p){
        Connection conn;
        PreparedStatement pstmt;
        String sql = "UPDATE CANDIDATE SET CDTPASS = ?, CDTNAME = ?, CDTTELL = ?, CDTADDRESS = ?,CDTEMAIL=? WHERE CDTID = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setString(1, p.getCdtPass());
            pstmt.setString(2, p.getCdtName());
            pstmt.setString(3, p.getCdtTell());
            pstmt.setString(4, p.getCdtAddress());
            pstmt.setString(5, p.getCdtEmail());
            pstmt.setString(6, p.getCdtid());
           
            pstmt.executeUpdate();
            
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
        public String search (Candidate loginBean){
        String cdtid = loginBean.getCdtid();
        
        
        Connection con=null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        String sql = "SELECT CDTID FROM CANDIDATE";
        try{
            con = ConnectionManager.getConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while( resultSet.next()){
                userNameDB = resultSet.getString("cdtid");
                
                if(cdtid.equals(userNameDB))
                    return "SUCCESS";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }    
        public String deletecCDT(String cdtid){
            String deletest="user not deleted";
        Connection conn = null;
        PreparedStatement pstmt;
        String sql = "DELETE FROM CANDIDATE WHERE CDTID = ?";
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,cdtid);
            pstmt.executeUpdate();
            deletest = "user deleted";
            return deletest;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return deletest;}
}
