public class RecursiveIntegerLinkedList implements IntegerList {
    
    private IntegerNode    head;
    private IntegerNode    tail;
    private int		count;
    private int position = 0;
    
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
    public int getAtPosition(int position){
        return getAtPosition(head, position);
    }

    private int getAtPosition (IntegerNode curhead, int position){
        if(curhead == null){
            return 0;
        }else{
            
        int curVal = curhead.getElement();
        IntegerNode rest = curhead.next;

        if(position == 0){
            return curVal;
        }else{

            position--;
           return getAtPosition(rest, position);

        }
        }
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
        return getPositionOfVal(i, position, head);
    }

    private int getPositionOfVal(int i, int position, IntegerNode curhead){
        if(curhead == null){
            return -1;
        }else{
            IntegerNode first = curhead;
            IntegerNode rest = curhead.next;
5:21 PM 2020-02-25
            if(i == first.getElement()){
                return position;
            }else{
                position++;
                return getPositionOfVal(i, position, rest);
            }
        }
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
        return sumDivisible(divisor, head);
    }

    private int sumDivisible(int divisor, IntegerNode curhead){
        if(curhead == null){
            return 0;
        }else{
            IntegerNode first = curhead;
            int firstVal = first.getElement();
            IntegerNode rest = curhead.next;

            if(firstVal % divisor == 0){
                return firstVal + sumDivisible(divisor, rest);
            }else{
                return sumDivisible(divisor, rest);
            }
        }
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
        return sumEvenPositionElements(head, position);
    }

    private int sumEvenPositionElements(IntegerNode curhead, int position){
        if(curhead == null){
            return 0;
        }else{
            IntegerNode first = curhead;
            int firstVal = first.getElement();
            IntegerNode rest = curhead.next;

            if(position % 2 == 0){
                position++;
                return firstVal + sumEvenPositionElements(rest, position);
            }else{
                position++;
                return sumEvenPositionElements(rest, position);
            }
        }
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
        removeValue(i, head);
    }
    private void removeValue(int i, IntegerNode curhead){
        if(curhead == null){
            return;
        }else{
            IntegerNode cur = curhead;
            IntegerNode rest = cur.next;
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
            removeValue(i, rest);
        }
    
    }

    /*public boolean isEmpty(){
        if(count == 0){
            return true;
        }
        return false;
    }

    public void emptyOrOneList(){
        head = null;
        tail = null;
    }*/
    

    
    
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
        return toString(head);
    }
    
    public String toString(IntegerNode n){
        String s = "";
        if(n == null){
            return "";
        }else{
            int firstVal = n.getElement();
            IntegerNode rest = n.next;
            if(n.next != null){
            s+= firstVal + " " + toString(rest);
            }else{
                s+= firstVal;
            }  
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
    public String reverse(){
        return reverse(tail);
    }
    
    public String reverse(IntegerNode n){
        String s = "";
        if(n == null){
            return "";
        }else{
            int lastVal = n.getElement();
            IntegerNode rest = n.prev;
            if(n.prev != null){
            s+= lastVal + " " + reverse(rest);
        }else{
            s+= lastVal;
        }
    }
    return s;
    }
}