import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Use this class to test your ClockShop class.
 *
 * NOTE: This code will not compile until you write the code for the Clock and ClockShop classes
 *
 * NOTE 2: DO NOT try running these tests until ALL tests from ClockTests pass
 *
 * You do not need to document this class.
 *
 * @author tomUW
 *
 */
public class ClockShopTests {
	private final static String newline = System.lineSeparator();

	public static void main(String[] args) {
		System.out.println("---CLOCKSHOP TESTS---");
		testFillClockShop();
		testToString();
		testSetClock();
		testGetClock();
		testFindClock();
		testWriteClocksToFile();
		testSortClocks();
		System.out.println("---END CLOCKSHOP TESTS---");

	}

	private static void testSortClocks() {

		System.out.println("CLOCKSHOP SORTCLOCKS TESTS");
		ClockShop clockShop = new ClockShop();
		
		System.out.println("Testing with a single default clock");
		clockShop.addClock(new Clock());
		System.out.println("Before: ");
		System.out.println(clockShop.toString());
		clockShop.sortClocks();
		System.out.println("After: ");
		System.out.println(clockShop.toString());
		if (clockShop.toString().equals("23:58:00" + newline)
			|| clockShop.toString().equals("23:58:0" + newline)){
			System.out.println("\tPASSED single clock sort");
		}
		else{
			System.out.println("\tFAILED single clock sort: " + clockShop.toString());
		}
		
		System.out.println("\nTesting with two clocks (12, 12, 12) and (11, 11, 11)");
		clockShop = new ClockShop();
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(11, 11, 11));
		System.out.println("Before: ");
		System.out.println(clockShop.toString());
		clockShop.sortClocks();
		System.out.println("After: ");
		System.out.println(clockShop.toString());
		if (clockShop.toString().equals("11:11:11" + newline
			+ "12:12:12" + newline)){
			System.out.println("\tPASSED two clock sort");
		}
		else{
			System.out.println("\tFAILED two clock sort: " + clockShop.toString());
		}
		
		System.out.println("\nTesting with five clocks");
		System.out.println("(12:12:12), (11:11:11), (12:12:12), (10:10:10), (11:11:10)");
		clockShop = new ClockShop();
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(11, 11, 11));
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(10, 10, 10));
		clockShop.addClock(new Clock(11, 11, 10));
		System.out.println("Before: ");
		System.out.println(clockShop.toString());
		clockShop.sortClocks();
		System.out.println("After: ");
		System.out.println(clockShop.toString());

		if (clockShop.toString().equals("10:10:10" + newline
			+ "11:11:10" + newline
			+ "11:11:11" + newline
			+ "12:12:12" + newline
			+ "12:12:12" + newline)){
			System.out.println("\tPASSED five clock sort");
		}
		else{
			System.out.println("\tFAILED five clock sort: " + clockShop.toString());
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testToString() {

		System.out.println("CLOCKSHOP TOSTRING TESTS");
		System.out.println("Testing toString with empty ClockShop -- nothing should be printed as result of this test");
		System.out.println("Note that fillClockShop tests also indirectly tests toString");
		ClockShop clockShop = new ClockShop();
		System.out.println(clockShop.toString());
		if (clockShop.toString().equals("")){
			System.out.println("\tPASSED toString for empty ClockShop");
		}
		else{
			System.out.println("\tFAILED toString for empty ClockShop");
		}

		System.out.println("-------------------------------------------");
	}

	private static void testGetClock() {
		System.out.println("CLOCKSHOP GETCLOCK TESTS");

		ClockShop clockShop = new ClockShop();
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(11, 11, 11));
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(10, 10, 10));
		clockShop.addClock(new Clock(11, 11, 10));

		System.out.println("Here are the clocks in the clock shop after filling with 5 clocks:");
		System.out.println(clockShop.toString());

		System.out.println("Testing with index of -1, should throw an IllegalArgumentException");
		try {
			Clock clock = clockShop.getClock(-1);
			System.out.println("\tFAILED to throw exception for index of -1");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED - threw an exception for -1");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("Testing with index of 5, should throw an IllegalArgumentException");
		try {
			Clock clock = clockShop.getClock(5);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED - threw an exception for index of 5");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("Testing with index of 0, should return clock (12, 12, 12)");
		try {
			Clock clock = clockShop.getClock(0);
			System.out.println("\tPASSED with index 0 " + clock);
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tFAILED with index of 0 -- IllegalArgumentException somehow");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("Testing with index of 4, should return clock (11, 11, 10)");
		try {
			Clock clock = clockShop.getClock(4);
			System.out.println("\tPASSED - returned clock for index of 4" + clock);
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tFAILED for index of 4 -- IllegalArgumentException somehow");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testWriteClocksToFile() {
		System.out.println("CLOCKSHOP WRITECLOCKSTOFILE TESTS");

		System.out.println("Fill clock shop with 5 clocks, then write to file");
		ClockShop clockShop = new ClockShop();
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(11, 11, 11));
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(10, 10, 10));
		clockShop.addClock(new Clock(11, 11, 10));
		
		String fileName = "write_clocks_to_file_test.txt";
		clockShop.writeClocksToFile(fileName);
	
		System.out.println("Clocks written, now let's read the file contents");
		try {
			Scanner inputFile = new Scanner(new File(fileName));
			String result = "";
			while (inputFile.hasNextLine()) {
				result += inputFile.nextLine() + newline;
			}
			inputFile.close();
			String expected = "12:12:12" + newline
				+ "11:11:11" + newline
				+ "12:12:12" + newline
				+ "10:10:10" +newline
				+ "11:11:10" + newline;
			if (result.equals(expected)){
				System.out.println("\tPASSED write 5 clocks to file");
			}
			else{
				System.out.println("\tFAILED writing 5 clocks to file" + newline + result);
				System.out.println("\t expected was" + newline + expected);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Test failed - Unable to open/find: " + fileName);
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testFindClock() {

		System.out.println("CLOCKSHOP FINDCLOCK TESTS");

		ClockShop clockShop = new ClockShop();
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(11, 11, 11));
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(10, 10, 10));
		clockShop.addClock(new Clock(11, 11, 10));

		System.out.println("Here are the clocks in the clock shop after filling with 5 clocks:");
		System.out.println(clockShop.toString());
		
		System.out.println("Testing with clock not in clock shop (1, 1, 1)");
		int index = clockShop.findClock(new Clock(1, 1, 1));
		if (index == -1)
			System.out.println("\tPASSED on clock not in clock shop");
		else
			System.out.println("\tFAILED on clock not in clock shop, index other than -1 returned: "
				+ index);

		System.out.println("Testing with first clock in clock shop (12, 12, 12)");
		index = clockShop.findClock(new Clock(12, 12, 12));
		if (index == 0)
			System.out.println("\tPASSED on clock at start of clock shop");
		else
			System.out.println("\tFAILED on clock at start of clock shop: " + index);

		System.out.println("Testing with last clock in clock shop (11, 11, 10)");
		index = clockShop.findClock(new Clock(11, 11, 10));
		if (index == 4)
			System.out.println("\tPASSED on clock at end of clock shop");
		else
			System.out.println("\tFAILED on clock at end of clock shop: " + index);

		System.out.println("-------------------------------------------");
		
	}

	private static void testSetClock() {

		System.out.println("CLOCKSHOP SETCLOCK TESTS");

		ClockShop clockShop = new ClockShop();
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(11, 11, 11));
		clockShop.addClock(new Clock(12, 12, 12));
		clockShop.addClock(new Clock(10, 10, 10));
		clockShop.addClock(new Clock(11, 11, 10));

		System.out.println("Here are the clocks in the clock shop after filling with 5 clocks:");
		System.out.println(clockShop.toString());

		System.out.println("Testing negative index, IllegalArgumentException should occur");
		try {
			clockShop.setClock(new Clock(12, 12, 12), -1);
			System.out.println("\tFAILED negative index did not throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED with negative index");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("Testing index too large, IllegalArgumentException should occur");
		try {
			clockShop.setClock(new Clock(12, 12, 12), 5);
			System.out.println("\tFAILED too large of index did not throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED too large of an index - IllegalArgumentException thrown");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("Testing index 0, should replace clock at that location");
		try {
			clockShop.setClock(new Clock(10, 11, 12), 0);
			if (clockShop.getClock(0).toString().equals("10:11:12")){
				System.out.println("\tPASSED index 0: " + clockShop.getClock(0));
			}
			else{
				System.out.println("\tFAILED - clock at index 0 was: " + clockShop.getClock(0));
			}

		}
		catch(IllegalArgumentException e) {
			System.out.println("Test of index 0 failed -- IllegalArgumentException somehow");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("Testing index 4, should replace clock at that location");
		try {
			clockShop.setClock(new Clock(12, 11, 10), 4);
			if (clockShop.getClock(4).toString().equals("12:11:10")){
				System.out.println("\tPASSED index 4: " + clockShop.getClock(4));
			}
			else{
				System.out.println("\tFAILED - clock at index 4 was: " + clockShop.getClock(4));
			}

		}
		catch(IllegalArgumentException e) {
			System.out.println("Test of index 4 failed -- IllegalArgumentException somehow");
		}
		catch (Exception e){
			System.out.println("\tFAILED - unexpected exception occurred of type: " + e.getClass());
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testFillClockShop() {

		System.out.println("CLOCKSHOP FILLCLOCKSHOP TESTS");
		ClockShop clockShop = new ClockShop();

		System.out.println("\nTesting one clock file (15, 40, 0)");
		clockShop.fillClockShop("one_clock_file.txt");
		if (clockShop.toString().equals("15:40:00" + newline)
			|| clockShop.toString().equals("15:40:0" + newline)){
			System.out.println("\tPASSED single clock file");
		}
		else{
			System.out.println("\tFAILED single clock file");
		}

		
		System.out.println("\nTesting two clock file (17, 40, 0), (15, 40, 0)");
		clockShop = new ClockShop();
		clockShop.fillClockShop("two_clock_file.txt");
		if (clockShop.toString().equals("17:40:00" + newline
			+ "15:40:00" + newline)
			|| clockShop.toString().equals("17:40:0" + newline
			+ "15:40:0" + newline)){
			System.out.println("\tPASSED two clock file");
		}
		else{
			System.out.println("\tFAILED two clock file");
			System.out.println(clockShop.toString());
		}
		
		System.out.println("\nTesting with 5 clock file:");
		System.out.println("(23, 59, 59), (17, 50, 0), (19, 50, 0), (0, 0, 0), (9, 0, 0)");
		clockShop = new ClockShop();
		clockShop.fillClockShop("five_clock_file.txt");
		if (clockShop.toString().equals("23:59:59" + newline
			+ "17:50:00" + newline
			+ "19:50:00" + newline
			+ "00:00:00" + newline
			+ "9:00:00" + newline)
			|| clockShop.toString().equals("23:59:59" + newline
			+ "17:50:0" + newline
			+ "19:50:0" + newline
			+ "0:0:0" + newline
			+ "9:0:0" + newline)) {
			System.out.println("\tPASSED five clock file");
		}
		else{
			System.out.println("\tFAILED five clock file");
			System.out.println(clockShop.toString());
		}

		System.out.println("-------------------------------------------");
	}

}
