/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Department {    
    private String dptid;
    private String dptPass;
    private String dptName;
    private String dptTell;
    private String dptAddress;
    private String dptEmail;
   

    public Department(){}
    
    public Department(String dptid, String dptPass, String dptName, String dptTell, String dptAddress, String dptEmail) {
        this.dptid = dptid;
        this.dptPass = dptPass;
        this.dptName = dptName;
        this.dptTell = dptTell;
        this.dptEmail = dptEmail;
        this.dptAddress = dptAddress;
    }

    public String getDptid() {
        return dptid;
    }

    public String getDptPass() {
        return dptPass;
    }

    public String getDptName() {
        return dptName;
    }

    public String getDptTell() {
        return dptTell;
    }

    public String getDptAddress() {
        return dptAddress;
    }

    public String getDptEmail() {
        return dptEmail;
    }

    public void setDptid(String dptid) {
        this.dptid = dptid;
    }

    public void setDptPass(String dptPass) {
        this.dptPass = dptPass;
    }

    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    public void setDptTell(String dptTell) {
        this.dptTell = dptTell;
    }

    public void setDptAddress(String dptAddress) {
        this.dptAddress = dptAddress;
    }

    public void setDptEmail(String dptEmail) {
        this.dptEmail = dptEmail;
    }

    
    
    
            
    
}
