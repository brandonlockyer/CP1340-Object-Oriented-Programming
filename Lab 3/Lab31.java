class IntegerSet {
	private int [] array;
	
	public IntegerSet() {
		array = new int[100];
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	public void insert(int i) {
			array[i] = 1;
		}
	public void delete(int i) {
			array[i] = 0;
	}
	public IntegerSet Union(IntegerSet s2) {
		IntegerSet union = new IntegerSet();
		for(int i = 0; i < array.length; i++) {
			if (this.array[i] == 1 || s2.array[i] == 1) {
				union.insert(i);
			}
		}
		return union;
	}
	public IntegerSet Difference(IntegerSet s2) {
		IntegerSet difference = new IntegerSet();
		for (int i = 0; i < array.length; i++) {
			if(!(this.array[i] == s2.array[i])) {
				difference.insert(i);
			}
		}
		return difference;
	}
	public IntegerSet Intersection(IntegerSet s2) {
		IntegerSet intersection = new IntegerSet();
		for (int i = 0; i < array.length; i++) {
			if(this.array[i] == 1 && s2.array[i] == 1) {
				intersection.insert(i);
			}
		}
		return intersection;
	}
	public boolean equals(IntegerSet s2) {
		for(int i = 0; i < array.length; i++) {
			if(this.array[i] != s2.array[i]) {
				return false;
			}
		}
		return true;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		boolean hasElement1 = false;
		for(int i = 0; i < array.length; i++) {
			if(!hasElement1 && array[i] == 1) {
				sb.append(i);
				hasElement1 = true;
			}
			else if (array[i] == 1) {
				sb.append("," + i);
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
public class Lab31 {
	public static void main(String[] args) {
			IntegerSet s1 = new IntegerSet();
			s1.insert(3);
			s1.insert(6);
			s1.insert(9);
			IntegerSet s2 = new IntegerSet();
			s2.insert(9);
			s2.insert(12);
			s2.insert(15);
			System.out.println("S1: " + s1.toString());
			System.out.println("S2: " + s2.toString());
			System.out.println("Union: " + s1.Union(s2).toString());
			System.out.println("Intersection: " + s1.Intersection(s2).toString());
			System.out.println("Difference: " + s1.Difference(s2).toString());
	}
}