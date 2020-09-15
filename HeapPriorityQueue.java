/*
 * HeapPriorityQueue.java
 *
 * An implementation of a minimum PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 *
 * This implementation will throw a Runtime, HeapEmptyException
 *	if the heap is empty and removeLow is called.
 *
 * This implementation will throw a Runtime, HeapFullException
 *	if the heap is full and insert is called.
 *
 */

public class HeapPriorityQueue implements PriorityQueue {
    
    protected final static int DEFAULT_SIZE = 10000;

    protected Comparable[] storage;
    protected int currentSize;

    /* constructor
     *
     * PURPOSE:
     *  initializes storage to new Comparable[] of DEFAULT_SIZE
     *      and initializes currentSize to 0
     *
     * PARAMETERS:
     *  none
     */
        public HeapPriorityQueue(){
            storage = new Comparable[DEFAULT_SIZE];
            currentSize = 0;
        }

    
    /* constructor
     *
     * PURPOSE:
     *  initializes storage to new Comparable[] of given size
     *      and initializes currentSize to 0
     *
     * PARAMETERS:
     *  int size
     */
    public HeapPriorityQueue(int size){
        storage = new Comparable[size];
        currentSize = 0;
    }

/*
	 * PURPOSE:
	 *	Adds element into the PriorityQueue at the position
	 *	according to the element's priority 	.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *	None.
	 *
	 * Examples:
	 * 	If q contains elements that would be accessed in the 
	 * 	following order:  {5,13,21} after q.insert(20) returns,
	 * 	then q will contain elements that will be accessed
	 * 	in the following order: {5,13,20,21}.
	 *
	 */
    

    public void insert ( Comparable element ){
       if(currentSize == storage.length){
           throw new HeapFullException();
       }else{
           currentSize++;
           storage[currentSize - 1] = element;
            BubbleUp(currentSize -1);
       }
    }

    private void BubbleUp(int child){
        Comparable temp;
        int parent;
       // if(child != 0){
            parent = (child - 1)/2;
            if(storage[child].compareTo(storage[parent]) < 0){
                temp = storage[parent];
                storage[parent] = storage[child];
                storage[child] = temp;
                BubbleUp(parent);
           // }
        }

    }


 /*
	 * PURPOSE:
	 *	Remove highest priority element from the PriorityQueue, 
	 *	where the smallest value will be of highest priority.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *	Comparable - the highest priority object in the Queue
	 *
	 * Examples:
	 * 	If q contains elements that would be accessed in the 
	 * 	following order:  {5,13,21},  q.removeLow() returns 5,
	 * 	and then q will contain elements that will be accessed
	 * 	in the following order: {13,21}.
	 *
	 */
	public Comparable removeLow(){
        Comparable ReturnVal = storage[0];
        if(isEmpty()){
            throw new HeapEmptyException();
        }else{
            storage[0] = storage[currentSize - 1];
            currentSize--;
            if(currentSize > 0){
                BubbleDown(0);
            }
        }
        return ReturnVal;
    }
    
    
    private void BubbleDown(int parent){
        int rightChild, leftChild, minIndex;
        Comparable temp;
        leftChild = (2 * parent) + 1;
        rightChild = (2 * parent) + 2;
        if(rightChild >= currentSize){
            if(leftChild >= currentSize){
                return;
            }else{
                minIndex = leftChild;
            }
        }else{
            if(storage[leftChild].compareTo(storage[rightChild]) < 0){
                minIndex = leftChild;
            }else{
                minIndex = rightChild;
            }
        }
        if(storage[parent].compareTo(storage[minIndex]) > 0){
            temp = storage[minIndex];
            storage[minIndex] = storage[parent];
            storage[parent] = temp;
            BubbleDown(minIndex);
        }
    }

	 /*
	 * PURPOSE:
	 *	Determines if the PriorityQueue is empty or not.
	 *
	 * PRECONDITIONS:
	 *	none
	 *
	 * RETURNS:
	 *	true if PriorityQueue is empty, false otherwise.
	 *
	 */
	public boolean isEmpty(){
        if(currentSize == 0){
            return true;
        }
        return false;
    }	
	
	 /*
	 * PURPOSE:
	 *	Determines number of elements in the PriorityQueue.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *	the size of the PriorityQueue.
	 *
	 */			
	public int	size (){
       return currentSize;
    }

    /*
     * PURPOSE:
     *    constructs a String representation of the elements in storage
     *      ordered by their position in storage NOT by priority 
     *
     * PARAMETERS:
     *    None.
     *
     * RETURNS:
     *    String - the String representation
     *
     */
    public String toString() {
        String s = "";
        String sep = "";
        for(int i=0;i<currentSize;i++) {
            s+= sep + storage[i];
            sep = " ";
        }
        return s;
    }

}

