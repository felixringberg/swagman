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
 * @author Oskar
 */

@Entity
public class Competence implements Serializable, CompetenceDTO {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    
    private String competence;
    
    public Competence() {
        
    }
    
    public Competence(String competence, int id) {
        this.competence = competence;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getCompetence() {
        return competence;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competence != null ? competence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "recruitment.business.Competence[ id=" + id + " ]";
    }
}
