/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.presentation;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import recruitment.business.ApplicantDTO;
import recruitment.integration.RecruitingFacade;

/**
 * Har många set- och get-metoder som används av index.html
 * @author Felix
 */
@Named("recruitingManager")
@SessionScoped
public class RecruitingManager implements Serializable{
    @EJB
    private RecruitingFacade recruitingFacade;
    private Exception error;
    
    // the registering applicant's info
    private String rFirstname, rLastname, rDateofbirth, rEmail, rUsername, rPassword;
    
    private ApplicantDTO currentApplicant;
    
    
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
    
    public void createApplicant() {
        currentApplicant = recruitingFacade.registerApplicant(rFirstname, 
                rLastname, rDateofbirth, rEmail, rUsername, rPassword);
    }
}
