/*
 * Exam class representing a scheduled exam
 */
public class Exam {

    // TODO add Exam attributes/fields..
    private Date date;
    private Time startTime;
    private int duration;
    private String location;
    /* Exam
     * Purpose: Initialize this instance of Exam with parameter values
     *  location is set to "TBA", duration is set to default 180 minutes
     *
     * Parameters: Date date, Time startTime
     *
     */
    // TODO...
    public Exam(Date date, Time startTime){
        this.date = date;
        this.startTime = startTime;
        location = "TBA";
        duration = 180;
    }
    


    /* Exam
     * Purpose: Initialize this instance of Exam with parameter values
     *
     * Parameters: Date date, String location, Time startTime, int duration
     *
     */
    // TODO...
    public Exam(Date date, String location, Time startTime, int duration){
        this.date = date;
        this.location = location;
        this.startTime = startTime;
        this.duration = duration;
    }
    

    

    /* getDate
     * Purpose: Returns the date associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: Date - date associated with this Exam
     */
    // TODO...
    public Date getDate(){
        return date;
    }


    /* setDate
     * Purpose: sets the date associated with this Exam to parameter value
     *
     * Parameters: Date date
     *
     * Returns: nothing
     */
    // TODO...
    public void setDate(Date date){
        this.date = date;
    }


    /* getLocation
     * Purpose: Returns the location associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: String - location associated with this Exam
     */
    // TODO...
    public String getLocation(){
        return location;
    }


    /* setLocation
     * Purpose: sets the location associated with this Exam to parameter value
     *
     * Parameters: String location
     *
     * Returns: nothing
     */
    // TODO...
    public void setLocation(String location){
        this.location = location;
    }


    /* getStartTime
     * Purpose: Returns the startTime associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: Time - startTime associated with this Exam
     */
    // TODO...
    public Time getStartTime(){
        return startTime;
    }


    /* setStartTime
     * Purpose: sets the startTime associated with this Exam to parameter value
     *
     * Parameters: Time startTime
     *
     * Returns: nothing
     */
    // TODO...
    public void setStartTime(Time startTime){
        this.startTime = startTime;
    }

    
    /* getDuration
     * Purpose: Returns the duration associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: int - duration associated with this Exam
     */
    // TODO...
    public int getDuration(){
        return duration;
    }


    /* setDuration
     * Purpose: sets the duration associated with this Exam to parameter value
     *
     * Parameters: int duration
     *
     * Precondition: duration >= 60
     *
     * Returns: nothing
     */
    // TODO...
    public void setDuration(int duration){
        this.duration = duration;
    }



    /* isOverlap
     * Purpose: determines whether the date and time of this Exam
     *  overlaps with the other Exam date and time
     *
     * Parameters: Exam - other
     *
     * Precondition: other is not null
     *
     * Returns: boolean - true if this Exam overlaps with other, false otherwise
     *
     * HINT: instructor made use of addTime method in the Time class
     *  Be careful how you use it as it is an instance method that updates the instance data
     */
    // TODO...
    public boolean isOverlap(Exam other){
       Time end_time_exam_1 = new Time(this.startTime.getHour(), this.startTime.getMinute());//this equals the time after the exams
       end_time_exam_1.addTime(this.duration);

        Time end_time_exam_2 = new Time(other.startTime.getHour(), other.startTime.getMinute());
        end_time_exam_2.addTime(other.duration);

        /*if(other.date.getMonth().equals(this.date.getMonth()) && other.date.getDay() == this.date.getDay() && other.date.getYear() == this.date.getYear()){
            if(this.startTime.getHour() < other.startTime.getHour()){
                if(end_time_exam_1.getHour() > other.startTime.getHour()){
                    return true;
            }
        }
            if(this.startTime.getHour() > other.startTime.getHour()){
                if(end_time_exam_2.getHour() > this.startTime.getHour()){
                    return true;
            }
        }
        if(this.startTime.getHour() == other.startTime.getHour()){
            return true;
        }
        }
        return false;*/
        if(other.date.getMonth().equals(this.date.getMonth()) && other.date.getDay() == this.date.getDay() && other.date.getYear() == this.date.getYear()){
        if(this.startTime.isBefore(other.startTime)){
            if(other.startTime.isBefore(end_time_exam_1)){
                return true;
            }
        }
        if(other.startTime.isBefore(this.startTime)){
            if(this.startTime.isBefore(end_time_exam_2)){
                return true;
            }
        }
        if(this.startTime.getHour() == other.startTime.getHour() && this.startTime.getMinute() == other.startTime.getMinute()){
            return true;
        }
    }    
    return false;
    }


    /* toString
     * Purpose: returns a String representing this Exam formated as:
     *  date: location: startTime-endTime
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Exam
     *
     * Example:
     *  Exam e = new Exam(new Date("October",25,2019), "ECS 125", new Time(9,30), 120);
     *  e.toString() returns "October 25, 2019: ECS 125: 9:30am-11:30am"
     *
     * HINT: instructor made use of addTime method in the Time class
     *  Be careful how you use it as it is an instance method that updates the instance data
     */
    // TODO...
    public String toString(){
        String new_string = date + ": " + location + ": " + startTime + "-";
        startTime.addTime(duration);

        String final_string = new_string + startTime;
        return final_string;
    }
}
