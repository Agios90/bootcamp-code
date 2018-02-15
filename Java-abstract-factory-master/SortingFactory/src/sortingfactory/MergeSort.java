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
public class MergeSort implements Sortable {
    private int[] array;
    private int[] tempMergArr;
    private int length;
    private float[] farray;
    private float[] ftempMergArr;
    private int flength;
    private char[] carray;
    private char[] ctempMergArr;
    private int clength;
    
    public MergeSort(int[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Mergesort runtime: "+elapsed+ " ms");
    }
    public MergeSort(float[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Mergesort runtime: "+elapsed+ " ms");
    }
    public MergeSort(char[] a) {
        
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        
        System.out.println(Arrays.toString(a));
        System.out.println("Mergesort runtime: "+elapsed+ " ms");
    }

    @Override
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
    

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
    
    @Override
    public void sort(float inputArr[]) {
        this.farray = inputArr;
        this.flength = inputArr.length;
        this.ftempMergArr = new float[flength];
        doMergeSort(0, length - 1);
    }
    
    @Override
    public void sort(char inputArr[]) {
        this.carray = inputArr;
        this.clength = inputArr.length;
        this.ctempMergArr = new char[flength];
        doMergeSort(0, length - 1);
    }
}
