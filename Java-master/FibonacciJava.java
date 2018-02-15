package fibonaccijava;

import java.util.Scanner;

public class FibonacciJava {

    public static long Fibonacci(int n) {
        if (n <= 1) return n;
        else return Fibonacci(n-1) + Fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Dwse arithmo gia ypologismo Fibonacci");
        System.out.println(Fibonacci(sc.nextInt()));
        
    }
    
}
