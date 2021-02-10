class CompileTest {
	public static void main(String[] args) {
		int x;
		boolean b;
		String s;
		
		AttachedList<String> list1 = new AttachedList<>();
		x = list1.size();
		b = list1.isEmpty();
		b = list1.add("Banana");
		try { list1.add(0, "Banana"); } catch(IndexOutOfBoundsException e) { }
		b = list1.contains("Banana");
		try { s = list1.get(0); } catch(IndexOutOfBoundsException e) { }
		try { s = list1.set(0, "Apple"); } catch(IndexOutOfBoundsException e) { }
		x = list1.indexOf("Banana");
		try { s = list1.remove(0); } catch(IndexOutOfBoundsException e) { }
		b = list1.remove("Banana");
		list1.clear();
		try { AttachedList<String> list2 = list1.slice(0,0); } catch(IndexOutOfBoundsException e) { }
		AttachedList<String> list3 = list1.reverseCopy();
		AttachedList<AttachedList<Integer>> list4 = new AttachedList<>();
		AttachedList<Integer> list5 = AttachedList.flatten(list4);
		AttachedList<AttachedList<Integer>> list6 = AttachedList.pack(list5);
		for(AttachedList<Integer> list7 : list6) { }
		Object[] arr1 = list5.toArray();
		String[] arr2 = list5.toArray(new String[0]);
		
		Plate p = new Plate(0);
		s = p.toString();
		x = p.getNumber();
		
		Bin bin = new Bin();
		s = bin.toString();
		b = bin.push(p);
		Plate p2 = bin.pop();
		x = bin.size();
		b = bin.isEmpty();
		bin.clear();
		
		Air air = new Air();
		s = air.toString();
		b = air.enqueue(p);
		Plate p3 = air.dequeue();
		x = air.size();
		b = air.isEmpty();
		air.clear();
		
		Spinner sy = new Spinner(1);
		s = sy.toString();
		sy.passPlate();
		sy.putDownPlate();
		try { sy.pickUpPlate(); } catch(RuntimeException e) { }
		try { sy.spinPlate(); } catch(RuntimeException e) { }
		try { sy.catchPlate(); } catch(RuntimeException e) { }
	}
}