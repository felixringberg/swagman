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
import recruitment.integration.DatabaseFacade;

/**
 *
 * @author Felix Ringberg <felixri at kth.se>
 */
@Named("loginManager")
@SessionScoped
public class LogInManager implements Serializable{
    @EJB
    private DatabaseFacade databaseFacade;
    private String lUsername, lPassword;
    private Exception error;
    
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
    
    private void handleException(Exception e) {
        e.printStackTrace(System.err);
        error = e;
    }
    
    public String login() {
        String result = "";
        try {
            result = databaseFacade.authenticateUser(lUsername, lPassword);
        }
        catch (Exception e) {
            handleException(e);
        }
        
        return result;
    }
}
