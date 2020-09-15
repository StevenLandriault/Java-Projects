public class ExamArrayList implements ExamListInterface {
    
    private static final int INITIAL_CAPACITY = 2;
    
    private Exam[]	    storage;  // holds Exams, each with a unique course
    private int		    numExams;
    
    /*
     *
     * Purpose:
     *    Initialize a new instance of PlayerList
     *
     */
    public ExamArrayList() {
        // You must allocate an array to be able
        // to hold INITIAL_CAPACITY Exam objects
        // You must set numExams to be 0
        storage = new Exam[INITIAL_CAPACITY];
        numExams = 0; 
        
    }
    
    /* get
     *
     * Purpose: returns the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a ExamList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: Exam - the Exam at position
     *
     */
    public Exam get (int position){
        return storage[position];
    }
    

    
    /* size
     *
     * Purpose: returns the number of elements in the list
     *
     * Parameters: none
     *
     * Returns: int - the number of elements
     *
     */
    public int size(){
        return numExams;
    }
    
    /* add
     *
     * Purpose: add Exam e to the Examlist
     *  more space is allocated for the Examlist if necessary
     *  to add e to the list
     *
     * Parameters: Exam e
     *
     * Returns: nothing
     *
     */
    public void add (Exam e){
        if(numExams >= storage.length){
            growAndCopy();
        }
        storage[numExams] = e;
        numExams++;
    }

    public void growAndCopy(){
        Exam[] doubleArray = new Exam[storage.length * 2];
        for(int i = 0; i < storage.length; i++){
            doubleArray[i] = storage[i];
        }
        storage = doubleArray;
    }
    
    /* find
     *
     * Purpose: return the position where Exam with given course is in the Examlist,
     *  if Exam with course is not found, returns -1
     *
     * Parameters: String course
     *
     * Pre-Conditions: course is not null
     *
     * Returns: int - position of Exam with course, -1 if it does not exist
     *
     */
    public int find (String course){
        int i = 0;
        for(i = 0; i < numExams; i++){
            if(storage[i].getCourse().equals(course)){
                return i;
            }
        }
        return -1;
    }
    
    /* removeAtPos
     *
     * Purpose: removes the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *    for a ExamList x:
     *        position >= 0 AND
     *        position < x.size()
     *
     * Returns: nothing
     *
     */
   public void removeAtPos (int position) {
        Exam[] PosRem = new Exam[storage.length];
        int j = 0;
        //System.out.println("number of exams" + numExams);
        for(int i = 0; i <= numExams; i++){
            if(i != position){
                PosRem[j] = storage[i];
                j++;
            }else{
                numExams--;
            }
        }
        storage = PosRem;

    }
    
    /* removeAllOnDate
     *
     * Purpose: removes all Exams that are on given date
     *    from this ExamList
     *
     * Parameters: Date date
     *
     * Pre-Conditions: date is not null
     *
     * Returns: nothing
     *
     */
    public void removeAllOnDate (Date date){
        Exam[] rDate = new Exam[storage.length];
        int j = 0;
        for(int i = 0; i <= numExams && j < numExams; i++){
            if(!storage[i].getDate().equals(date)){
                rDate[j] = storage[i];
                j++;
            }else{
                numExams--;
            }
        }
        storage = rDate;
    }
    
    // public int countOnDate(Date date){
    //     int count = 0;
    //     for(int i = 0; i < numExams; i++){
    //         if(storage[i].getDate().equals(date)){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
  
    
    /* toString
     *
     * Purpose: return a String representing the forward traversal
     *  with a space after each element
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    public String toString() {
        String s = "";
        
        for(int i=0; i<numExams; i++) {
            s += storage[i];
            if(i != (numExams-1))
                s += " ";
        }
        
        return s;
    }

}