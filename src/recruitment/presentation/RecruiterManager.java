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
    private Exception error;

    private RecruiterDTO currentRecruiter;
    
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
    
    public boolean getSuccess() {
        return error == null;
    }
    
    public void setError(Exception error) {
        this.error = error;
    }
    public Exception getError() {
        return error;
    }
    
    private void handleException(Exception e) {
        e.printStackTrace(System.err);
        error = e;
    }
    
    public void setCurrentRecruiter(RecruiterDTO currentRecruiter) {
        this.currentRecruiter = currentRecruiter;
    }
    public RecruiterDTO getCurrentRecruiter() {
        return currentRecruiter;
    }
    
    public String login() {
        try {
            currentRecruiter = databaseFacade.findRecruiter(lUsername, lPassword);
        }
        catch (Exception e) {
            handleException(e);
        }
        
        return JSFFIX;
    }
}
