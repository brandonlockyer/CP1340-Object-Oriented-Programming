  class MyInteger {
  private int number;
  
  public MyInteger() {
    number = 0;
  }

  public MyInteger(int number) {
    this.number = number;
  }

  public String toString() {
    String s = "number: " + number + "\n" + "Even: " + isEven() + "\n" + "Odd: " + isOdd() + "\n" + "Prime: " + isPrime() + "\n" + "Perfect: " + isPerfect() + "\n" + "Perfect Square: " + isPerfectSquare();
    return s;
  }

  public boolean isEven() {
    if (number % 2 == 0) {
      return true;
    }
      return false;
  }


  public boolean isOdd() {
    if (number % 2 == 1) {
      return true;
    }
      return false;
  }

  public boolean isPrime() {
    int count = 0;
    for (int i = 1; i <= number; i++) {
      if (number % i == 0)
          count++;
      }
      if (count == 2)
        return true;
      else
        return false;

      
  }

  public boolean isPerfect() {
     int sum = 0;
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        sum = sum + i;
      }
      if (sum == 2*number) {
        return true;
      }
    }
		return false;
  }
    

  public boolean isPerfectSquare() {
       int sqrt = (int) Math.sqrt(number);
        if(sqrt*sqrt == number){
          return true;
        }
          return false;
  }

  public void primeFactors() {
    System.out.println("Prime Factors: ");
    for (int i = 2; i < number; i++) {
         while (number % i == 0) {
            System.out.println(i+" ");
            number = number/i;
         }
    }
      if(number > 2) {
         System.out.println(number);
      }
      System.out.println("");
  }
}
public class Lab22 {
public static void main(String[] args) {
	MyInteger n1 = new MyInteger(49);
  System.out.println(n1);
  n1.primeFactors();

  MyInteger n2 = new MyInteger(255);
  System.out.println(n2);
  n2.primeFactors();


  MyInteger n3 = new MyInteger(5);
  System.out.println(n3);
  n3.primeFactors();
}
}