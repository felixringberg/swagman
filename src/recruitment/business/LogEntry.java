/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
    private Time logtime;
    private Date logdate;
    private String message;
    private String logType;
    
    public LogEntry() {
        
    }
    public LogEntry(String message, String logType) {
        this.message = message;
        
        long timeMillis = System.currentTimeMillis();
        this.logtime = new Time(timeMillis);
        this.logdate = new Date(timeMillis);
        this.logType = logType;
    }
    
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return the time of the log entry creation, in milliseconds
     */
    @Override
    public Time getTime(){
        return logtime;
    }
    public void setTime(Time logtime){
        this.logtime = logtime;
    }
    
    /**
     * 
     * @return the date of the log entry creation, in milliseconds
     */
    @Override
    public Date getDate(){
        return logdate;
    }
    public void setDate(Date date){
        this.logdate = date;
    }
    
    @Override
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    
    /**
     * 
     * @return the log type as a string i.e. 'registering', 'exception', 'login'
     */
    @Override
    public String getLogType(){
        return logType;
    }
    public void setLogType(String logType){
        this.logType = logType;
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
