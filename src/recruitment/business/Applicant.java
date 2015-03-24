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
 * @author Felix Ringberg
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
        // Username validation
        if(username.length() < 6)
            throw new ValidationException("Username too short");
        for(int i = 0; i < username.length(); i++)
            if(!(Character.isDigit(username.charAt(i)) || Character.isLetter(username.charAt(i))))
               throw new ValidationException("Usernames may only contain letters A-Z, a-z or numbers 0-9");
        
        // Password validation
        if(password.length() < 6)
            throw new ValidationException("Password too short");
        for(int i = 0; i < password.length(); i++)
            if(!(Character.isDigit(password.charAt(i)) || Character.isLetter(password.charAt(i))))
               throw new ValidationException("Passwords may only contain letters A-Z, a-z or numbers 0-9");
        
        //Date of birth validation
        if(dateofbirth.charAt(4) != '-' || dateofbirth.charAt(7) != '-')
            throw new ValidationException("Enter date of birth in the form YYYY-MM-DD");
        
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

    @Override
    public String getLastname() {
        return lastname;
    }
    
    @Override
    public String getDateofbirth() {
        return dateofbirth;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
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
