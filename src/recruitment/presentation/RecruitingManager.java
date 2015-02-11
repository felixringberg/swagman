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
    private String rFirstname, rLastname, rEmail, rUsername, rPassword;
    
    private ApplicantDTO currentApplicant;
    
    
    // Setters and getters for recruiting applicant
    public void setrFirstname(String rFirstname) {
        this.rFirstname = rFirstname;
    }
    public String getrFirstname() {
        return rFirstname;
    }
    
    public void setrLastname(String rLastname) {
        this.rLastname = rLastname;
    }
    public String getrLastname() {
        return rLastname;
    }
    
    public void setrEmail(String rEmail) {
        this.rLastname = rEmail;
    }
    public String getrEmail() {
        return rEmail;
    }
    
    public void setrUsername(String rUsername) {
        this.rUsername = rUsername;
    }
    public String getrUsername() {
        return rUsername;
    }
    
    public void createApplicant() {
        currentApplicant = recruitingFacade.registerApplicant(rFirstname, 
                rLastname, rEmail, rUsername, rPassword);
    }
}
