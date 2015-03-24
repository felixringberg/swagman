/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.presentation;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import recruitment.business.ApplicantDTO;
import recruitment.business.CompetenceDTO;
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
    private Exception exceptionLogin, exceptionRegister, exceptionGeneral;
    
    private String lUsername, lPassword;
    // the registering applicant's info
    private String rFirstname, rLastname, rDateofbirth, rEmail, rUsername, rPassword;
    
    private int competence;
    private float experienceYears;
    
    private ApplicantDTO currentApplicant;
    
    public void setCurrentApplicant(ApplicantDTO currentApplicant) {
        this.currentApplicant = currentApplicant;
    }
    public ApplicantDTO getCurrentApplicant() {
        return currentApplicant;
    }
    
    // General error handling
    private void handleExceptionGeneral(Exception e) {
        e.printStackTrace(System.err);
        exceptionGeneral = e;
        databaseFacade.createLogEntry("Exception " + e.getClass().getName() + ": " + e.getMessage(), "Exception");
    }
    
    public void setExceptionGeneral(Exception exceptionGeneral) {
        this.exceptionGeneral = exceptionGeneral;
    }
    public Exception getExceptionGeneral() {
        return exceptionGeneral;
    }
    
    // Error handling for login
    private void handleExceptionLogin(Exception e) {
        e.printStackTrace(System.err);
        exceptionLogin = e;
        databaseFacade.createLogEntry("Exception " + e.getClass().getName() + ": " + e.getMessage(), "Exception");
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
        databaseFacade.createLogEntry("Exception " + e.getClass().getName() + ": " + e.getMessage(), "Exception");
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
            return "success";
        }
        catch (Exception e) {
            handleExceptionRegister(e);
        }
        return JSFFIX; // Because of a bug return empty string
    }
    
    public List<CompetenceDTO> getCompetenceList() {
        List<CompetenceDTO> competenceList = null;
        try {
            competenceList = databaseFacade.getCompetences();
        }
        catch (Exception e) {
            handleExceptionGeneral(e);
        }
        return competenceList;
    }
    
    public void setCompetence (int competence) {
        this.competence = competence;
    }
    public int getCompetence() {
        return competence;
    }
    
    public void setExperienceYears (float experienceYears) {
        this.experienceYears = experienceYears;
    }
    public float getExperienceYears() {
        return experienceYears;
    }
    
    public String saveExperience() {
        try {
            databaseFacade.saveExperience(currentApplicant.getUsername(), competence, experienceYears);
        }
        catch (Exception e) {
            handleExceptionGeneral(e);
        }
        return "";
    }
}
