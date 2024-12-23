//---------------------------------------------------------------------------
// HMap.java                by Dale/Joyce/Weems                     Chapter 8
//
// Implements a map using an array-based hash table, linear probing collision 
// resolution. 
//
// The remove operation is not supported. Invoking it will result in the 
// unchecked UnsupportedOperationException being thrown.
//
// A map provides (K = key, V = value) pairs, mapping the key onto the value.
// Keys are unique. Keys cannot be null.
//
// Methods throw IllegalArgumentException if passed a null key argument.
//
// Values can be null, so a null value returned by put or get does 
// not necessarily mean that an entry did not exist.
//---------------------------------------------------------------------------
package ch08.maps;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;  

public class HMap<K extends Comparable<K>, V>  implements MapInterface<K,V>
{
  protected LinkedList<MapEntry<K, V>>[] map;
  
  protected final int DEFCAP = 1000;     // default capacity
  protected final double DEFLOAD = 0.75; // default load
  
  protected int origCap;  // original capacity
  protected int currCap;  // current capacity
  protected double load;
  
  protected int numPairs = 0;    // number of pairs in this map
   
  public HMap() 
  {
    map =  new LinkedList[DEFCAP];
    origCap = DEFCAP;
    currCap = DEFCAP;
    load = DEFLOAD;
    initializeBuckets();
  }

  public HMap(int initCap, double initLoad) 
  {
    map = new LinkedList[initCap];
    origCap = initCap;
    currCap = initCap;
    load = initLoad;
    initializeBuckets();
  }
  
  private void initializeBuckets() {
   for (int i = 0; i < map.length; i++) {
      map[i] = new LinkedList<>();
   }
  }

  private void enlarge(){
   LinkedList<MapEntry<K, V>>[] oldMap = map;
   
   currCap += origCap;
   
   map = new LinkedList[currCap];
   
   initializeBuckets();
   
   numPairs = 0;
   
   for (LinkedList<MapEntry<K, V>> bucket : oldMap) {
      for (MapEntry<K, V> entry : bucket) {
         put(entry.getKey(), entry.getValue());
      }
   }
    
  }
 
  public V put(K k, V v){
    if (k == null){
      throw new IllegalArgumentException("Maps do not allow null keys.");
   }
   
    int index = Math.abs(k.hashCode()) % currCap;
    LinkedList<MapEntry<K, V>> bucket = map[index];
    
    for (MapEntry<K, V> entry : bucket) {
      if (entry.getKey().equals(k)) {
         V ancientValue = entry.getValue();
         entry.setValue(v);
         return ancientValue;
      }
    }
    
    bucket.add(new MapEntry<>(k, v));
    numPairs++;
    
    if ((float) numPairs / currCap > load) {
      enlarge();
    }
    return null;
  }

  public V get(K k){
  
    if (k == null){
      throw new IllegalArgumentException("Maps do not allow null keys.");
    }
    
    int index = Math.abs(k.hashCode()) % currCap;
    LinkedList<MapEntry<K, V>> bucket = map[index];
    
    for (MapEntry<K, V> entry : bucket) {
      if (entry.getKey().equals(k)) {
         return entry.getValue();
      }
    }
    return null;
  }

  public V remove(K k)
  // Throws UnsupportedOperationException.
  {
    throw new UnsupportedOperationException("HMap does not allow remove.");
  }    

  public boolean contains(K k){
    if (k == null){
      throw new IllegalArgumentException("Maps do not allow null keys.");
   }
   
    int index = Math.abs(k.hashCode()) % currCap;
    LinkedList<MapEntry<K, V>> bucket = map[index];
    
    for (MapEntry<K, V> entry : bucket) {
      if (entry.getKey().equals(k)) {
         return true;
      }
    }
    return false;
  }
   
  public boolean isEmpty()
  // Returns true if this map is empty; otherwise, returns false.
  {
    return (numPairs == 0);
  }
  
  public boolean isFull()
  // Returns true if this map is full; otherwise, returns false.
  {
    return false;  // An HMap is never full
  }

  public int size()
  // Returns the number of entries in this map.
  {
    return numPairs;
  }

  private class MapIterator implements Iterator<MapEntry<K,V>>{
  
    private List<MapEntry<K, V>> entryList;
    private int currentIndex = 0; 
      
    public MapIterator(){
      entryList = new ArrayList<>();
      for (int i = 0; i < currCap; i++) {
         if (map[i] != null){
            entryList.addAll(map[i]);
         }
      }
    }
      
    public boolean hasNext(){
      return currentIndex < entryList.size();
    }
      
    public MapEntry<K,V> next(){
      if (!hasNext()){
         throw new NoSuchElementException("No more elements in the map iterator.");
      }
      return entryList.get(currentIndex++);
    }

    public void remove(){
      throw new UnsupportedOperationException("Remove operation is not supported.");
    }
  }

  public Iterator<MapEntry<K,V>> iterator(){
  
   return new Iterator<MapEntry<K, V>>() {
      private int bucketIndex = 0;
      private Iterator<MapEntry<K, V>> bucketIterator = map[bucketIndex].iterator();
      
      public boolean hasNext() {
         while(!bucketIterator.hasNext() && bucketIndex < map.length - 1){
            bucketIndex++;
            bucketIterator = map[bucketIndex].iterator();
         }
         return bucketIterator.hasNext();
      }
      
      public MapEntry<K, V> next(){
         if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements in the map.");
         }
         return bucketIterator.next();
      }
   };
  }
  
  public String toString() {
   StringBuilder sb = new StringBuilder();
   
   for (int i = 0; i < map.length; i++) {
      sb.append("Index ").append(i).append(": ");
      if (map[i].isEmpty()) {
         sb.append("Empty\n");
      } else {
         for (MapEntry<K, V> entry : map[i]) {
            sb.append(entry).append(" -> ");
         }
         sb.append("null\n");
      }
   }
   return sb.toString();
   }

}
 