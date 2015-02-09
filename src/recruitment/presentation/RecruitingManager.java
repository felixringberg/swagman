/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.presentation;

import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Har många set- och get-metoder som används av index.html
 * @author Felix
 */
@Named("recruitingManager")
@SessionScoped
public class RecruitingManager implements Serializable{
    
}
