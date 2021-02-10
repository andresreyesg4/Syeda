/**
 * The Plate class holds an int, for later to be turned into an ASCII value.
 * Each plate can only hold one integer.
 */
// --------------------------------------------------------
// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
// --------------------------------------------------------
public class Plate {
	/**
	 * Holds an integer.
	 */
	private int number;

	/**
	 * Constructor that sets the number to a given number.
	 * @param number holds the number to be added to the private instance of number.
	 */
	public Plate(int number) {
		this.number = number;
	}

	/**
	 * Overrides the super toString method to best fit the class.
	 * @return a plate of the string form.
	 */
	public String toString() {
		return "("+((char)(this.number+96))+")";
	}

	/**
	 * Gets the value of the private integer number.
	 * @return the value of number.
	 */
	public int getNumber() {
		return this.number;
	}
}
