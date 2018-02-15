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
public class BucketSort implements Sortable {
    
    public BucketSort(int[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Bucketsort runtime: "+elapsed+ " ms");
    }
    public BucketSort(float[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println("Float array cannot be bucketsorted");
        System.out.println("NULL");
    }
    public BucketSort(char[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println("Character array cannot be bucketsorted");
        System.out.println("NULL");
    }
    
    @Override
    public void sort(int[] a) {
        
        int maxVal=0;
        for (int i=0; i<a.length; i++) {
            if (a[i]>maxVal) maxVal = a[i];
        }
        
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
            }
        }
    }
   @Override 
   public void sort(float[] a) {
       
   }
   
   @Override
   public void sort(char[] a) {
      
   }
}
