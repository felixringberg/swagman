/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

/**
 *
 * @author Felix Ringberg <felixri at kth.se>
 */
public interface ApplicantDTO {
    public String getFirstname();
    public String getLastname();
    public String getDateofbirth();
    public String getEmail();
    public String getUsername();
    public String getPassword();
}
