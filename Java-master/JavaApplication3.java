package javaapplication3;

import java.util.Scanner;
//import java.lang.Math;

public class JavaApplication3 {

    public static void main(String[] args) {
        float ht;
        float wt;
        //float i;
        int j=0;
        int k=0;
        int l=0;
        String stringForParse = "55";
        Boolean found;
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10];
        int[][] arr2d = new int[7][3];
        
        /*____________________________ARRAYS__________________________________*/
        /*int count = 0;
        
        for (int i=0; i<10; i++) arr[i] = i+1;
        
        for (int i=0; i<7; i++) {
            for (j=0; j<3; j++) {
                arr2d[i][j] = count+1;
                    count++;
            }
        }
        
        int s = arr[4]+arr[7];
        System.out.println(arr[4]);
        System.out.println(arr[7]);
        System.out.println("arr[4] + arr[7] = " + s);
        System.out.println("1d arr length: " + arr.length);
        System.out.println("2d arr length (number of rows): " + arr2d.length);
        System.out.println("length of 2d array's first row: " + arr2d[1].length);
        
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        System.out.println();
        
        for (int i=0; i<7; i++) {
            for (j=0; j<3; j++) {
                System.out.print(arr2d[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }*/      
        
        /*____________________________ASKISI1_________________________________*/
        /*System.out.println("Dwse 1 arithmo kai 1 string: ");
        i = scanner.nextFloat();
        String str = scanner.next();
        System.out.println(i + str);*/
        
        /*____________________________ASKISI2_________________________________*/
        /*found = false;
        while (!found) {
            System.out.println("Dwse 3 int. Int2 > 3*Int1, Int3 > Int2+Int1: ");
            j = scanner.nextInt();
            k = scanner.nextInt();
            l = scanner.nextInt();
            found = ((j < k/2) && (l>j+k));
        }
        System.out.println(j + " " + k + " " + l + " are correct.");*/
        
        /*__________________________PARSE_INT_________________________________*/
       // System.out.println(Integer.parseInt(stringForParse)*2);
        
        /*_____________________________BMI____________________________________*/
        /*System.out.println("Give me your height");
        ht = scanner.nextFloat();
        
        System.out.println("Give me your weight");
        wt = scanner.nextFloat();
                
        System.out.println(ht);
        System.out.println(wt);
        System.out.println("BMI");
        System.out.println(10000 * wt / (ht*ht));*/
        
        /*____________________________DOGAGE__________________________________*/      
        /*int dogage;
        int humanage;
        System.out.println("Give me your dog age");
        dogage = scanner.nextInt();
        if (dogage==1 || dogage==2) {
            humanage=dogage;
            System.out.println("Human age: " + humanage);
        }
         else if (dogage <= 30 && dogage>0) {
            humanage = (dogage-2)*5 + 2;
            System.out.println("Human age: " + humanage);
        }
         else {
             System.out.println("Invalid dog age");
         }*/
          
         }
    }
