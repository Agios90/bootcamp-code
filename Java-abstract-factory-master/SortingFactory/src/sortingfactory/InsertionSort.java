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
public class InsertionSort implements Sortable {
    
    public InsertionSort(int[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Insertionsort runtime: "+elapsed+ " ms");
    }
    
    public InsertionSort(float[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Insertionsort runtime: "+elapsed+ " ms");
    }
    
    public InsertionSort(char[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Insertionsort runtime: "+elapsed+ " ms");
    }
    
    @Override
    public void sort(int[] data) {
        
        int n = data.length;
        for (int k = 1; k < n; k++) { // begin with second character
            int cur = data[k]; // time to insert cur=data[k]
            int j = k; // find correct index j for cur
            while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go after cur
                data[j] = data[j - 1]; // slide data[j-1] rightward
                j--; // and consider previous j for cur
            }
            data[j] = cur; // this is the proper place for cur
        }
    }
    @Override
    public void sort(float[] data) {
        
        int n = data.length;
        for (int k = 1; k < n; k++) { // begin with second character
            float cur = data[k]; // time to insert cur=data[k]
            int j = k; // find correct index j for cur
            while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go after cur
                data[j] = data[j - 1]; // slide data[j-1] rightward
                j--; // and consider previous j for cur
            }
            data[j] = cur; // this is the proper place for cur
        }
    }
    @Override
    public void sort(char[] data) {
        
        int n = data.length;
        for (int k = 1; k < n; k++) { // begin with second character
            char cur = data[k]; // time to insert cur=data[k]
            int j = k; // find correct index j for cur
            while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go after cur
                data[j] = data[j - 1]; // slide data[j-1] rightward
                j--; // and consider previous j for cur
            }
            data[j] = cur; // this is the proper place for cur
        }
    }
}
