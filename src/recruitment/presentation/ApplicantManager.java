/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.presentation;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import recruitment.business.ApplicantDTO;
import recruitment.integration.DatabaseFacade;

/**
 * Har många set- och get-metoder som används av index.html
 * @author Felix
 */
@Named("applicantManager")
@SessionScoped
public class ApplicantManager implements Serializable{
    private final String JSFFIX = "";
    
    @EJB
    private DatabaseFacade databaseFacade;
    private Exception exceptionLogin, exceptionRegister;
    
    private String lUsername, lPassword;
    // the registering applicant's info
    private String rFirstname, rLastname, rDateofbirth, rEmail, rUsername, rPassword;
    
    private ApplicantDTO currentApplicant;
    
    public void setCurrentApplicant(ApplicantDTO currentApplicant) {
        this.currentApplicant = currentApplicant;
    }
    public ApplicantDTO getCurrentApplicant() {
        return currentApplicant;
    }
    
    // Error handling for login
    private void handleExceptionLogin(Exception e) {
        e.printStackTrace(System.err);
        exceptionLogin = e;
    }
    
    public void setExceptionLogin(Exception exceptionLogin) {
        this.exceptionLogin = exceptionLogin;
    }
    public Exception getExceptionLogin() {
        return exceptionLogin;
    }
    
    // Error handling for registering
    private void handleExceptionRegister(Exception e) {
        e.printStackTrace(System.err);
        exceptionRegister = e;
    }
    
    public void setExceptionRegister(Exception exceptionRegister) {
        this.exceptionRegister = exceptionRegister;
    }
    public Exception getExceptionRegister() {
        return exceptionRegister;
    }
    
    // Setters and getters for applicants logging in
    public void setLUsername(String lUsername) {
        this.lUsername = lUsername;
    }
    public String getLUsername() {
        return lUsername;
    }
    
    public void setLPassword(String lPassword) {
        this.lPassword = lPassword;
    }
    public String getLPassword() {
        return lPassword;
    }
    
    public String login() {
        try {
            exceptionLogin = null;
            currentApplicant = databaseFacade.findApplicant(lUsername, lPassword);
            return "success";
        }
        catch (Exception e) {
            handleExceptionLogin(e);
        }
        
        return JSFFIX;
    }
    
    public String logout() {
        currentApplicant = null;
        
        return "success";
    }
    
    // Setters and getters for recruiting applicant
    public void setRFirstname(String rFirstname) {
        this.rFirstname = rFirstname;
    }
    public String getRFirstname() {
        return rFirstname;
    }
    
    public void setRLastname(String rLastname) {
        this.rLastname = rLastname;
    }
    public String getRLastname() {
        return rLastname;
    }
    
    public void setRDateofbirth(String rDateofbirth) {
        this.rDateofbirth = rDateofbirth;
    }
    public String getRDateofbirth() {
        return rDateofbirth;
    }
    
    public void setREmail(String rEmail) {
        this.rEmail = rEmail;
    }
    public String getREmail() {
        return rEmail;
    }
    
    public void setRUsername(String rUsername) {
        this.rUsername = rUsername;
    }
    public String getRUsername() {
        return rUsername;
    }
    
    public void setRPassword(String rPassword) {
        this.rPassword = rPassword;
    }
    public String getRPassword() {
        return rPassword;
    }
    
    public String createApplicant() {
        try {
            exceptionRegister = null;
            currentApplicant = databaseFacade.registerApplicant(rFirstname, 
                rLastname, rDateofbirth, rEmail, rUsername, rPassword);
        }
        catch (Exception e) {
            handleExceptionRegister(e);
        }
        return JSFFIX; // Because of a bug a  Pga. en bugg måste en tom sträng returneras, aldrig null
    }
}
