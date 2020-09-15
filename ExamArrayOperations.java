import java.lang.Math;

/*
 * ExamArrayOperations
 */
public class ExamArrayOperations {
    
    /*
     * getAllExamLocations
     *
     * Purpose: creates a new array of the locations of all of the exams in the given array
     *
     * Parameters: Exam[] - array
     *
     * Returns: String[] - new array of Exam locations
     *
     */
    // TODO:
    public static String[] getAllExamLocations(Exam[] array){
        String[] locations = new String[array.length];
        int i = 0;

        for(i = 0; i < array.length; i++){
            locations[i] = array[i].getLocation();
        }
        return locations;
    }
    
    
    /*
     * getExamDuration
     *
     * Purpose: gets the duration of the Exam in the given array that is
     *  at the given location.
     * If there is more than one exam at the given location,
     *  it gets the location of the first encountered in the given array.
     *
     * Parameters: Exam[] - array, String - location
     *
     * Returns: int - the duration of the Exam or 0 if Exam location is not found
     *
     */
    // TODO:
    public static int getExamDuration(Exam[] array, String location){
        int i = 0;
        int duration = 0;
        while(i < array.length){
            if(array[i].getLocation().equals(location)){
                duration = array[i].getDuration();
                return duration;
            }
            i++;
        }
        return duration;
    }
    
    
    /*
     * addExam
     *
     * Purpose: creates a new array 1 longer than input array and copies all Exam references
     *  from input array to new array and puts e at the end of new array
     *
     * Parameters: Exam[] - array, Exam - e
     *
     * Preconditions:  e is not null
     *
     * Returns:  Exam[] - the new array
     *
     */
    // TODO:
    public static Exam[] addExam(Exam[] array, Exam e){
        Exam[] new_array = new Exam[array.length + 1];
        int i = 0;
        
        for(i = 0; i < array.length; i++){
            new_array[i] = array[i];
        }
        new_array[i] = e;
        return new_array;

    }
    
    
    
    /*
     * countExamsOnDate
     *
     * Purpose: counts the number of Exams in array with specified Date
     *
     * Parameters: Exam[] - array, Date - date
     *
     * Returns: int - the count
     *
     */
    // TODO:
    public static int countExamsOnDate(Exam[] array, Date date){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].getDate().equals(date)){
                count++;
            }
        }
        return count;
    }
    
    
    /*
     * removeExamsWithDate
     *
     * Purpose: if input array has Exams with the given date,
     *      returns a new array with only those Exams without the given date.
     *  The size of the new array must match the number of Exams
     *      without the given date in the given array.
     *  If the given array does not have an Exam with the given date,
     *      it returns the input array unchanged.
     *
     * Parameters: Exam[] - array, Date date
     *
     * Returns: Exam[] - new array
     *
     */
    // TODO:
    public static Exam[] removeExamsWithDate(Exam[] array, Date date){
        Exam[] ExamsWithoutDate = new Exam[array.length - countExamsOnDate(array, date)];
        int j = 0;
        for(int i = 0; i < array.length; i++){

            if(!array[i].getDate().equals(date)){
                ExamsWithoutDate[j] = array[i];
                j++;
            }

        }

        return ExamsWithoutDate;
    }
    
    
    
    /*
     * getEarliestTimeExam
     *
     * Purpose: get the Exam from array that has the earliest startTime
     *  If there is more than one Exam that is the earliest,
     *  use the first occurance of the earliest in array
     *
     * Parameters: Exam[] - array
     *
     * Precondition: array is not empty
     *
     * Returns: Exam - oldest Exam
     *
     */
    // TODO:
    public static Exam getEarliestTimeExam(Exam[] array){
        int i = 0;
        Exam OldestExam = array[i];
        
        for(i = 0; i < array.length; i++){
            if(!OldestExam.getStartTime().isBefore(array[i].getStartTime())){
                if(!OldestExam.getStartTime().equals(array[i].getStartTime())){
                OldestExam = array[i];
                }
            }
        }
        return OldestExam;
    }
    
    
    
}
