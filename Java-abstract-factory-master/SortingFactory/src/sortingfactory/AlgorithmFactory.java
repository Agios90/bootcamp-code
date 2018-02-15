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
public abstract class AlgorithmFactory {
    
   abstract Searchable getSearch(String choice, int[] a, int key);
   abstract Sortable getSort(String choice, int[] a);
   
}
