/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;

/**
 *
 * @author agios
 */
public class PrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,n,m,flag;
        String primeStr = "";
        System.out.println("2 is prime");
        for(n=3;n<=100;n+=2) {
            flag=0;
            m=n/2;    
            for(i=2;i<=m;i++){    
                if(n%i==0){    
                //System.out.println(n+" is not prime");//    
                flag=1;    
                break;    
                }    
            }    
            if(flag==0)    
            System.out.println(n+" is prime");
            //primeStr = primeStr +//
        
        }
    }
    
}
