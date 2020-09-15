public class IntegerLinkedList implements IntegerList {


    private IntegerNode	head;
    private IntegerNode tail;
    private int		    count;

    public IntegerLinkedList(){
        count = 0;
        head = null;
        tail = null;
    }


/*
     *
     * Purpose: add i to the front of this list
     *  more space is allocated if necessary
     *  to add ito the list
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
    public void addFront (int i){
        IntegerNode NewNode = new IntegerNode(i);
        if(head == null){
            tail = NewNode;
        }else{
            head.prev = NewNode;
        }

        NewNode.next = head;
       // NewNode.prev = tail;
        head = NewNode;

        count++;
    }
    
    /*
     *
     * Purpose: add i to the back of this list
     *  more space is allocated if necessary
     *  to add it to the list
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
   public void addBack (int i){
    IntegerNode nn = new IntegerNode(i);
    if (head == null) {
        head = nn;
    } else {
        tail.next = nn;
        nn.prev = tail;
    }
    tail = nn;
       
        count++;
    }
    
    /*
     *
     * Purpose: returns the number of elements in this list
     *
     * Parameters: none
     *
     * Returns: int - the number of elements
     *
     */
  public int size (){
      return count;
  }
    
    /*
     *
     * Purpose: returns the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a IntegerList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: int - the int at position
     *
     */
    public int getAtPosition (int position){
        IntegerNode NewNode = head;
        int i = 0;
        while(NewNode != null){
            if(i == position){
                return NewNode.getElement();
            }
            NewNode = NewNode.next;
            i++;
        }
        return 0;
    }
    
    
    /*
     *
     * Purpose: return the position where i is in the list,
     *  if i is not found returns -1
     *
     * Parameters: int - i
     *
     * Returns: int - position of i, -1 if i does not exist
     *
     */
    public int getPositionOfVal (int i){
        IntegerNode nn = head;
        int position = 0;
        while(nn != null){
            if(nn.getElement() == i){
                return position;
            }
            position++;
            nn = nn.next;
        }
        return -1;
    }

    
    
    
    /*
     *
     * Purpose: computes the sum of only elements in this list
     *      which hold values that are divisible by given divisor
     *
     * Parameters: none
     *
     * Returns: int - the sum
     *
     */
    public int sumDivisible (int divisor){
        IntegerNode nn = head;
        int sum =0;
        while(nn != null){
            if(nn.getElement() % divisor == 0){
                sum = sum + nn.getElement();
            }
            nn= nn.next;
        }
        return sum;
    }
    
    /*
     *
     * Purpose: computes the sum of only elements in this list
     *    at even positions within the list where, the the first
     *    element of the list is considered to be at position 0.
     *
     * Parameters: none
     *
     * Returns: int - the sum
     *
     */
    public int sumEvenPositionElements(){
        IntegerNode nn = head;
        int denom = 0;
        int sum = 0;
        while(nn != null){
            if(denom % 2 == 0){
                sum = sum + nn.getElement();
            }
            denom++;
            nn = nn.next;
        }
        return sum;
    }
    

    /*
     *
     * Purpose: remove all elements with i from the list
     *   The number of occurances of i can be >= 0
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
    public void removeValue(int i){
        IntegerNode cur = head;
    if(!isEmpty()){
        while(cur != null){
            //remove element at front of the list
            if(cur.getElement() == i && head == cur){
                if(head == tail){
                    tail = null;
                }else{
                head.next.prev = null;
                }
                head = head.next;
                count--;
            }else if(cur.getElement() == i && tail == cur){//remove the element at the back of the list
                if(head == tail){
                    head = null;
                }else{
                tail.prev.next = null;
                }
                tail = tail.prev;
                count--;
            }else if(cur.getElement() == i){//remove elements in the middle of the list
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                count--;
            }
            cur = cur.next;
        }
    }
    
    }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }
        return false;
    }

    public void emptyOrOneList(){
        head = null;
        tail = null;
    }
    
    

    
    
    /*
     *
     * Purpose: return a String representing the forward
     *  traversal of this list with a space between each element
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    public String toString(){
        String s = "";
        IntegerNode tmp = head;

        while (tmp!=null) {
            s += tmp.getElement();
            if(tmp.next != null){
                s += " ";
            }
            
            tmp = tmp.next;
        }

        return s;

    }
    
    
    /*
     *
     * Purpose: return a String representing the reverse
     *  traversal of this list with a space between each element
     *
     * Parameters: none
     *
     * Returns: String - the reverse list representation
     *
     */
    public String reverse() {
        String s = "";
        IntegerNode tmp = tail;

        while (tmp!=null) {
            s += tmp.getElement();
            if(tmp.prev != null){
                s += " ";
            }
            //System.out.println("" + tmp);
            tmp = tmp.prev;
        }
        
        return s;
    }
}