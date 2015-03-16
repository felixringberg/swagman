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
import recruitment.business.RecruiterDTO;
import recruitment.integration.DatabaseFacade;

/**
 *
 * @author Felix Ringberg <felixri at kth.se>
 */
@Named("recruiterManager")
@SessionScoped
public class RecruiterManager implements Serializable{
    private final String JSFFIX = "";
    @EJB
    private DatabaseFacade databaseFacade;
    private String lUsername, lPassword;
    private Exception exceptionLogin;

    private RecruiterDTO currentRecruiter;
    
    //Error handling for logging in as a recruiter
    private void handleExceptionLogin(Exception e) {
        e.printStackTrace(System.err);
        exceptionLogin = e;
        databaseFacade.createLogEntry(e.getMessage(), "Exception");
    }
    
    public void setExceptionLogin(Exception exceptionLogin) {
        this.exceptionLogin = exceptionLogin;
    }
    public Exception getExceptionLogin() {
        return exceptionLogin;
    }
    
    public void setCurrentRecruiter(RecruiterDTO currentRecruiter) {
        this.currentRecruiter = currentRecruiter;
    }
    public RecruiterDTO getCurrentRecruiter() {
        return currentRecruiter;
    }
    
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
            currentRecruiter = databaseFacade.findRecruiter(lUsername, lPassword);
            return "success";
        }
        catch (Exception e) {
            handleExceptionLogin(e);
        }
        
        return JSFFIX;
    }
    
    public String logout() {
        currentRecruiter = null;
        
        return JSFFIX;
    }
}
