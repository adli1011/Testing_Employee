package model;

public class Staff {    
    private String staffId;
    private String staffPass;
    private String staffName;
    private String staffTel;
    private String staffMail;
    private String staffAddress;
    private String dptid;

    public Staff(){}
    public Staff(String staffId, String staffPass, String staffName, String staffTel, String staffAddress ,String staffMail, String dptid) {
        this.staffId = staffId;
        this.staffPass = staffPass;
        this.staffName = staffName;
        this.staffTel = staffTel;
        this.staffAddress = staffAddress;
        this.staffMail = staffMail;
        this.dptid = dptid;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTel() {
        return staffTel;
    }

    public void setStaffTel(String staffTel) {
        this.staffTel = staffTel;
    }

    public String getStaffEMail() {
        return staffMail;
    }

    public void setStaffMail(String staffMail) {
        this.staffMail = staffMail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getDptid() {
        return dptid;
    }

    public void setDptid(String dptid) {
        this.dptid = dptid;
    }
    
    
}
