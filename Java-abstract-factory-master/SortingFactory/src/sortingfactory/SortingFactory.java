/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingfactory;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author agios
 */
public class SortingFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FactoryProducer fp = new FactoryProducer();
        
        int intsize = 5000;
        int[] inputArr1 = new int[intsize];
        
        System.out.println("----------------------------------------------------");
        System.out.println("Generating Integer Array of size: "+intsize);
        for (int i=0; i<inputArr1.length; i++) {
            inputArr1[i] = ThreadLocalRandom.current().nextInt(0, intsize);
        } 
        System.out.println("Displaying Integer Array: ");
        System.out.println(Arrays.toString(inputArr1));
        System.out.println("----------------------------------------------------");
        
        fp.getFactory("sort","bucketsort",inputArr1);
        fp.getFactory("sort","insertionsort",inputArr1);
        fp.getFactory("sort","bubblesort",inputArr1);
        fp.getFactory("sort","mergesort",inputArr1);
        fp.getFactory("sort","quicksort",inputArr1);
        System.out.println("----------------------------------------------------");
        
        int floatsize = 10000;
        System.out.println("Generating Float Array of size: "+floatsize);
        float[] finputArr1 = new float[floatsize];
        
        for (int i=0; i<finputArr1.length; i++) {
            finputArr1[i] = ThreadLocalRandom.current().nextFloat()*floatsize;
        } 
        
        System.out.println("Displaying Float Array: ");
        System.out.println(Arrays.toString(finputArr1));
        System.out.println("----------------------------------------------------");
        
        fp.getFactory("sort","bucketsort",finputArr1);
        fp.getFactory("sort","insertionsort",finputArr1);
        fp.getFactory("sort","bubblesort",finputArr1);
        fp.getFactory("sort","mergesort",finputArr1);
        System.out.println("----------------------------------------------------");
        
        int charsize = 50;
        System.out.println("Generating Character Array of size: "+charsize);
        char[] cinputArr1 = new char[charsize];
        
        for (int i=0; i<cinputArr1.length; i++) {
            cinputArr1[i] = mapIntToChar(ThreadLocalRandom.current().nextInt(1,charsize));
        } 
        
        System.out.println("Displaying Character Array: ");
        System.out.println(Arrays.toString(cinputArr1));
        System.out.println("----------------------------------------------------");
        
        fp.getFactory("sort","bucketsort",cinputArr1);
        fp.getFactory("sort","insertionsort",cinputArr1);
        fp.getFactory("sort","bubblesort",cinputArr1);
        fp.getFactory("sort","mergesort",cinputArr1);
        System.out.println("----------------------------------------------------");
        
        
        
        
        
        
        
        
        
        int size = 50;
        int key = 5;
        int[] sArray = new int[size];
        
        System.out.println("----------------------------------------------------");
        System.out.println("Generating Integer Array of size "+size+" for Linear Searching");
        for (int i=0; i<sArray.length; i++) {
            sArray[i] = ThreadLocalRandom.current().nextInt(0, size);
        } 
        
        System.out.println(Arrays.toString(sArray));
        
        fp.getFactory("search", "linearsearch", sArray, key);
        
        System.out.println("----------------------------------------------------");
        System.out.println("Sorting Array for Binary Searching ");
        fp.getFactory("sort", "BucketSort", sArray);
        
        System.out.println("");
        fp.getFactory("Search", "BinarySearch", sArray, key);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static char mapIntToChar(int i) {
        char c='a';
        
        if (i==1) c='a';
        else if (i==2) c='b';
        else if (i==3) c='c';
        else if (i==4) c='d';
        else if (i==5) c='e';
        else if (i==6) c='f';
        else if (i==7) c='g';
        else if (i==8) c='h';
        else if (i==9) c='i';
        else if (i==10) c='j';
        else if (i==11) c='k';
        else if (i==12) c='l';
        else if (i==13) c='m';
        else if (i==14) c='n';
        else if (i==15) c='o';
        else if (i==16) c='p';
        else if (i==17) c='q';
        else if (i==18) c='r';
        else if (i==19) c='s';
        else if (i==20) c='t';
        else if (i==21) c='u';
        else if (i==22) c='v';
        else if (i==23) c='w';
        else if (i==24) c='x';
        else if (i==25) c='y';
        else if (i==26) c='z';
        
        return c;
    }
    
}
