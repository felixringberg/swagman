/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.integration;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Size;
import recruitment.business.Applicant;
import recruitment.business.ApplicantDTO;
import recruitment.business.CompetenceDTO;
import recruitment.business.LogEntry;
import recruitment.business.Recruiter;
import recruitment.business.RecruiterDTO;
import recruitment.business.ValidationException;
import recruitment.validator.DateOfBirth;
import recruitment.validator.Password;
import recruitment.validator.Username;

/**
 * Klassen ska ha nån koppling till databasen. Den ska hämta och lägga upp data.
 * @author Felix
 */
@Stateless
public class DatabaseFacade {
    @PersistenceContext(unitName = "recruitment")
    private EntityManager em;
    
    @Size(min=1, message="Please enter a first name")
    private String firstname;
    @Size(min=1, message="Please enter a last name")
    private String lastname;
    @Username
    private String username;
    @Password
    private String password;
    @DateOfBirth
    private String dateofbirth;
    
    public ApplicantDTO registerApplicant(String firstname, String lastname, 
            String dateofbirth, String email, String username, String password) throws ValidationException {
        if(em.find(Applicant.class, username) != null) {
            throw new EntityExistsException("Account already exists with username " + username);
        }
        else {
            this.firstname = firstname;
            this.lastname = lastname;
            this.dateofbirth = dateofbirth;
            this.username = username;
            this.password = password;
            
            ApplicantDTO newApplicant = new Applicant(this.firstname, this.lastname, 
                    this.dateofbirth, email, this.username, this.password);
            createLogEntry("New applicant created with username: " + username, "RegisterSuccess");
            em.persist(newApplicant);
            
            return newApplicant;
        }
    }
    
    public ApplicantDTO findApplicant(String username, String password) throws ValidationException {
        ApplicantDTO foundApplicant =  em.find(Applicant.class, username);
        
        if(foundApplicant != null && foundApplicant.getPassword().equals(password)) {
            createLogEntry(username + " succeeded login as applicant", "ApplicantLoginSuccess");
            return foundApplicant;
            
        }
        else {
            createLogEntry(username + " failed login as applicant", "ApplicantLoginFailure");
            throw new ValidationException("Wrong username or password");
        }
    }
    
    public RecruiterDTO findRecruiter(String username, String password) throws ValidationException {
        RecruiterDTO foundRecruiter =  em.find(Recruiter.class, username);
        
        if(foundRecruiter != null && foundRecruiter.getPassword().equals(password)) {
            createLogEntry(username + " succeeded login as recruiter", "RecruiterLoginSuccess");
            return foundRecruiter;
            
        }
        else {
            createLogEntry(username + " failed login as recruiter", "RecruiterLoginFailure");
            throw new ValidationException("Wrong username or password");
        }
    }
    
    /**
     * @return the list of all the competences in the database
     */
    public List<CompetenceDTO> getCompetences() {
        List competences = em.createQuery("SELECT c FROM Competence c").getResultList();
        
        return competences;
    }
    
    /**
     * 
     * @param username
     * @param competence
     * @param years 
     */
    public void saveExperience(String username, int competence, float years) {
        em.createNativeQuery("INSERT INTO EXPERIENCE (APPLICANT, COMPETENCE, YEARS)"
                     + " VALUES (?1, ?2, ?3)").setParameter(1,username).setParameter(2, competence)
                .setParameter(3, years).executeUpdate();
        
        createLogEntry(username + " added " + years + " years experience of"
                + "competence ID " + competence, "AddedExperience");
    }
    
    /**
     * Creates a log entry in the database with the input logMessage and logType strings
     * @param logMessage the message to put in the database with the log entry
     * @param logType the type of log entry, e.g. RecruiterLoginSuccess, Exception
     */
    public void createLogEntry(String logMessage, String logType) {
        em.persist(new LogEntry(logMessage, logType));
    }
}
