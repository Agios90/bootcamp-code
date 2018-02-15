/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingfactory;

/**
 *
 * @author agios
 */
public class FactoryProducer {
    
   public static AlgorithmFactory getFactory(String algorithmchoice, String sortchoice, int[] a){
        
        
       return new IntFactory(sortchoice,a); 
      
   }
   
   public static AlgorithmFactory getFactory(String algorithmchoice, String sortchoice, float[] a){
        
        
       return new FloatFactory(sortchoice,a); 
      
   }
   
   public static AlgorithmFactory getFactory(String algorithmchoice, String sortchoice, char[] a){
        
        
       return new CharFactory(sortchoice,a); 
      
   }
   
   public static AlgorithmFactory getFactory(String algorithmchoice, String sortchoice, int[] a, int key){
        
        
       return new SearchFactory(sortchoice,a,key); 
      
   }
           
}