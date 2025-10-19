/**
 * Simple test for setToCurrentTime() method.
 */
public class TestCurrentTime {
    public static void main(String[] args) {
        System.out.println("Testing setToCurrentTime() method");
        System.out.println("----------------------------------");

        Clock myClock = new Clock(1, 1, 1);
        System.out.println("Clock before: " + myClock);

        myClock.setToCurrentTime();
        System.out.println("Clock after setToCurrentTime(): " + myClock);
        System.out.println("System time for comparison: " + java.time.LocalTime.now());
    }
}
