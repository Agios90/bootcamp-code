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
public class BubbleSort implements Sortable{
    
    public BubbleSort(int[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Bubblesort runtime: "+elapsed+ " ms");
    }
    
    public BubbleSort(float[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Bubblesort runtime: "+elapsed+ " ms");
    }
    
    public BubbleSort(char[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Bubblesort runtime: "+elapsed+ " ms");
    }
    
    @Override
    public void sort(int a[]) {
        
        int temp;
        int n = a.length;
        for (int k = 0; k < n - 1; k++) {
            // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
            for (int i = 0; i < n - k - 1; i++) {
                if (a[i] > a[i + 1]) {
                    // here swapping of positions is being done.
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }
    
    @Override
    public void sort(float a[]) {
        
        float temp;
        int n = a.length;
        for (int k = 0; k < n - 1; k++) {
            // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
            for (int i = 0; i < n - k - 1; i++) {
                if (a[i] > a[i + 1]) {
                    // here swapping of positions is being done.
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }
    
    @Override
    public void sort(char a[]) {
        
        char temp;
        int n = a.length;
        for (int k = 0; k < n - 1; k++) {
            // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
            for (int i = 0; i < n - k - 1; i++) {
                if (a[i] > a[i + 1]) {
                    // here swapping of positions is being done.
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }
    
}
