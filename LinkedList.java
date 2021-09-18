public abstract class LinkedList{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a){
    head = new Node(a[0],null);
    Node tail= head;
    for(int i=1;i<a.length;i++){
     Node n=new Node(a[i],null);
     tail.next=n;
     tail=n;
    }
  }
  public abstract void LinekIn();
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    head = h;
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
    int count = 0;
    for (Node x=head; x!=null; x=x.next){
    count++;
    }
    return count; 
  }
  
  /* prints the elements in the list */
  public void printList(){
    for (Node x=head; x!=null; x=x.next){
      if (x.next==null){
    System.out.print(x.element+".");
      }
      else {
      System.out.print(x.element+",");
      }
    }
    System.out.println();
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
    int count=0;
    for (Node x=head; x!=null; x=x.next,count++){
      if(count==idx){
      return x;
      }
    }
    return null;
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    int count=0;
    for (Node x= head; x!=null; x = x.next, count++){
      if(count==idx){
      return x.element;
      }
    }
    return null;
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
    int count=0;
    Object temp;
    for (Node x=head; x!=null; x=x.next,count++){
      if (count==idx){
      temp = x.element;
      x.element = elem;
      return temp;
      }
    }
    return null;
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    int count=0;
    for (Node x=head; x!=null; x=x.next,count++){
      if ((int)x.element==(int)elem){
      return count;
      }
    }
    return -1;
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    for (Node x= head; x!=null; x=x.next){
      if (x.element==elem){
      return true;
      }
    }
    return false;
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    Node cHead = new Node (head.element, null);
    Node tail=cHead;
    for (Node x= head.next; x!=null; x=x.next){
    Node k = new Node (x.element, null);
    tail.next = k;
    tail = k;
    }
    return cHead;
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    Node rhead = new Node (head.element, null);
    for (Node x=head.next; x!=null; x=x.next){
    Node n = new Node (x.element, null);
    n.next = rhead;
    rhead = n;
    
    }
    return rhead;
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
    Node n = new Node (elem,null);
    if (idx==0){
      n.next = head;
    head = n;
    }
    else if (idx>0){
    Node temp = nodeAt(idx-1);
    n.next = temp.next;
    temp.next = n;
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int idx){
    if (idx==0){
    Object element = head.element;
    head = head.next;
    return element;
    }
    else if (idx > 0){
    Node n = nodeAt(idx);
    Object element = n.element;
    Node m = nodeAt(idx-1);
    m.next = n.next;
    return element;
    }
    return null;
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    Object elem = head.element;
    head = head.next;
    Node n = new Node (elem,null);
    for (Node x=head; x!=null; x=x.next){
      if (x.next==null){
      x.next = n;
      break;
      }
    }
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
    Node temp = new Node (null,null);
    for (Node m=head, n=head.next; n!=null; m=m.next, n=n.next){
      if (n.next==null){
      temp.element = n.element;
      m.next=null;
      break;
      }
    }
    temp.next = head;
    head = temp;
  }
  
}