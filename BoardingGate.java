/*
 * represents a transit boarding gate (train, airplane, etc.)
 */

public class BoardingGate {
    
    private PriorityQueue passengers;

    /* constructor
     *
     * PURPOSE:
     *  initialize passengers to the default capacity of a HeapPriorityQueue
     *
     * PARAMETERS:
     *  none
     */
    public BoardingGate(){
        passengers = new HeapPriorityQueue();
    }
    

    
    /* constructor
     *
     * PURPOSE:
     *  initialize passengers to a new HeapPriorityQueue of given size
     *
     * PARAMETERS:
     *  int size - capacity of passengers
     */
    public BoardingGate(int size){
        passengers = new HeapPriorityQueue(size);
    }

    
    /* addPassenger
     * PURPOSE:
     *  add given Passenger p to passengers and
     *  prints a notification message if passengers is full
     *
     * PARAMETERS:
     *  Passenger p - Passenger to be added
     *
     * RETURNS:
     *  None.
     */
    public void addPassenger(Passenger p){
        try{
        passengers.insert(p);
        }catch(HeapFullException e){
            System.out.println("No room left on the flight");
        }
    }

    
    
    /* numPassengersWaiting
     * PURPOSE:
     *  returns the number of Passengers in passengers waiting to board
     *
     * PARAMETERS:
     *  None.
     *
     * RETURNS:
     *  int - number of passengers waiting to board
     */
    public int numPassengersWaiting(){
        return passengers.size();
    }

    
    
    /* nextPassenger
     *
     * PURPOSE:
     *  removes and returns the next Passenger from passengers
     *
     * PARAMETERS:
     *  None.
     *
     * RETURNS:
     *  Passenger - the next Passenger, null if there is no more Passengers.
     */
    public Passenger nextPassenger(){
        try{
            Passenger noob = (Passenger)passengers.removeLow();
            return noob;
        }catch(HeapEmptyException e){
            return null;
        }
    }

}

