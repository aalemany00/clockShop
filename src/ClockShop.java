import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * Represents a shop that manages a collection of Clock objects.
 * Provides functionality to add, retrieve, sort, and persist clocks.
 *
 * @author Adrian Alemany
 * @version October 3, 2025
 */
public class ClockShop {
    /** The list of clocks in the shop */
    private ArrayList<Clock> myClocks;

    /** Platform-independent newline character */
    private final static String newline = System.lineSeparator();

    /**
     * Constructs a new ClockShop with an empty collection of clocks.
     */
    public ClockShop() {
        myClocks = new ArrayList<Clock>();
    }

    /**
     * Retrieves the clock at the specified index.
     *
     * @param i the index of the clock to retrieve
     * @return the Clock at the specified index
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public Clock getClock(int i) {
        if (i < 0 || i >= myClocks.size()) {
            throw new IllegalArgumentException("Clock number out of bounds");
        }
        return myClocks.get(i);
    }

    /**
     * Replaces the clock at the specified index with a new clock.
     *
     * @param theClock the new Clock to set
     * @param theIndex the index where the clock should be placed
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public void setClock(final Clock theClock, final int theIndex) {
        if (theIndex < 0 || theIndex >= myClocks.size())
            throw new IllegalArgumentException("Index out of bounds");
        myClocks.set(theIndex, theClock);
    }

    /**
     * Reads clock data from a file and populates the clock shop.
     * The file should contain clock times in the format HH:MM:SS,
     * with one clock per line.
     *
     * @param theInputFileName the name of the file to read from
     */
    public void fillClockShop(final String theInputFileName) {
        try {
            File myFile = new File(theInputFileName);
            Scanner myScanner = new Scanner(myFile);
            myScanner.useDelimiter(":|\\r\\n");

            while (myScanner.hasNextInt()) {
                int myHours = myScanner.nextInt();
                int myMinutes = myScanner.nextInt();
                int mySeconds = myScanner.nextInt();

                Clock theClock = new Clock(myHours, myMinutes, mySeconds);
                addClock(theClock);
            }
            myScanner.close();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("File not found");
        }
    }

    /**
     * Returns a string representation of all clocks in the shop.
     * Each clock is displayed on a separate line.
     *
     * @return a string containing all clocks in the shop
     */
    @Override
    public String toString() {
        String myString = "";
        for (int i = 0; i < myClocks.size(); i++) {
            myString += myClocks.get(i).toString() + newline;
        }
        return myString;
    }

    /**
     * Adds a clock to the shop's collection.
     *
     * @param clock the Clock to add to the shop
     */
    public void addClock(final Clock clock) {
        myClocks.add(clock);
    }

    /**
     * Sorts all clocks in the shop in ascending chronological order
     * using selection sort algorithm.
     */
    public void sortClocks() {
        for (int i = 0; i < myClocks.size(); i++) {
            int minIndex = i;
            for  (int j = i + 1; j < myClocks.size(); j++) {
                if (myClocks.get(j).compareTo(myClocks.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Clock temp = myClocks.get(minIndex);
            myClocks.set(minIndex, myClocks.get(i));
            myClocks.set(i, temp);
        }
    }

    /**
     * Writes all clocks in the shop to a file.
     * Each clock is written on a separate line in HH:MM:SS format.
     *
     * @param fileName the name of the file to write to
     * @throws RuntimeException if an I/O error occurs
     */
    public void writeClocksToFile(final String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (int i = 0; i < myClocks.size(); i++) {
                myWriter.write(myClocks.get(i).toString() + newline);
            }
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to the file");
        }
    }

    /**
     * Finds the index of the first occurrence of a clock in the shop.
     *
     * @param clock the Clock to search for
     * @return the index of the clock if found, -1 otherwise
     */
    public int findClock(Clock clock) {
        for (int i = 0; i < myClocks.size(); i++) {
            if (myClocks.get(i).equals(clock)) {
                return i;
            }
        }
        return -1;
    }

}
