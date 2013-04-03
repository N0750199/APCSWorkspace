// Implements a singly-linked list.

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Object>
{
  private ListNode head;
  private int nodeCount;

  // Constructor: creates an empty list
  public SinglyLinkedList()
  {
    head = null;
    nodeCount = 0;
  }

  // Constructor: creates a list that contains
  // all elements from the array values, in the same order
  public SinglyLinkedList(Object[] values)
  {
    ListNode tail = null;
    for (Object value : values) // for each value to insert
    {
      ListNode node = new ListNode(value, null);
      if (head == null)
        head = node;
      else
        tail.setNext(node);
      tail = node;    // update tail
    }

    nodeCount = values.length;
  }
  
  private boolean inBounds(int i)
  {
	  return i>=nodeCount||i<0;
  }

  // Returns true if this list is empty; otherwise returns false.
  public boolean isEmpty()
  {
    return nodeCount==0;
  }

  // Returns the number of elements in this list.
  public int size()
  {
    return nodeCount;
  }

  // Returns true if this list contains an element equal to obj;
  // otherwise returns false.
  public boolean contains(Object obj)
  {
	  return indexOf(obj)>=0;
  }

  // Returns the index of the first element in equal to obj;
  // if not found, returns -1.
  public int indexOf(Object obj)
  {
	  	int counter=0;
	  	for(ListNode node=head;node!=null;node=node.getNext(),counter++)
	  	{
	  		if(obj.equals(head.getValue()))
	  			return counter;
	  	}
	  
		 return -1;
  }

  // Adds obj to this collection.  Returns true if successful;
  // otherwise returns false.
  public boolean add(Object obj)
  {
	  if(nodeCount!=0)
		  add(nodeCount-1,obj);
	  else
		  add(0,obj);
	  
	  /**
	  ListNode node=new ListNode(obj,null);
	  
	  if(isEmpty())
    	head=node;
	  else
	  {
		  ListNode tail=head;
		  for(int i=0;i<nodeCount;i++)
		  {
			  tail=tail.getNext();
		  }
		  tail.setNext(node);
	  }
	  
	  
	  nodeCount++; */
	  return true;
  }

  // Removes the first element that is equal to obj, if any.
  // Returns true if successful; otherwise returns false.
  public Object remove(Object obj)
  {
	  Object result=null;
	  ListNode before=head;
	  
	  for(ListNode node=head;node!=null;node=node.getNext())
	  {
		  if(head.equals(obj))
		  {
			  result=node.getValue();
			  before.setNext(node.getNext());
			  nodeCount--;
		  }
		  else
			  before=node;
	  }
	  
	  return result;
  }

  // Returns the i-th element.
  public Object get(int i)
  {
	  if(!inBounds(i))
		  return null;
	  
	  int counter=0;
	  Object result=null;
	  
	  for(ListNode node=head;node!=null;node=node.getNext(),counter++)
	  {
		  if(counter==i)
			  result=node.getValue();
	  }
	  
	  return result;
  }

  // Replaces the i-th element with obj and returns the old value.
  public Object set(int i, Object obj)
  {
	  if(!inBounds(i))
		  return null;
	  
	  
	  int counter=0;
	  Object result=null;
	  
	  for(ListNode node=head;node!=null;node=node.getNext(),counter++)
	  {
		  if(counter==i)
		  {
			  result=node.getValue();
			  node.setValue(obj);
		  }
	  }
	  
	  return result;
  }

  // Inserts obj to become the i-th element. Increments the size
  // of the list by one.
  public void add(int i, Object obj)
  {
	  if(!inBounds(i))
		  return;
	  
	  System.out.println("check");
	  int counter=0;
	  ListNode before=head;
	  
	  
	  
	  for(ListNode node=head;node!=null;node=node.getNext(),counter++)
	  {
		  if(counter==i)
		  {
			  before.setNext(new ListNode(obj,node));
			  nodeCount++;
		  }
		  else
		  {
			  before=node;
		  }
	  }
	  
	  if(head==null)
		  head=new ListNode(obj,null);
	  
  }

  // Removes the i-th element and returns its value.
  // Decrements the size of the list by one.
  public Object remove(int i)
  {
	  if(!inBounds(i))
		  return null;
	  
	  
	  int counter=0;
	  Object result=null;
	  ListNode before=head;
	  
	  for(ListNode node=head;node!=null;node=node.getNext(),counter++)
	  {
		  if(counter==i)
		  {
			  result=node.getValue();
			  before.setNext(node.getNext());
		  }
		  else
		  {
			  before=node;
		  }
	  }
	  
	  return result;
  }

  // Returns a string representation of this list.
  public String toString()
  {
	  String result="[";
	  
	  for(ListNode node=head;node!=null;node=node.getNext())
	  {
		  result+=node.getValue().toString();
		  result+=", ";
	  }
	  result+="]";
	  
	  
	  return result;
  }

  // Returns an iterator for this collection.
  public Iterator<Object> iterator()
  {
    return new SinglyLinkedListIterator(head);
  }


  public static void main(String[] args)
  {
	  SinglyLinkedList list=new SinglyLinkedList();
	  
	  list.add(5);
	  list.add(3);
	  list.add(7);
	  
	  System.out.println(list);
	  
  }
}