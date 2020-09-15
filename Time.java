/*
 * Time class
 *  represents time on a 24 hour clock in hours and minutes
 *  from 0:0 to 23:59
 */
public class Time {

    // TODO: add Time attributes/fields..
    private int hour;
    private int minute;
    /* Time
     * Purpose: Initialize this instance of Time with values for a time of 0:0
     *
     * Parameters: nothing
     */
    // TODO...
    public Time(){
        hour = 0;
        minute = 0;
    }


	/* Time
     * Purpose: Initialize this instance of Time with parameter values
     *
     * Parameters: int hour, int minute
     *
     * Precondition: hour and minute specify a valid time on a 24 hour clock
     */
    // TODO...
    public Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    

    /* getHour
     * Purpose: Returns the hour associated with this Time
     *
     * Parameters: nothing
     *
     * Returns: (int) - hour associated with this Time
     */
    // TODO...
    public int getHour(){
        return hour;
    }


    /* setHour
     * Purpose: sets the hour associated with this Time to parameter value
     *
     * Parameters: int hour
     *
     * Precondition: 0 <= hour <= 23
     *
     * Returns: nothing
     */
    // TODO...
    public void setHour(int hour){
        this.hour = hour;
    }


    /* getMinute
     * Purpose: Returns the minute associated with this Time
     *
     * Parameters: nothing
     *
     * Returns: (int) - minute associated with this Time
     */
    // TODO...
    public int getMinute(){
        return minute;
    }


    /* setMinute
     * Purpose: sets the minute associated with this Time to parameter value
     *
     * Parameters: int minute
     *
     * Precondition: 0 <= minute <= 59
     *
     * Returns: nothing
     */
    // TODO...
    public void setMinute(int minute){
        this.minute = minute;
    }




    /* equals
     * Purpose: determines whether the hour and minute of
     *  this instance of Time is equal to other's hour and minute
     *
     * Parameters: Time other
     *
     * Precondition: other is not null and is a valid 24 hour clock time
     *
     * Returns: boolean - true if this Time equals other Time, false otherwise
     */
    // TODO...
    public boolean equals(Time other){
        if(this.hour == other.hour && this.minute == other.minute){
            return true;
        }
        return false;
    }

    
    /* isBefore
     * Purpose: determines whether this instance of Time
     *   is strictly less that of other Time
     *
     * Parameters: Time other
     *
     * Precondition: other is not null and is a valid 24 hour clock Time
     *
     * Returns: boolean - true if this Time is before other Time, false otherwise
     */
    // TODO...
    public boolean isBefore(Time other){
        if(this.hour < other.hour){
            return true;
        }else if(this.hour == other.hour){
            if(this.minute < other.minute){
                return true;
            }
        }
        return false;
    }


    
    /* addTime
     * Purpose: updates the values of this Time's hour and minute
     *  by adding the given minutes.
     *  The updated time is a valid 24 hour clock Time
     *
     * Parameters: int minutes
     *
     * Precondition: minutes >= 0
     *
     * Example:
     *  Time t = new Time(23, 30);
     *  t.addTime(70) will change t's hour to 0 and minute to 40
     *  This is because 23:30 == 11:30pm,
     *  we add 70 minutes (1 hr, 10 minutes) => 12:40am = 0:40 on 24 hour clock
     *  RECALL 00:00 is 12:00am which is midnight
     */
    // TODO...
    public void addTime(int minutes){
        int hour_addition = (this.minute + minutes)/60;
        int minute_addition = (this.minute + minutes)%60;
        if((this.hour + hour_addition) < 24){
            this.hour = this.hour + hour_addition;
        }else{
            this.hour = this.hour + hour_addition - 24;
        }
        this.minute = minute_addition;

    }
    



    /* toString
     * Purpose: returns a String representing this Time formated as:
     *  hour:minute am/pm
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Time
     *
     * Example:
     *  Time t = new Time(22, 2)
     *  t.toString() returns "10:2pm"
     *  NOTICE: ignore that the leading 0 is not printed in the minutes
     *  Time t = new Time(0, 22)
     *  t.toString() returns "0:22am"
     *  NOTICE: we are representing 0:00am as 0:0am, not 12:00am to simplify
     */
    // TODO...
    public String toString(){
        if(hour < 12 && hour != 0){
            return hour + ":" + minute + "am";
        }else if(hour == 0){
            return hour + ":" + minute + "am";
        }else{
            return (hour - 12) + ":" + minute + "pm";
        }
        
    }
    

}
