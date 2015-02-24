/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.business;

/**
 *
 * @author Marcus
 */
public interface LogEntryDTO {
    public int getId();
    public String getTime();
    public String getDate();
    public String getMessage();
}
