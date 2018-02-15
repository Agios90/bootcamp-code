/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingfactory;

import java.util.Arrays;

/**
 *
 * @author agios
 */
public class BinarySearch implements Searchable {
    
    public BinarySearch(int[]a, int x){
        long startTime = System.currentTimeMillis();
        search(a,x);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println("Binary search runtime: "+elapsed+ " ms");
    }
    
    @Override
    public void search(int[] a, int x) {
        
        boolean found = true;
        int pos = 0;
        
        pos = java.util.Arrays.binarySearch(a,x);
        
        if (pos<0) found = false;
        
        if (found==true) System.out.println("Element "+x+" found at position "+pos);
        else System.out.println(x+" not found");
    }
}

