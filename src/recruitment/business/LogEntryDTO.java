/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Marcus
 */
public interface LogEntryDTO {
    public int getId();
    public Time getTime();
    public Date getDate();
    public String getMessage();
    public String getLogType();
}
