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

/**
 *
 * @author Felix Ringberg <felixri at kth.se>
 */
@Entity
public class Recruiter implements Serializable, RecruiterDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
