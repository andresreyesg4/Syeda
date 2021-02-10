import javax.swing.table.AbstractTableModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * AttachedList class implements the List interface.
 * build to work with generic values.
 * overrides most of the list interface method's.
 * Also overrides the hasNext() and next() from Iterator class.
 * @param <T> holds the generic value for the list.
 */
public class AttachedList<T> implements List<T> {
	//for more information on these methods
	//read the documentation of the list interface
	//here: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
	//keep in mind that we are doing a _linked_ list
	//but the documentation is for general lists (like array lists)

	//NOTE: the documentation above is not optional, it tells you things
	//like what exceptions to throw

	/**
	 * The Node class is used to connect one piece of generic data  to another.
	 * It holds a field for a link to the next node.
	 * Also a field for the data, which is generic.
	 * @param <T> generic value for the node.
	 */
	private static class Node<T> {
		//you may NOT change these instance variables and/or
		//add any additional instance variables here
		//(so you may not doubly link your list)

		/**
		 * Generic value of data.
		 */
		T value;


		/**
		 * Link to the next node.
		 */
		Node<T> next;

		//you may add more methods here... and they may be public!
		//note: a constructor _is_ a method (just a special type of method)
		//note: you don't have to add anything if you don't want
		//      this will work as-is

		/**
		 * Default constructor that sets both value and next to null.
		 */
		public Node(){
			this.value = null;
			this.next = null;
		}

		/**
		 * Constructor with a T value parameter, sets the Nodes value to the input value.
		 * Also sets the next link to null.
		 * @param value the data too be saved in new node.
		 */
		public Node(T value){
			this.value = value;
			this.next = null;
		}

	}


	/**
	 * Points to the beginning of the list.
	 * Could be used to start traversing through the list.
	 */
	private Node<T> head = null;
	//You _MUST_ use head defined above, we will be "breaking into"
	//your class for testing and we'll be using this "head" variable
	//as part of the tests. If you rename or change it, you will
	//not pass the unit tests.

	//Note: if you're interested on what "breaking in" means, it means
	//we'll be using reflection to access your private instance variables.
	//Interested? See: https://docs.oracle.com/javase/tutorial/reflect/index.html


	//you may add more private methods and instance variables here if you want
	//you may add additional private helper functions as well
	//no new protected or public variables or methods

	/**
	 * Keeps track of the end of the list in order to insert with O(1) time complexity.
	 */
	private Node<T> tail;


	/**
	 * keeps track of the number of elements there are in the list.
	 * Increments and decrements when necessary.
	 */
	private int size;

	/**
	 * Default constructor, where all private variables not initialized become initialized.
	 */
	public AttachedList() {
		//initialize anything you want here...
		//this.tail = head;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * This method returns the size of the current list.
	 *
	 * @return number of elements in the list.
	 */
	@Override
	public int size() {
		//O(1)
		return size;
	}

	/**
	 * This method checks if the list is empty or not.
	 *
	 * @return false if its not empty, otherwise true.
	 */
	@Override
	public boolean isEmpty() {
		//O(1)
		boolean empty = false;
		if(size == 0 || head == null){
			empty = true;
		}
		return empty;
	}

	/**
	 * This method goes through the list in search of the object.
	 * It will return the first occurence of the object in the list.
	 *
	 * @param o object to search for.
	 * @return the index of the object, or -1 if not found.
	 */
	@Override
	public int indexOf(Object o) {
		//O(n).
		//yes, nulls are allowed to be searched for.
		int indexFound = -1;
		int counter = 0;
		boolean found = false;
		Node<T> temp = head;
		//traverse through the linked list.
		while(counter < size && !found){
			if(temp.value.equals(o)){
				indexFound = counter;
				found = true;
			}
			counter++;
			temp = temp.next;
		}
		return indexFound;
	}

	/**
	 * Contains method returns true or false if the list contains the object.
	 *
	 * @param o the object to search for.
	 * @return true if the object is in the list, false otherwise.
	 */
	@Override
	public boolean contains(Object o) {
		//O(n)
		//yes, nulls are allowed to be searched for
		boolean exists = false;
		int index = indexOf(o);
		if(index != -1){
			exists = true;
		}

		return exists;
	}

	/**
	 * This method simply adds the element at the end of the list.
	 * If the list is empty it will become the first item in the list.
	 *
	 * @param e Holds the element to add.
	 * @return true if add was successful.
	 */
	@Override
	public boolean add(T e) {
		//this should append to the end of the list
		//O(1) <-- not a typo... think about it!
		//yes, nulls are allowed to be added

		Node<T> temp = new Node<>(e);
		if(head == null){
			head = temp;
			tail = head;
			size++;
		}else{
			tail.next = temp;
			tail = tail.next;
			size++;
		}

		return true;
	}

	/**
	 * this add method adds an element to the list at a specific index.
	 * Null's are allowed to be added.
	 *
	 * @param index holds the spot for element to be added.
	 * @param element hold the element to add.
	 */
	@Override
	public void add(int index, T element) {
		//O(n)
		//yes, nulls are allowed to be added
		int counter = 1;

		Node<T> temp = new Node<>(element);

		if(index > size || index < 0){
			throw new IndexOutOfBoundsException();

		}else {
			// if the index is valid.
			if (index == 1 && head.next == null) {
				add(element);

			} else if (index == size) {
				add(element);

			} else if (index == 0) {
				temp.next = head;
				head = temp;
				size++;

			} else {
				//it is necessary to have the node before the one that needs to be removed.
				//previous holds starts at the head. And nextNode starts at head.next.

				Node<T> nextNode = head.next;
				Node<T> previousNode = head;
				while (counter < index) {
					counter++;
					nextNode = nextNode.next;
					previousNode = previousNode.next;
				}
				temp.next = nextNode;
				previousNode.next = temp;
				size++;
			}
		}
	}

	/**
	 * Remove method receives an index which is the place to remove.
	 * Internally traverses through the nodes until it reaches one before.
	 * Saves the data before deleting, once data is saved it deletes.
	 * Returns the data that was removed.
	 *
	 * @param index holds the place to remove.
	 * @return the value of the node that is removed.
	 */
	@Override
	public T remove(int index) {
		//O(n)
		int counter = 0;
		T removedItem;

		if(index >= size || index <0){
			throw new IndexOutOfBoundsException();
		}else{
			if(isEmpty()){
				throw new NullPointerException();
			}else if(index == 0 && size > 1){
				//handles the special case when the index is at 0.
				//Prevents from going into the while loop.
				removedItem = head.value;
				head = head.next;
				size--;
			}else if(index == 0 && size == 1) {
				//handles the special case when the index is at 0.
				//but the list only contains one item.
				removedItem = head.value;
				clear();
			}else{
				//loop until the temp is one node before the one to remove.
				Node<T> temp = head;
				while(counter < index -1){
					//index - 1 will ensure the node is one before the index to be deleted.
					counter++;
					temp = temp.next;
				}
				if(index != size-1) {
					removedItem = temp.next.value;
					temp.next = temp.next.next;
					size--;
				}else{
					removedItem = tail.value;
					tail = temp;
					tail.next = null;
					size--;
				}
			}
		}
		return removedItem;
	}

	/**
	 * This method removes a specified object from the list.
	 * Nulls are allowed to be removed.
	 *
	 * @param o holds the object to be removed.
	 * @return false if there was an error, true otherwise.
	 */
	@Override
	public boolean remove(Object o) {
		//O(n)
		//yes, nulls are allowed to removed
		boolean removed;
		if(!(contains(o))){
			removed = false;
		}else{
			size--;
			removed = true;
			if(!(head.value.equals(o))) {
				Node<T> temp = head;
				//loop runs until the next node has the object to be removed.
				while (!(temp.next.value.equals(o))) {
					temp = temp.next;
				}
				if (!(temp.next.equals(tail))) {
					temp.next = temp.next.next;
				} else {
					tail = temp;
					tail.next = null;
				}
			}else {
				if(head.next != null){
					head = head.next;
				}else{
					clear();
				}
			}
		}
		return removed;
	}

	/**
	 * This method clears out the list by setting the head to null.
	 * Looses the connection to all the other items in the list if any.
	 * Garbage collector handles the data is not being referenced.
	 */
	@Override
	public void clear() {
		//O(1) <-- not a typo... think about it!
		head = null;
		size = 0;
	}

	/**
	 * This get method can be used to get the value of a specific spot in a lit.
	 * The method goes through the list until a counter is equal to the index given.
	 * Once the correct index is reached, the value is saved for a return.
	 *
	 * @param index Hold the place to return the data.
	 * @return the data at the index given.
	 */
	@Override
	public T get(int index) {
		//O(n)
		T data;
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}else{
			int counter = 0;
			Node<T> temp = head;
			while(!(counter == index)){
				temp = temp.next;
				counter++;
			}
			data = temp.value;
		}
		return data;
	}

	/**
	 * This method is used to replace an item with the element given.
	 * The item is reached by the given index.
	 * The method loops until it reaches the place in the list and replaces the item.
	 *
	 * @param index Holds the index of the item to replace
	 * @param element Holds the new element that replaces the old element.
	 * @return returns the data that was replaced.
	 */
	@Override
	public T set(int index, T element) {
		//O(n)
		int counter = 0;
		T data;
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}else{
			Node<T> temp = head;
			while(!(counter == index)){
				temp = temp.next;
				counter++;
			}
			data = temp.value;
			temp.value = element;
		}

		return data;
	}

	/**
	 * This method cuts a piece of the list just like cutting a piece of a cake.
	 * It requires a starting index and a stopping index.
	 * Once the slice is added to a new attached list it will return that list.
	 *
	 * @param fromIndex holds the starting point.
	 * @param toIndex holds the ending point
	 * @return the attached list with the elements sliced.
	 */
	public AttachedList<T> slice(int fromIndex, int toIndex) {
		//removes a "slice" from fromIndex to toIndex (inclusive)
		//return the slice as a new AttachedList
		//throws IndexOutOfBoundsException if fromIndex _or_ toIndex is invalid
		//O(n)
		AttachedList<T> piece = new AttachedList<>(); // will be used to save the items when slicing.
		AttachedList<T> tempList = new AttachedList<>();
		if((fromIndex > toIndex) || (fromIndex >= size) || (toIndex >= size) || (fromIndex < 0) ||(toIndex < 0)){
			throw new IndexOutOfBoundsException();
		}else{
			Node<T> temp = head;
			int start = fromIndex;
			int finish = toIndex;
			//add all the current elements in the tempList before removing the slice.
			while (temp != null){
				tempList.add(temp.value);
				temp = temp.next;
			}
			//remove the indexed elements from templist and add them to the list to be returned.
			while(start <= finish){
				piece.add(tempList.remove(fromIndex));
				start++;
			}
		}
		//Instead of using a remove method, simply set the head to piece's head.
		//also set the tail to piece's tail.
		//the garbage collector will handle the rest.
		head = tempList.head;
		tail = tempList.tail;

		return piece;
	}

	/**
	 * This method simply returns an AttachedList with all the elemnts in reverse order.
	 * It will not change the original List.
	 *
	 * @return the list with the items reversed.
	 */
	public AttachedList<T> reverseCopy() {
		//returns a copy of the list with the elements reversed
		//does not alter the original list
		//O(n)
		AttachedList<T> reverse = new AttachedList<>();	//used to save the items reversed.
		Node<T> temp = head;
		while(temp != null){
			reverse.add(0, temp.value);	//when the item is added to the index 0. It will end up being reverse.
			//Example: a list with [123] starting from index 0.
			//adding to index 0 would result: [1] ->[21] ->[321]
			temp = temp.next;
		}
		return reverse;
	}

	/**
	 * This method will take a 2D list lists and convert it into an AttachedList.
	 * The 2D List of Lists will be treated with a row and column concept.
	 * 		     [column 1] [column 2] [column3]
	 * [row 1] -> [   1,		2, 		  3]
	 * [row 2] -> [   4,        5]
	 * [row 3] -> [   6]
	 * Adding ever element to a new 1D AttachedList to be returned.
	 * @param packedList holds the 2D list of lists.
	 * @param <E> generic parameter.
	 * @return 1D AttachedList.
	 */
	public static <E> AttachedList<E> flatten(AttachedList<AttachedList<E>> packedList) {
		//given a 2D list of lists (packedList), "flatten" the list into 1D
		//Example 1: [[1,2,3],[4,5],[6]] becomes [1,2,3,4,5,6]
		//Example 2: [[null],[1,3],[5],[6]] becomes [null,1,3,5,6]
		//IMPORTANT: the above examples are _lists NOT arrays_
		AttachedList<E> flat = new AttachedList<>();

		int row = 0;
		int column = 0;
		// while the 2D list of lists contains a list.
		while(row < packedList.size()){
			AttachedList<E> temp = packedList.get(row); //get one list at a time, starting from 0.
			//while the temp list has elements.
			while(column < packedList.get(row).size()){
				flat.add(temp.get(column));
				column++;
			}
			column = 0;
			row++;
		}
		return flat;
	}

	/**
	 * Given a 1D AttachedList will become a 2D AttachedList.
	 * With each AttachedList having only repeated elements.
	 * @param flatList holds the 1D AttachedList.
	 * @param <E> Generic value of AttachedList.
	 * @return a 2D AttachedList.
	 */
	public static <E> AttachedList<AttachedList<E>> pack(AttachedList<E> flatList) {
		//given a 1D (flatList), "pack" sequential items together
		//to form a 2D list of values

		//Example 1: [1,1,2,3,3] becomes [[1,1],[2],[3,3]]
		//Example 1: [1,1,2,1,1,2,2,2,2] becomes [[1,1],[2],[1,1],[2,2,2,2]]
		//Example 3: [1,2,3,4,5] becomes [[1],[2],[3],[4],[5]]
		//IMPORTANT: the above examples are _lists NOT arrays_

		//promise: we will never test this with nulls in the flatList
		//though there's no harm in coding it to work with nulls

		AttachedList<AttachedList<E>> packed = new AttachedList<>(); //holds the 2D array for return.
		AttachedList<E> tempRepeats = new AttachedList<>(); //used for holding the repeated items only.
		Node<E> temp = flatList.head;
		int index = 0;

		while (index < flatList.size()) {
			if(temp.next != null) {
				if (temp.value.equals(temp.next.value)) {
					tempRepeats.add(temp.value);
				} else {
					tempRepeats.add(temp.value); //add the item before moving to the next item that does not repeat.
					packed.add(tempRepeats);
					tempRepeats = new AttachedList<>();
				}
			}else{
				tempRepeats.add(temp.value);
				packed.add(tempRepeats);
			}
			temp = temp.next;
			index++;
		}

		return packed;
	}

	/**
	 * This iterator method is used to iterate through a list.
	 * It is used to have access to next or has next in O(n) time.
	 *
	 * @return the iterator with the correct generic type.
	 */
	@Override
	public Iterator<T> iterator() {
		//this method is outlined for you... just fill out next() and hasNext()
		//NO ADDITIONAL ANYTHING (METHODS, VARIABLES, ETC.) INSIDE THE ANONYMOUS CLASS
		//You may NOT override remove() or any other iterator methods
		return new Iterator<T>() {
			//starts at the head
			/**
			 * current is used as a dummy head.
			 */
			private Node<T> current = head;
			private Node<T> nextN;
			private int counter = 0;

			/**
			 * This method checks if there is a next item.
			 * It does so by simply checking if the current node is not null.
			 * The reason being is when the method next() is called, the current node will point to the next node until the end.
			 * it will return false if the current node is false.
			 * @return true if next exists, false otherwise.
			 */
			@Override
			public boolean hasNext() {
				//O(1)
				boolean next = false;
				if(current != null){
					next = true;
				}else{
					next = false;
				}
				return next;
			}

			/**
			 * This method simply returns the next item.
			 * It is important to understand that the iterator only stands between two nodes or indexes.
			 *
			 * @return the item next in the list.
			 */
			@Override
			public T next() {
				//O(1)
				T temp;
				if (current == null) {
					throw new NoSuchElementException();
				} else {
					//counter++;
					temp = current.value;
					current = current.next;
				}
				//System.out.println(counter);
				return temp;
			}
		};
	}

	/**
	 * Uses a string builder to save all the elements in the list.
	 * That string builder then is returned.
	 *
	 * @return the elements in string form.
	 */
	// --------------------------------------------------------
	// testing code goes here... edit this as much as you want!
	// --------------------------------------------------------
	public String toString() {
		//you may edit this to make string representations of your.
		//list for testing.
		Node<T> temp = head;
		StringBuilder print = new StringBuilder();
		while(temp != null){
			print.append(temp.value +" ");
			temp = temp.next;
		}
		return print.toString();
		//return super.toString();
	}

	/**
	 * Used for testing only.
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		/*AttachedList<Plate> plates = new AttachedList<>();
		for(int i = 0; i< 5; i++){
			plates.add(new Plate(i));
		}

		AttachedList<AttachedList<Integer>> packed = new AttachedList<>();
		int value = 1;
		for(int i = 0; i < 10; i++){
			packed.add(new AttachedList<>());
			for(int j = i; j < 10; j++){
				packed.get(i).add(value);
			}
			value ++;
		}

		for(int i = 0; i < packed.size(); i++) {
			System.out.println("AttachedList "+i+" before flat has: "+packed.get(i).toString());
		}

		AttachedList<Integer> flat = new AttachedList<>();
		flat = flatten(packed);
		System.out.println();
		System.out.println("Flat AttachedList has: "+ flat.toString());
		packed.clear();
		packed = pack(flat);
		System.out.println();
		for(int i = 0; i < packed.size(); i++) {
			System.out.println("AttachedList "+i+" after pack has: "+packed.get(i).toString());
		}*/

		//	plates.add(new Plate(1));
		//	plates.add(new Plate(5));
		//AttachedList<AttachedList<Plate>> plates2D = new AttachedList<>();
		//	int i = 0;
		//	int index = 0;
		//	int value = 1;
		//for(int o = 0; o< 3; o++){
		//	plates2D.add(new AttachedList<>());
		//}
		//while(i < 3){
		//	while(index <3){
		//		plates2D.get(index).add(new Plate(value));
		//		index++;
		//	}
		//	value++;
		//	i++;
		//	index = 0;
		//}

		//AttachedList<Plate> plates1D = flatten(plates2D);
		//Iterator<Plate> it = new AttachedList<Plate>();
		// System.out.println(plates.toString());
		// System.out.println(plates.toString());
		AttachedList<Long> stringList = new AttachedList<>();
		AttachedList<Long> list2 = new AttachedList<>();
		int counter = 70000000;
		for(long i = 0; i< 75_000_000; i++){
			stringList.add(i);
			if(stringList.size() == counter){
				System.out.println(stringList.toString());
			}

		}
		//System.out.println(stringList.toString());
		long startTime = System.currentTimeMillis();
		//System.out.println("\nSlicing from Index 0 to index 2: \n"+stringList.slice(0,9999999).toString());
		list2 = stringList.slice(0,99999999);
		long endTime = System.currentTimeMillis();
		//System.out.println("After slicing.");
		//System.out.println(stringList.toString());
		double time = (endTime-startTime)*0.001;
		System.out.println("Total time that it took: "+ time);
	}

	// --------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
	// --------------------------------------------------------

	/**
	 * Makes an object array and returns it.
	 * @return an array of objects.
	 */
	@Override
	public Object[] toArray() {
		Object[] items = new Object[this.size()];
		int i = 0;
		for(T val : this) {
			items[i++] = val;
		}
		return items;
	}

	/**
	 * This method uses the toArray() method to return an array of objects.
	 * In this case this method receives an array of generic values.
	 * @param a holds the array of generic values.
	 * @param <T> Makes the method generic.
	 * @return a generic array.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		return (T[]) this.toArray();
	}

	@Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException("Not supported."); }
	@Override public boolean addAll(Collection<? extends T> c) { throw new UnsupportedOperationException("Not supported."); }
	@Override public boolean addAll(int index, Collection<? extends T> c) { throw new UnsupportedOperationException("Not supported."); }
	@Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException("Not supported."); }
	@Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException("Not supported."); }
	@Override public int lastIndexOf(Object o) { throw new UnsupportedOperationException("Not supported."); }
	@Override public ListIterator<T> listIterator() { throw new UnsupportedOperationException("Not supported."); }
	@Override public ListIterator<T> listIterator(int index) { throw new UnsupportedOperationException("Not supported."); }
	@Override public List<T> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException("Not supported."); }
}