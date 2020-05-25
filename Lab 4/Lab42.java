abstract class Account {
 protected double amount;

 public Account() {
  amount = 0.00;
 }
 void deposit(double m) {
  amount = amount + m;
 }
 void withdraw(double m) {
  if (amount >= m)
   amount = amount - m;
  else
   System.out.println("Insufficient Funds");
 }
 abstract public void show();
 abstract public void dailyInterest();
}

class Saving extends Account {
 public void dailyInterest() {
  double interest = amount * 0.06;
  amount = interest + amount;
  System.out.println("$" + amount);
 }
 public void show() {
  System.out.println("S" + amount);
 }
}
class Checking extends Account {
 public void dailyInterest() {
  if (amount >= 1000.00) {
   double interest = amount * 0.03;
   amount = interest + amount;
  }
  System.out.println("$" + amount);
 }
 public void show() {
  System.out.println("$" + amount);
 }
}

public class Lab42 {
 public static void main(String[] args) {
  Account A[] = new Account[2];
  Saving s = new Saving();
  Checking c = new Checking();
  A[0] = s;
  A[1] = c;
  System.out.println("Savings Account");
  A[0].deposit(500.00);
  A[0].show();
  A[0].dailyInterest();
  A[0].withdraw(210.00);
  A[0].show();
  System.out.println("Checkings Account");
  A[1].deposit(1800.00);
  A[1].show();
  A[1].dailyInterest();
  A[1].withdraw(750.00);
  A[1].show();
 }
}