/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querries;

import java.util.ArrayList;

/**
 *
 * @author lefte
 */
public class User {
    
    public String username;
    public ArrayList<Ticket> ticketList;
    public boolean priviledge;
    
    public User(){
        username = "";
        ticketList = new ArrayList<>();
        priviledge = false;
    }
    
}
