/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.integration;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import recruitment.business.Applicant;
import recruitment.business.ApplicantDTO;
import recruitment.business.LogEntry;
import recruitment.business.Recruiter;
import recruitment.business.RecruiterDTO;
import recruitment.business.ValidationException;

/**
 * Klassen ska ha nån koppling till databasen. Den ska hämta och lägga upp data.
 * @author Felix
 */
@Stateless
public class DatabaseFacade {
    @PersistenceContext(unitName = "recruitment")
    private EntityManager em;
    
    public ApplicantDTO registerApplicant(String firstname, String lastname, 
            String dateofbirth, String email, String username, String password) throws ValidationException {
        if(em.find(Applicant.class, username) != null) {
            throw new EntityExistsException("Account already exists with username " + username);
        }
        else {
            ApplicantDTO newApplicant = new Applicant(firstname, lastname, 
                    dateofbirth, email, username, password);
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
    
    public String[] getCompetences(String username, String password) throws ValidationException {
        String[] competences;
        competences = em.createQuery("", );
        
        return competences;
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
