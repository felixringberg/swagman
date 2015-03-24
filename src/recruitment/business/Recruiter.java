/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import recruitment.validator.Password;
import recruitment.validator.Username;

/**
 *
 * @author Felix Ringberg
 */
@Entity
public class Recruiter implements Serializable, RecruiterDTO{
    @Id
    @Username
    private String username;
    @Password
    private String password;

    public Recruiter() {
    }
    
    public Recruiter(Integer id, String username, String password) {
        this.username = username;
        this.password = password;
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


}
