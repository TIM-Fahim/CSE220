public class ListQueue implements Queue{
  int size;
  Node front;
  Node rear;
  
  
  public ListQueue(){
    size = 0;
    front = null;
    rear = null;
  }
// The number of items in the queue
  public int size(){
    return size;
  }
  
// Returns true if the queue is empty
  public boolean isEmpty(){
    if(size==0){
      return true;
    }
    return false;
  }
  
// Adds the new item on the back of the queue, throwing the
// QueueOverflowException if the queue is at maximum capacity. It
// does not throw an exception for an "unbounded" queue, which 
// dynamically adjusts capacity as needed.
  public void enqueue(Object o) throws QueueOverflowException{
    if(size>=6){
      throw new QueueOverflowException();
    }
    else if(front==null){
      Node n=new Node(o,null);
      front=rear=n;
      size++;
    }
    else{
      Node n=new Node(o,null);
      rear.next=n;
      rear=n;
      size++;
    }
  } 
  
// Removes the item in the front of the queue, throwing the 
// QueueUnderflowException if the queue is empty.
  public Object dequeue() throws QueueUnderflowException{
    if(front==null){
    throw new QueueUnderflowException();
    }
    else if(front.next==null){
    size--;
    Object temp=front.val;
    front.val=null;
    front=null;
    return temp;
    }
    Object temp=front.val;
    front.val=null;
    front=front.next;
    size--;
    return temp;
  }
  
// Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
  public Object peek() throws QueueUnderflowException{
    if(front==null){
    throw new QueueUnderflowException();
    }
    return front.val;
  }
  
// Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
  public String toString(){
    if(front==null){
      return "Empty Queue";
    }
    String so="";
    for(Node m=front;m!=null;m=m.next){
      so+=(m.val+" "); 
    }
    return so;
  }
  
// Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
  public Object[] toArray(){
    Object ar[]=new Object[size];
    if(front==null){
      return ar;
    }
    ar=new Object[size];
    int i=0;
    for(Node m=front;m!=null;m=m.next,i++){
      ar[i]=m.val;
    }
    return ar;
  }
  
// Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
  public int search(Object o){
    int count=-1;
    int i=0;
    for(Node m=front;m!=null;m=m.next,i++){
      if(m.val==o){
        count=i;
        break;
      }
    }
    return count;
  }
}