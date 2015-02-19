/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Felix Ringberg <felixri at kth.se>
 */
@Entity
public class Applicant implements Serializable, ApplicantDTO {
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    
    private String firstname, lastname, email, password, dateofbirth;
    
    public Applicant() {
        
    }
    public Applicant(String firstname, String lastname, String dateofbirth, String email, 
            String username, String password) throws ValidationException {
        // Validering för lösenord
        if(password.length() < 6)
            throw new ValidationException("Password too short");
        for(int i = 0; i < password.length(); i++)
            if(!(Character.isDigit(password.charAt(i)) || Character.isLetter(password.charAt(i))))
               throw new ValidationException("Passwords may only contain letters A-Z, a-z or numbers 0-9");
        
        if(username.length() < 6)
            throw new ValidationException("Password too short");
        for(int i = 0; i < username.length(); i++)
            if(!(Character.isDigit(username.charAt(i)) || Character.isLetter(username.charAt(i))))
               throw new ValidationException("Usernames may only contain letters A-Z, a-z or numbers 0-9");
        
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    @Override
    public String getDateofbirth() {
        return dateofbirth;
    }
    
    public void setDateofbirth(String dateofbirth){
        this.dateofbirth = dateofbirth;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "recruitment.business.Applicant[ id=" + username + " ]";
    }
    
}
