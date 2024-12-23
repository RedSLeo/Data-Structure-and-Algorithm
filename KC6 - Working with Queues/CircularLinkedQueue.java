//---------------------------------------------------------------------------
// LinkedQueue.java            by Dale/Joyce/Weems                  Chapter 4
//
// Implements QueueInterface using a linked list.
//---------------------------------------------------------------------------

package ch04.queues;

import support.LLNode;

public class CircularLinkedQueue<T> implements QueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  public CircularLinkedQueue()
  {
    front = null;
    rear = null;
    numElements = 0;
  }

  public void enqueue(T element) { 
    LLNode<T> newNode = new LLNode<T>(element);
    
    if (isEmpty()){    
      front = newNode;      
    } else {    
      rear.setLink(newNode);      
    }
    
    rear = newNode;
    rear.setLink(front);
    numElements++;
    
  }     

  public T dequeue(){
  
    if (isEmpty()) {
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");     
    }
      T element;
      element = front.getInfo();
      
      if (front == rear) {
        front = null;
        rear = null;
      } else { 
      front = front.getLink();
      rear.setLink(front);
    }
    
    numElements--;
    return element;
      
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (front == null);
  }
  
  public boolean isFull()
  // Returns false - a linked queue is never full.
  {              
    return false;
  }

  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }
  
  public String toString() {
   if(isEmpty()) {
      return "";
   }
   
   StringBuilder result = new StringBuilder("Queue: ");
   LLNode<T> current = front;
   
   do {
      result.append(current.getInfo()).append(" ");
      current = current.getLink();
   } while (current != front);
   
   return result.toString();
  }

}

