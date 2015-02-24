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
 * @author Marcus
 */
@Entity
public class LogEntry implements Serializable, LogEntryDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String logtime;
    private String logdate;
    private String message;
    
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String getTime(){
        return logtime;
    }
    public void setTime(String time){
        this.logtime = time;
    }
    
    @Override
    public String getDate(){
        return logdate;
    }
    public void setDate(String date){
        this.logdate = date;
    }
    
    @Override
    public String getMessage(){
        
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogEntry)) {
            return false;
        }
        LogEntry other = (LogEntry) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "recruitment.business.LogEntry[ id=" + id + " ]";
    }
    
}
