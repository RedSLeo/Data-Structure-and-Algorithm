
package ch05.collections;

import support.LLNode;

public class SortedLinkedCollection<T extends Comparable<T>> implements CollectionInterface<T> {
  protected LLNode<T> head;       // head of the linked list
  protected int numElements = 0;  // number of elements in this collection

  // set by find method
  protected boolean found;        // true if target found, else false
  protected LLNode<T> location;   // node containing target, if found
  protected LLNode<T> previous;   // node preceding location

  public SortedLinkedCollection()
  {
    numElements = 0;
    head = null;
  }
  
  public String toString() {
   StringBuilder sB = new StringBuilder();
   
   LLNode<T> current = head;
   while (current != null) {
      sB.append(current.getInfo().toString()).append(" ");
      current = current.getLink();
   }
   return sB.toString();
  }
  
  public T smallest() {
   if (isEmpty()) {
      return null;
   }
   return head.getInfo();
  }
  
  public int greater(T element) {
   int count = 0;
   LLNode<T> current = head;
   while (current != null) {
      if (current.getInfo().compareTo(element) > 0) {
         count++;
      }
      current = current.getLink();
   }
   return count;
  }
  
  public SortedLinkedCollection<T> combine(SortedLinkedCollection<T> other) {
   SortedLinkedCollection<T> newCollection = new SortedLinkedCollection<>();
   LLNode<T> thisCurrent = this.head;
   LLNode<T> otherCurrent = other.head;
   
   while (thisCurrent != null && otherCurrent != null) {
      if (thisCurrent.getInfo().compareTo(otherCurrent.getInfo()) <= 0) {
         newCollection.add(thisCurrent.getInfo());
         thisCurrent = thisCurrent.getLink();
      } else {
         newCollection.add(otherCurrent.getInfo());
         otherCurrent = otherCurrent.getLink();
      }
   }
   
   
   while (thisCurrent != null) {
      newCollection.add(thisCurrent.getInfo());
      thisCurrent = thisCurrent.getLink();
   }
   
   while (otherCurrent != null){
      newCollection.add(otherCurrent.getInfo());
      otherCurrent = otherCurrent.getLink();
   }
   
   return newCollection;
   
  }

  public boolean add(T element) {
  // Adds element to this collection.
    LLNode<T> newNode = new LLNode<T>(element);
    
    if (head == null || head.getInfo().compareTo(element) > 0) {
      newNode.setLink(head);
      head = newNode;
    } else {
      LLNode<T> current = head;
      while (current.getLink() != null && current.getLink().getInfo().compareTo(element) <= 0) {
         current = current.getLink();
      }
      newNode.setLink(current.getLink());
      current.setLink(newNode);
    }
    
    numElements++;
    return true;
  }

  protected void find(T target)
  // Searches the collection for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If not successful, sets 
  // found to false.
  {
    location = head;
    found = false;

    while (location != null) 
    {
      if (location.getInfo().equals(target))  // if they match
      {
       found = true;
       return;
      }
      else
      {
        previous = location;
        location = location.getLink();
      }
    }
  }

  public int size()
  {
    return numElements;
  }

  public boolean contains (T target)
  // Returns true if this collection contains an element e such that 
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found)
    {
      if (head == location)     
        head = head.getLink();    // remove first node
      else
        previous.setLink(location.getLink());  // remove node at location

      numElements--;
    }
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);    
    if (found)
      return location.getInfo();
    else
      return null;
  }
  
  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);  
  }

  public boolean isFull()
  {
    return false;
  }  
}
