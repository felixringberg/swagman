/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Felix
 */
public class Recruitment implements Serializable, RecruitmentDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // vet ej om den behövs
    int ID;
    
    @Override
    public int getID() {
        return ID;
    }
}
