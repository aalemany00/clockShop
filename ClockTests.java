/**
 * Use this class to test your Clock class.
 *
 * NOTE: The code for this class will not compile until you implement the Clock class
 *
 * You do not need to document this class.
 * 
 * @author tomUW
 *
 */
public class ClockTests {

	public static void main(String[] args) {
		System.out.println("---CLOCK TESTS---");
		testDefaultConstructor();
		testToString();
		testExplicitValueConstructor();
		testSetHour();
		testSetMinute();
		testSetSecond();
		testAdvanceHour();
		testAdvanceMinute();
		testEquals();
		testCompareTo();
		//The below method call is if you do the extra credit
		// uncomment as necessary :-)
		//testSetToCurrentTime();
		System.out.println("---END CLOCK TESTS---");

	}

// Uncomment and write the necessary code to test your setToCurrentTime method
//  if you perform the extra credit

//	private static void testSetToCurrentTime() {
//
//	}

	private static void testCompareTo() {
		Clock clock1 = new Clock(0, 0, 0);
		Clock clock2 = new Clock(0, 0, 0);
		Clock clock3 = new Clock(0, 0, 5);
		Clock clock4 = new Clock(0, 10, 0);
		Clock clock5 = new Clock(3, 0, 0);

		System.out.println("CLOCK COMPARETO TESTS");
		System.out.println("Testing two different Clock objects that are the same for equality");
		if (clock1.compareTo(clock2) == 0)
			System.out.println("\tPASSED two equal clocks");
		else
			System.out.println("\tFAILED two equal clocks");

		System.out.println("Testing first clock less than third clock (seconds) ");
		if (clock1.compareTo(clock3) < 0)
			System.out.println("\tPASSED first clock less than");
		else
			System.out.println("\tFAILED first clock less than");

		System.out.println("Testing first clock less than fourth clock (minutes)");
		if (clock1.compareTo(clock4) < 0)
			System.out.println("\tPASSED first clock less");
		else
			System.out.println("\tFAILED first clock less");

		System.out.println("Testing first clock less than fifth clock (hours)");
		if (clock1.compareTo(clock5) < 0)
			System.out.println("\tPASSED first clock less");
		else
			System.out.println("\tFAILED first clock less");

		System.out.println("Testing third clock greater than first clock (seconds)");
		if (clock3.compareTo(clock1) > 0)
			System.out.println("\tPASSED third clock greater");
		else
			System.out.println("\tFAILED third clock greater");

		System.out.println("Testing fourth clock greater than first clock (minutes)");
		if (clock4.compareTo(clock1) > 0)
			System.out.println("\tPASSED fourth clock greater");
		else
			System.out.println("\tFAILED fourth clock greater");

		System.out.println("Testing fifth clock greater than first clock (hours)");
		if (clock5.compareTo(clock1) > 0)
			System.out.println("\tPASSED fifth clock greater");
		else
			System.out.println("\tFAILED fifth clock greater");

		System.out.println("-------------------------------------------");
		
	}

	private static void testEquals() {
		Clock clock1 = new Clock(0, 0, 0);
		Clock clock2 = new Clock(0, 0, 0);
		Clock clock3 = new Clock(0, 0, 11);
		Clock clock4 = new Clock(0, 41, 0);
		Clock clock5 = new Clock(11, 0, 0);

		System.out.println("CLOCK EQUALS TESTS");

		System.out.println("Testing two clocks equal");
		if (clock1.equals(clock2))
			System.out.println("\tPASSED two equal clocks");
		else
			System.out.println("\tFAILED two equal clocks");

		System.out.println("Testing two clocks not equal -- clock 3 11 seconds different");
		if (clock1.equals(clock3))
			System.out.println("\tFAILED third clock 11 seconds different");
		else
			System.out.println("\tPASSED third clock 11 seconds different");

		System.out.println("Testing two clocks not equal -- clock 4 41 minutes different");
		if (clock1.equals(clock4))
			System.out.println("\tFAILED fourth clock 41 minutes different");
		else
			System.out.println("\tPASSED fourth clock 41 minutes different");

		System.out.println("Testing two clocks not equal -- clock 5 11 hours different");
		if (clock1.equals(clock5))
			System.out.println("\tFAILED fifth clock 11 hours different");
		else
			System.out.println("\tPASSED fifth clock 11 hours different");

		System.out.println("-------------------------------------------");
	}

	private static void testAdvanceMinute() {

		System.out.println("CLOCK ADVANCEMINUTE TESTS");

		Clock clock = new Clock(0, 0, 0);

		System.out.println("Testing with negative value, should throw an exception");
		try {
			clock.advanceMinute(-1);
			System.out.println("\tFAILED to throw IllegalArgumentException for -1");
		}
		catch (IllegalArgumentException e){
			System.out.println("\tPASSED throwing an IllegalArgumentException for -1");
		}

		System.out.println("Testing with value of zero, minute should be the same");
		clock.advanceMinute(0);
		if (clock.getMinute() == 0) {
			System.out.println("\tPASSED for value of 0");
		}
		else {
			System.out.println("\tFAILED for value of 0: " + clock.getMinute());
		}

		System.out.println("Testing with value of 59 when minute is 0");
		clock.advanceMinute(59);
		if (clock.getMinute() == 59) {
			System.out.println("\tPASSED for 59");
		}
		else {
			System.out.println("\tFAILED for 59: " + clock.getMinute());
		}

		System.out.println("Testing with value of 60, minute should be the same, hour should be +1");
		clock.setMinute(0);
		clock.advanceMinute(60);
		if (clock.getHour() == 1 && clock.getMinute() == 0) {
			System.out.println("\tPASSED for 60 -- hour advanced by 1");
		}
		else {
			System.out.println("\tFAILED for 60: " + clock.getHour() + ", "+ clock.getMinute());
		}

		System.out.println("Testing with value of 1440, minute and hour should be the same");
		clock.setMinute(0);
		clock.setHour(0);
		clock.advanceMinute(1440);
		if (clock.getHour() == 0 && clock.getMinute() == 0) {
			System.out.println("\tPASSED for 1440");
		}
		else {
			System.out.println("\tFAILED for 1440: " + clock.getHour() + ", "+ clock.getMinute());
		}

		System.out.println("Testing with value of 1501, minute and hour should be 1");
		clock.setMinute(0);
		clock.setHour(0);
		clock.advanceMinute(1501);
		if (clock.getHour() == 1 && clock.getMinute() == 1) {
			System.out.println("\tPASSED for 1501");
		}
		else {
			System.out.println("\tFAILED for 1501: " + clock.getHour() + ", "+ clock.getMinute());
		}

		System.out.println("-------------------------------------------");
	}

	private static void testAdvanceHour() {

		System.out.println("CLOCK ADVANCEHOUR TESTS");

		System.out.println("Testing with -1, should throw an IllegalArgumentException");
		Clock clock = new Clock(0, 0, 0);
		try {
			clock.advanceHour(-1);
			System.out.println("\tFAILED to throw IllegalArgumentException for -1");
		}
		catch (IllegalArgumentException e){
			System.out.println("\tPASSED threw IllegalArgumentException for -1");
		}

		System.out.println("Testing with 0, hour should remain the same");
		clock.advanceHour(0);
		if (clock.getHour() == 0) {
			System.out.println("\tPASSED for 0");
		}
		else {
			System.out.println("\tFAILED for 0: " + clock.getHour());
		}

		System.out.println("Testing with 72, hour should remain the same");
		clock.advanceHour(72);
		if (clock.getHour() == 0) {
			System.out.println("\tPASSED for 72");
		}
		else {
			System.out.println("\tFAILED for 72: " + clock.getHour());
		}

		System.out.println("Testing with 73, hour should advance by 1");
		clock.advanceHour(73);
		if (clock.getHour() == 1) {
			System.out.println("\tPASSED for 73");
		}
		else {
			System.out.println("\tFAILED for 73: " + clock.getHour());
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testSetSecond() {

		System.out.println("CLOCK SETSECOND TESTS");

		System.out.println("Testing with 59, second should be set to 59");
		Clock clock = new Clock(0, 0, 12);
		clock.setSecond(59);
		if (clock.getSecond() == 59) {
			System.out.println("\tPASSED setting to 59: " + clock.getSecond());
		}
		else {
			System.out.println("\tFAILED setting to 59: " + clock.getSecond());
		}

		System.out.println("Testing with -1, should throw IllegalArgumentException");
		try {
			clock.setSecond(-1);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED: threw an IllegalArgumentException");
		}

		System.out.println("Testing with 60, should throw IllegalArgumentException");
		try {
			clock.setSecond(60);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED - threw an IllegalArgumentException");
		}
		
		System.out.println("-------------------------------------------");
	}

	private static void testSetMinute() {

		System.out.println("CLOCK SETMINUTE TESTS");
		Clock clock = new Clock(0, 55, 0);

		System.out.println("Testing with minute of 0");
		clock.setMinute(0);
		if (clock.getMinute() == 0) {
			System.out.println("\tPASSED setting minute to 0: " + clock.getMinute());
		}
		else {
			System.out.println("\tFAILED setting minute to 0: " + clock.getMinute());
		}

		System.out.println("Testing with -1, should throw IllegalArgumentException");
		try {
			clock.setMinute(-1);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED - threw an IllegalArgumentException");
		}

		System.out.println("Testing with 60, should throw IllegalArgumentException");
		try {
			clock.setMinute(60);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED -  threw an IllegalArgumentException");
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testSetHour() {

		System.out.println("CLOCK SETHOUR TESTS");

		System.out.println("Testing with hour of 0");
		Clock clock = new Clock(9, 0, 0);
		clock.setHour(0);
		if (clock.getHour() == 0) {
			System.out.println("\tPASSED setting hour to 0 " + clock.getHour());
		}
		else {
			System.out.println("\tFAILED setting hour to 0" + clock.getHour());
		}

		System.out.println("Testing with -1, should throw IllegalArgumentException");
		try {
			clock.setHour(-1);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED - threw an IllegalArgumentException");
		}

		System.out.println("Testing with 24, should throw IllegalArgumentException");
		try {
			clock.setHour(24);
			System.out.println("\tFAILED to throw IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\tPASSED - threw an IllegalArgumentException");
		}

		System.out.println("-------------------------------------------");
	}

	private static void testExplicitValueConstructor() {

		System.out.println("CLOCK EXPLICITVALUECONSTRUCTOR TESTS");

		System.out.println("Testing constructing clock with 12 hours, 13, mins, 14 secs");
		Clock clock = new Clock(12, 13, 14);
		if (clock.getHour() == 12 && clock.getMinute() == 13 && clock.getSecond() == 14) {
			System.out.println("\tPASSED setting to 12, 13, 14 " + clock);
		}
		else {
			System.out.println("\tFAILED setting to 112, 13, 14: " + clock);
		}

		System.out.println("Testing with invalid minute, should throw IllegalArgumentException");
		try{
			clock = new Clock(12, 12, 61);
			System.out.println("\tFAILED - did not throw an IllegalArgumentException");
		}
		catch (IllegalArgumentException e){
			System.out.println("\tPASSED - threw an IllegalArgumentException");
		}

		System.out.println("-------------------------------------------");
	}

	private static void testDefaultConstructor() {

		System.out.println("CLOCK DEFAULTCONSTRUCTOR TESTS");

		System.out.println("Testing with no parameters - should default to 23, 58, 0");
		Clock clock = new Clock();
		if (clock.getHour() == 23 && clock.getMinute() == 58 && clock.getSecond() == 0) {
			System.out.println("\tPASSED - default of 2 minutes to midnight: " + clock);
		}
		else {
			System.out.println("\tFAILED - default of 2 minutes to midnight: " + clock);
		}

		System.out.println("-------------------------------------------");
		
	}

	private static void testToString(){
		System.out.println("CLOCK TOSTRING TESTS");

		Clock clock = new Clock(0, 0, 0);
		System.out.println("Testing toString with 0, 0, 0 for hours, minutes and seconds");
		String result = clock.toString();
		if (result.equals("0:0:0") || result.equals("00:00:00")){
			System.out.println("\tPASSED for 0, 0, 0: " + clock.toString());
		}
		else{
			System.out.println("\tFAILED for 0, 0, 0: " + clock.toString());
		}

		System.out.println("-------------------------------------------");
	}

}
