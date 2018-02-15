
package factorialjava;

import java.util.Scanner;


public class FactorialJava {

    public static long factorial(long n){
        if (n==1) return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        
        long x;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dwse arithmo gia ypologismo factorial");
        x = sc.nextLong();
        System.out.println(factorial(x));
        
    }
    
}
