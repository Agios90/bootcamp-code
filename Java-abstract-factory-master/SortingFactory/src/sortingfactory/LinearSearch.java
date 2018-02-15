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
public class LinearSearch implements Searchable{
    
    public LinearSearch(int[]a, int x){
        long startTime = System.currentTimeMillis();
        search(a,x);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println("Linear search runtime: "+elapsed+ " ms");
    }
    
    @Override
    public void search(int[] a, int x) {
        
        boolean found = false;
        int pos =0;
        
        for (int i=0; i < a.length; i++) {
            if (a[i] == x) {
                found = true;
                pos = i;
                break;
            }
        }
        if (found==true) System.out.println("Element "+x+" found at position "+pos);
        else System.out.println(x+" not found");
    }
}
