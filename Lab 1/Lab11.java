public class Lab11 {
	public static void main(String[] args) {
		int[] array = new int [1000];
		init(array);
		findPrimes(array);
		printPrimes(array);
	}
	
	public static void init(int[] array) {
		for (int i = 2; i<array.length; i++){
			array[i] = 1;
		}
	}
	
	public static void findPrimes(int[] array) {
		for (int i = 2; i<array.length; i++) {
			if( array[i] ==1)
				for (int m = i*2; m<array.length; m = m + i) {
					array[m] = 0;
				}
		}
	}
	
	public static void printPrimes(int[] array){
		for (int i = 2; i<array.length; i++) {
			if (array[i] == 1)
				System.out.println(i);
		}
	}
}