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
public class CharFactory extends AlgorithmFactory {
    
    public CharFactory(String choice, char[] a) {
        Sortable s = this.getSort(choice, a);
    }
    
    @Override
    public Sortable getSort(String sortType, int[] a) {
        return null;
    }
    
    @Override
    public Searchable getSearch(String sortType, int[] a, int key) {
        return null;
    }
    
    
    public static Sortable getSort(String sortType, char[] a) {
        
      if(sortType == null){
         return null;
      }		
      if(sortType.equalsIgnoreCase("BucketSort")){
          new BucketSort(a);
      }   
      if(sortType.equalsIgnoreCase("BubbleSort")){
          new BubbleSort(a);
         
      } else if(sortType.equalsIgnoreCase("MergeSort")){
         new MergeSort(a);
         
      } else if(sortType.equalsIgnoreCase("InsertionSort")){
         new InsertionSort(a);
      }
      
      return null;
    }
    
    
}
