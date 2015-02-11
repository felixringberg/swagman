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

/**
 * Klassen ska ha nån koppling till databasen. Den ska hämta och lägga upp data.
 * @author Felix
 */
@Stateless
public class RecruitingFacade {
    @PersistenceContext(unitName = "recruitment")
    private EntityManager em;
    
    public ApplicantDTO registerApplicant(String firstname, String lastname, 
            String dateofbirth, String email, String username, String password){
        if(em.find(Applicant.class, username) != null) {
            throw new EntityExistsException("Account already exists with username " + username);
        }
        else {
            Applicant newApplicant = new Applicant(firstname, lastname, 
                    dateofbirth, email, username, password);
            System.out.println("swaggo");
            System.out.println(newApplicant.getId());
            System.out.println("aaaaaaaaaaaaaaaaaaaaaadwadwad");
            em.persist(newApplicant);
            return newApplicant;
        }
    }
}
