public class ArrayQueue implements Queue{
  int size;
  int front;
  int rear;
  Object [] data;
  
  public ArrayQueue(){
    size=0;
    front = -1;
    rear = -1;
    data = new Object[5];
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
    if(size==data.length){
    throw new QueueOverflowException();
    }
    front=0;
    data[size]=o;
    size++;
    rear+=1;
  } 
  
// Removes the item in the front of the queue, throwing the 
// QueueUnderflowException if the queue is empty.
  public Object dequeue() throws QueueUnderflowException{
    if(size==0){
    throw new QueueUnderflowException();
    }
    else{
    Object rt=data[front];
    data[front]=null;
    front++;
    size--;
    return rt;
  }
  }
// Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
  public Object peek() throws QueueUnderflowException{
    if(size==0){
    throw new QueueUnderflowException();
    }
    return data[front];
  }
  
// Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
  public String toString(){
    if(size<=0){
    return "Empty Queue";
    }
    String so="";
    
    for(int j=front,i=0; i<size;i++,j++){
    so+=(data[j]+" ");
    }
    return so;
  }
  
// Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
  public Object[] toArray(){
    Object ar[]=new Object[size];
    
    for(int j=front,i=0; i<size;i++,j++){
    ar[i]=data[j];
    }
    return ar;
  }
  
// Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
  public int search(Object o){
    int count=-1;
    int j=front;
    for(int i=0;i<size;i++,j++){
      if(o==data[j]){
      count+=(i+1);
      }
    }
    return count;
  }
  
}