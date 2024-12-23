package ch08.maps;

import ch07.trees.BinarySearchTree;
import support.BSTNode;

import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements MapInterface<K, V> {

   private BinarySearchTree<MapEntry<K, V>> tree;

   public BSTMap() {
      tree = new BinarySearchTree<>();
   }

   public V put(K key, V value) {
      MapEntry<K, V> newEntry = new MapEntry<>(key, value);
      MapEntry<K, V> existingEntry = tree.get(newEntry);
      
      if (existingEntry != null) {
         V ancientValue = existingEntry.getValue();
         existingEntry.setValue(value);
         return ancientValue;
      } else {
         tree.add(newEntry);
         return  null;
      }
   }
   
   public V get(K key) {
      MapEntry<K, V> target = new MapEntry<>(key, null);
      MapEntry<K, V> result = tree.get(target);
      return result != null ? result.getValue() : null;
   }
   
   public V remove(K key) {
      MapEntry<K, V> target = new MapEntry<>(key, null);
      MapEntry<K, V> removedEntry = tree.get(target);
      
      if (removedEntry != null) {
         tree.remove(target);
         return removedEntry.getValue();
      }
      return null;
   }
   
   public boolean contains(K key) {
      MapEntry<K, V> target = new MapEntry<>(key, null);
      return tree.contains(target);
   }
   
   public boolean isEmpty() {
      return tree.isEmpty();
   }
   
   public boolean isFull() {
      return tree.isFull();
   }
   
   public int size() {
      return tree.size();
   }
   
   public Iterator<MapEntry<K, V>> iterator() {
      return tree.iterator();
   }


}