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
public class IntFactory extends AlgorithmFactory {
    
    public IntFactory(String choice, int[] a) {
        Sortable s = this.getSort(choice, a);
    }
    
    @Override
    public Searchable getSearch(String sortType, int[] a, int key) {
        return null;
    }
    
    @Override
    public Sortable getSort(String sortType, int[] a) {
        
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
      } else if(sortType.equalsIgnoreCase("QuickSort")){
         new QuickSort(a);
      }
      
      return null;
      
    }
 
}
