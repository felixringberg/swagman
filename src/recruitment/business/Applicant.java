/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import recruitment.validator.DateOfBirth;
import recruitment.validator.Password;
import recruitment.validator.Username;

/**
 *
 * @author Felix Ringberg
 */
@Entity
public class Applicant implements Serializable, ApplicantDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @Username
    private String username;
    @Password
    private String password;
    @DateOfBirth
    private String dateofbirth;
    private String firstname, lastname, email;
    
    public Applicant() {
        
    }
    public Applicant(String firstname, String lastname, String dateofbirth, String email, 
            String username, String password) throws ValidationException {
        
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
