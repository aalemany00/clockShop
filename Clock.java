import java.util.Calendar;

/**
 * Represents a 24-hour clock with hours, minutes, and seconds.
 * Implements Comparable to allow comparison between Clock objects.
 *
 * @author Adrian Alemany
 * @version October 3, 2025
 */
public class Clock implements Comparable<Clock>{

    /** The hour component (0-23) */
    private int myHour;

    /** The minute component (0-59) */
    private int myMinute;

    /** The second component (0-59) */
    private int mySecond;

    /**
     * Constructs a Clock with the specified time.
     *
     * @param theHour the hour (0-23)
     * @param theMinute the minute (0-59)
     * @param theSecond the second (0-59)
     * @throws IllegalArgumentException if any parameter is out of valid range
     */
    public Clock(final int theHour, final  int theMinute, final  int theSecond){
        setHour(theHour);
        setMinute(theMinute);
        setSecond(theSecond);
    }

    /**
     * Constructs a default Clock set to 23:58:00.
     * Calls the parameterized constructor to initialize values.
     */
    public Clock() {
        this(23, 58, 0);
    }

    /**
     * Returns a string representation of the clock time in HH:MM:SS format.
     *
     * @return the time as a string
     */
    public String toString(){
        return myHour + ":" + myMinute + ":" + mySecond;
    }

    /**
     * Gets the hour component of the clock.
     *
     * @return the hour (0-23)
     */
    public int getHour(){
        return myHour;
    }

    /**
     * Gets the minute component of the clock.
     *
     * @return the minute (0-59)
     */
    public int getMinute(){
        return myMinute;
    }

    /**
     * Gets the second component of the clock.
     *
     * @return the second (0-59)
     */
    public int getSecond(){
        return mySecond;
    }

    /**
     * Sets the hour component of the clock.
     *
     * @param theHour the hour to set (0-23)
     * @throws IllegalArgumentException if theHour is not between 0 and 23
     */
    public void setHour(final int theHour){
        if (theHour < 0 || theHour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        else this.myHour = theHour;
    }

    /**
     * Sets the minute component of the clock.
     *
     * @param theMinute the minute to set (0-59)
     * @throws IllegalArgumentException if theMinute is not between 0 and 59
     */
    public void setMinute(final int theMinute){
        if (theMinute < 0 || theMinute > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        }
        else this.myMinute = theMinute;
    }

    /**
     * Sets the second component of the clock.
     *
     * @param theSecond the second to set (0-59)
     * @throws IllegalArgumentException if theSecond is not between 0 and 59
     */
    public void setSecond(final int theSecond){
        if (theSecond < 0 || theSecond > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        }
        else this.mySecond = theSecond;
    }

    /**
     * Advances the clock by the specified number of hours.
     * The clock wraps around after 24 hours.
     *
     * @param theAmount the number of hours to advance (must be non-negative)
     * @throws IllegalArgumentException if theAmount is negative
     */
    public void advanceHour(final int theAmount){
        if  (theAmount < 0) {
            throw new IllegalArgumentException("Hour must be positive");
        }

        if (theAmount % 24 != 0) {
            setHour(myHour + theAmount % 24);
            if (myHour == 24){
                setHour(0);
            }
        }
    }

    /**
     * Advances the clock by the specified number of minutes.
     * Automatically advances hours when total minutes exceed 59.
     *
     * @param theAmount the number of minutes to advance (must be non-negative)
     * @throws IllegalArgumentException if theAmount is negative
     */
    public void advanceMinute(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException("Minute must be positive");
        }

        int totalMinutes = myMinute + theAmount;
        advanceHour(totalMinutes / 60);
        setMinute(totalMinutes % 60);
    }

    /**
     * Compares this clock with another object for equality.
     * Two clocks are equal if they represent the same time.
     *
     * @param theObject the object to compare with
     * @return true if the objects represent the same time, false otherwise
     */
    @Override
    public boolean equals(final Object theObject){
        if ( theObject == null || !(theObject instanceof Clock)) {
            return false;
        }
        return compareTo((Clock) theObject) == 0;
    }

    /**
     * Compares this clock with another clock chronologically.
     *
     * @param theOtherClock the clock to compare with
     * @return a negative integer if this clock is earlier,
     *         zero if the clocks are equal,
     *         a positive integer if this clock is later
     */
    public int compareTo(final Clock theOtherClock){
        if (this.myHour > theOtherClock.myHour) {
            return 1;
        }
        else if (this.myHour == theOtherClock.myHour) {
            if (this.myMinute > theOtherClock.myMinute) {
                return 1;
            }
            else if (this.myMinute == theOtherClock.myMinute) {
                if (this.mySecond > theOtherClock.mySecond) {
                    return 1;
                }
                else if  (this.mySecond < theOtherClock.mySecond) {
                    return -1;
                }
                else return 0;
            }
            else if (this.myMinute < theOtherClock.myMinute) {
                return -1;
            }
            return 0;
        }
        else if  (this.myHour < theOtherClock.myHour) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Sets the clock to the current system time in the local timezone.
     * Uses System.currentTimeMillis() as the starting point and Calendar
     * to extract the time components.
     */
    public void setToCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis();

        // Create a Calendar instance and set it to current time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);

        // Use existing setter methods
        setHour(calendar.get(Calendar.HOUR_OF_DAY));
        setMinute(calendar.get(Calendar.MINUTE));
        setSecond(calendar.get(Calendar.SECOND));
    }
}