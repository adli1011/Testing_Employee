
package model;


public class Candidate {    
    private String cdtid;
    private String cdtPass;
    private String cdtName;
    private String cdtTell;
    private String cdtEmail;
    private String cdtAddress;

    public Candidate(){}
    
    public Candidate(String cdtid, String cdtPass, String cdtName, String cdtTell, String cdtAddress, String cdtEmail) {
        this.cdtid = cdtid;
        this.cdtPass = cdtPass;
        this.cdtName = cdtName;
        this.cdtTell = cdtTell;
        this.cdtEmail = cdtEmail;
        this.cdtAddress = cdtAddress;
    }

    public String getCdtid() {
        return cdtid;
    }

    public String getCdtPass() {
        return cdtPass;
    }

    public String getCdtName() {
        return cdtName;
    }

    public String getCdtTell() {
        return cdtTell;
    }

    public String getCdtEmail() {
        return cdtEmail;
    }

    public String getCdtAddress() {
        return cdtAddress;
    }

    public void setCdtid(String cdtid) {
        this.cdtid = cdtid;
    }

    public void setCdtPass(String cdtPass) {
        this.cdtPass = cdtPass;
    }

    public void setCdtName(String cdtName) {
        this.cdtName = cdtName;
    }

    public void setCdtTell(String cdtTell) {
        this.cdtTell = cdtTell;
    }

    public void setCdtEmail(String cdtEmail) {
        this.cdtEmail = cdtEmail;
    }

    public void setCdtAddress(String cdtAddress) {
        this.cdtAddress = cdtAddress;
    }

    
    
    
            
    
}
