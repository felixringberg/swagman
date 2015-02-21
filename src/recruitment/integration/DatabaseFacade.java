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
            Applicant newApplicant = new Applicant(firstname, lastname, 
                    dateofbirth, email, username, password);
            
            em.persist(newApplicant);
            
            return newApplicant;
        }
    }
    
    public ApplicantDTO findApplicant(String username, String password) throws ValidationException {
        Applicant foundApplicant =  em.find(Applicant.class, username);
        
        if(foundApplicant != null && foundApplicant.getPassword().equals(password))
            return foundApplicant;
        else
            throw new ValidationException("Wrong username or password");
    }
    
    public RecruiterDTO findRecruiter(String username, String password) throws ValidationException {
        Recruiter foundRecruiter =  em.find(Recruiter.class, username);
        
        if(foundRecruiter != null && foundRecruiter.getPassword().equals(password))
            return foundRecruiter;
        else
            throw new ValidationException("Wrong username or password");
    }
}
