public class ExamSchedule {
    
    private String              sid;        // student unique sid
    private ExamListInterface	examlist;   // list of exams
    
    
    /* constructor
     *
     * Purpose: initialize this instance of ExamSchedule
     * 	with sid passed in and an empty ExamList
     * Parameters: String sid
     *
     */
    // ToDo:
    public ExamSchedule(String sid){
        this.sid = sid;
        examlist = new ExamArrayList();
    }
    
    /*
     *
     * Purpose: initialize this instance of ExamSchedule
     *     with sid passed in and a new ExamList
     *     with e added to it
     * Parameters: String sid, Exam e
     *
     */
    // ToDo:
    public ExamSchedule(String sid, Exam e){
        this.sid = sid;
        examlist = new ExamArrayList();
        examlist.add(e);
    }

    
    
    
    /* getSid
     *
     * Purpose: return the sid associated with this instance
     *
     * Parameters: none
     *
     * Returns: String - the sid
     *
     */
    // ToDo:
    public String getSid(){
        return sid;
    }
    
    /* setSid
     *
     * Purpose: change the sid associated with this instance to parameter value
     *
     * Parameters: String - sid
     *
     * Returns: nothing
     *
     */
    // ToDo:
    public void setSid(String sid){
        this.sid = sid;
    }
    
    /* getExamCount
     *
     * Purpose: return the number of Exams associated with this ExamSchedule
     *
     * Parameters: none
     *
     * Returns: int - the number of Exams
     *
     */
    // ToDo:
    public int getExamCount(){
        return examlist.size();
    }
    
    /* addExams
     *
     * Purpose: add all exams to examlist
     *
     * Parameters: Exam[] exams
     *
     * Precondition: exams is not null
     *
     * Returns: void
     *
     */
    // ToDo:
    public void addExams(Exam[] exams){
        for(int i = 0; i < exams.length; i++){
            examlist.add(exams[i]);
        }
    }
    
    
    
    /* removeExam
     *
     * Purpose: remove Exam with course from the list of Exams associated with this ExamSchedule
     *	if course is not in the list, do nothing.
     *
     * Parameters: String course
     *
     * Returns: nothing
     *
     */
    // ToDo:
    public void removeExam(String course){
        int remove = examlist.find(course);
        examlist.removeAtPos(remove);
    }
    
    
    
    /* clearDay
     *
     * Purpose: removes all Exams from examlist that are on month, day, year
     *
     * Parameters: String month, int day, int year
     *
     * Precondition: month, day and year represent a valid Date
     *
     */
    // ToDo:
    public void clearDay(String month, int day, int year){
        Date date = new Date(month, day, year);
        examlist.removeAllOnDate(date);
    }
    
    
    
    /* toString
     *
     * Purpose: return a String representation of this ExamSchedule
     *
     * Parameters: none
     *
     * Returns: String - the representation
     *
     */
    public String toString() {
        String s = sid;
        
        for (int i=0; i<examlist.size(); i++) {
            s += "\n";
            s += examlist.get(i);
        }
        return s;
    }
}
