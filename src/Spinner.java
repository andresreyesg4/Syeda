import java.util.NoSuchElementException;

/**
 * Spinner class handles all the actions of which the simulate class will be accomplishing.
 * It creates a bin, an air, and two hands.
 * Which the class for hands is encapsulated.
 * when a new spinner is created, there is a for loop that fills in the spinner with N number of plates.
 * Each plate has an ASCII value.
 */
public class Spinner {
	//you may NOT add any additional instance variables or methods
	//to the Spinner, all needed instance variables are created in
	//the DO NOT EDIT section

	/**
	 * The hand class handles all the actions done by the hand which include.
	 * catching a plate, and tossing a plate.
	 * Along with other checking methods.
	 */
	private static class Hand {
		//add any additional instance variables here
		//no additional methods (not even private ones)

		/**
		 * Plate holds the plate for the instance of a hand.
		 * Used for tossing, or catching, or checking if hand is empty.
		 */
		private Plate plate = null;

		/**
		 * CatchPlate, receives a Plate instance in which it is important to check if the plate is null.
		 * If it is null a NoSuchElementException() is thrown, also if the the plate holder is != null.
		 * then we throw a RuntimeException() because the hand cannot catch if there is an element already there.
		 * @param plate holds the plate value to be caught by the hand.
		 */
		public void catchPlate(Plate plate) {
			//if trying to catch a plate when full, throw a RuntimeException
			//with the message "Catching hand not empty"
			
			//if trying to catch a null plate, throw a RuntimeException
			//with the message "Can't catch a plate that doesn't exist!"
			
			//otherwise keep the plate in this hand

			if(this.plate != null){
				throw new RuntimeException("Catching hand not empty");
			}else{
				if(plate != null) {
					this.plate = plate;
				}else{
					throw new RuntimeException("Can't catch a plate that doesn't exist!");
				}
			}
		}

		/**
		 * toss plate simply takes the current value of the plate holder.
		 * checks if its null, it not return it and set it null.
		 * that way when coming back in, the hand will be empty.
		 * @return the value of hand if not null.
		 */
		public Plate tossPlate() {
			//if trying to throw a plate when this hand does not have
			//a plate, throw a RuntimeException with the message
			//"Tossing hand was empty"
			
			//otherwise remove the plate from this hand
			//and return the plate you removed
			Plate temp;
			if(this.plate != null){
				temp = plate;
				plate = null;
			}else{
				throw new RuntimeException("Tossing hand was empty");
			}
			return temp;
		}

		/**
		 * hasPlate is a method call to check if the hand currently contains a platte instance.
		 * returns true if the hand contains a plate.
		 *
		 * @return whether the hand is empty or not.
		 */
		public boolean hasPlate() {
			//return true if you have a plate, false otherwise
			boolean handFull = false;
			if(plate != null){
				handFull = true;
			}
			return handFull;
		}


		/**
		 * Overrides the toString() method from object.java to return he string value of the plate.
		 * @return string value of the plate, if the hand is empty return "   ".
		 */
		public String toString() {
			//if this hand is empty, return the string "   " (three spaces)
			//otherwise return the plate's string value
			if(hasPlate()){
				return plate.toString();
			}else{
				return "   ";
			}
		}
	}

	/**
	 * pass plate does the task of passing the plate from hand 2 to hand 1.
	 * all the exceptions are checked by the hand class.
	 */
	public void passPlate() {
		//put a plate from hand 2 and pass it to hand 1
		//this can be done with a single line of code
		//hands[0] = hands[1].tossPlate();
		hands[0].catchPlate(hands[1].tossPlate());
	}

	/**
	 * Put down the plate handles the task of putting down the plate that hand1 currently has.
	 * if the hand is empty then everything drops.
	 */
	public void putDownPlate() {
		//put a plate from hand 1 and put it in the bin
		//this can be done with a single line of code
		bin.push(hands[0].tossPlate());
	}

	/**
	 * pickUpPlate method simply picks up a plate from the (stack) bin.
	 * adds it to hand 1.
	 */
	public void pickUpPlate() {
		//take a plate out of the bin and put it in hand 1
		
		//if there are no plates in the bin, throw a RuntimeException
		//with the message "Can't pickup a plate that doesn't exist!"
		if(bin.isEmpty()){
			throw new RuntimeException("Can't pickup a plate that doesn't exist!");
		}else {
			hands[0].catchPlate(bin.pop());
		}
	}

	/**
	 * Spin plate takes the plate from hand 1 and spins it to the air.
	 * the air has a limit to which it should not pass.
	 */
	public void spinPlate() {
		//take a plate from hand 1 and put it in the air
		
		//if the air can't hold anymore plates, throw a RuntimeException
		//with the message "Too many plates in the air!"
		if(air.size() == 13){
			throw new RuntimeException("Too many plates in the air!");
		}else {
			air.enqueue(hands[0].tossPlate());
		}
	}

	/**
	 * Catch plate method takes a plate out from the air and catches it in hand2.
	 * if the air is empty there is no plate to catch.
	 */
	public void catchPlate() {
		//take a plate out of the air and put it in hand 2
		
		//if there are no plates in the air, throw a RuntimeException
		//with the message "Can't catch a plate that doesn't exist!"

		if(air.isEmpty()){
			throw new RuntimeException("Can't catch a plate that doesn't exist!");
		}else{
			hands[1].catchPlate(air.dequeue());
		}
	}

	/**
	 * Main method used for testing hand class and spinner as well.
	 * @param args command line arguments
	 */
	// --------------------------------------------------------
	// testing code goes here... edit this as much as you want!
	// --------------------------------------------------------
	public static void main(String[] args) {
		Hand hand1 = new Hand();
		hand1.catchPlate(new Plate(2));
		System.out.println(hand1.toString());
		System.out.println(hand1.tossPlate());

		Spinner spins = new Spinner(5);
		System.out.println(spins.toString());
		spins.pickUpPlate(); //picks up a
		spins.spinPlate();
		spins.pickUpPlate(); //picks up b
		spins.spinPlate();
		spins.pickUpPlate(); //picks up c
		spins.spinPlate();
		spins.pickUpPlate(); //picks up d
		spins.spinPlate();
		spins.pickUpPlate(); //picks up e
		System.out.println(spins.toString());
		spins.putDownPlate(); //puts down e.
		System.out.println(spins.toString());

	}
	
	// --------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
	// --------------------------------------------------------

	/**
	 * air holds the queue which will be holding up to 13 plates in the air.
	 */
	private final Air air = new Air();
	/**
	 * bin will act as a stack and will hold all the plates created by the simulte class.
	 */
	private final Bin bin = new Bin();
	/**
	 * the array of hands will hold hand 1 and 2 respectively to their index 0, 1.
	 */
	private final Hand[] hands = new Hand[2];

	/**
	 * Spinner constructor initializes the Hand[] to a new Hand() at each index.
	 * Conceptually, hands[0] = hand 1 and hands[1] = hand 2.
	 * The constructor also receives a input parameter which holds the number of plates.
	 * With that parameter it will use a for loop to add N number of plates to the bin instance.
	 * Once this constructor finalizes, the bin will hold N number of plates.
	 * And the hands[i] will be empty.
	 * @param totalPlates holds the total number of plates to start with.
	 */
	//spinners have two hands and starts with a bin full of plates
	public Spinner(int totalPlates) {
		hands[0] = new Hand();
		hands[1] = new Hand();
		
		for(int i = totalPlates; i > 0; i--) {
			this.bin.push(new Plate(i));
		}
	}

	/**
	 * This toString() method for the spinner, is the method that does all the ASCII art.
	 * Using the instances of bin, air, and hands[] it will generate the game functions.
	 * @return The string which in this case is Syeda and her plate trick.
	 */
	//this does the beautiful ascii art :)
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		String[] personParts = {
			"   "+air.toString()+"\n",
			"\n",
			"    "+hands[0].toString()+"( )"+hands[1].toString()+"\n",
			"     \\__|__/\n",
			"        |\n",
			"        |\n",
			"       / \\\n",
			"      /   \\\n"
		};
		
		String[] stackParts = this.bin.toString().split("[|]");
		
		int total = (this.bin.size() < personParts.length) ? personParts.length : this.bin.size();
		for(int i = total; i >= 0; i--) {
			sb.append((this.bin.size()-1 < i) ? "   " : stackParts[stackParts.length-i-1]);
			if(i < personParts.length) {
				sb.append(personParts[personParts.length-i-1]);
			}
			else {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
}
