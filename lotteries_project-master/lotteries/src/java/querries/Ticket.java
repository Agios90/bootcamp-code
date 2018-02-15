/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querries;

import java.sql.Timestamp;

/**
 *
 * @author lefte
 */
public class Ticket {
    
    public String ticket_id;
    public Timestamp date;
    public boolean iswinner;
    public String username;
    public int count;
    public int earnings;
    
    public Ticket(String ticket_id, Timestamp date, boolean iswinner, String username){
        this.ticket_id = ticket_id;
        this.date = date;
        this.iswinner = iswinner;
        this.username = username;
        this.count = 0;
        this.earnings = 1000;
    }
    
}
