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
public class SearchFactory extends AlgorithmFactory {
    
    public SearchFactory(String choice, int[] a, int key) {
        Searchable s = this.getSearch(choice, a,key);
    }
    
    @Override
    public Sortable getSort(String sortType, int[] a) {
        return null;
    }
    
    @Override
    public Searchable getSearch(String searchType, int[] a, int key) {
        
      if(searchType == null){
         return null;
      }		
      if(searchType.equalsIgnoreCase("LinearSearch")){
          new LinearSearch(a,key);
      }   
      else if(searchType.equalsIgnoreCase("BinarySearch")){
          new BinarySearch(a,key);
         
      }
        
      return null;
    }
 
}
