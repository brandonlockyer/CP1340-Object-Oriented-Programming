class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		String s = new String(id + " " + name + " " + salary);
		return s;
	}
}

class Policy {
	private int pid;
	private String beneficiary;
	private double amount;
	
	public Policy(int pid, String beneficiary, double amount){
		this.pid = pid;
		this.beneficiary = beneficiary;
		this.amount = amount;
	}
	
	public String toString() {
		String s = new String(pid + " " + beneficiary + " " + amount);
		return s;
	}
}

class Salesperson extends Employee {
	private Policy p;

	public Salesperson(int id, String name, double salary, Policy p) {
		super(id, name, salary);
		this.p = p;
	}
	
	public String toString() {
		String s = super.toString() + " Policy: " + p.toString();
		return s;
	}
}

class Lab41 {
	public static void main(String[] args) {
		Employee e = new Employee(3, "Bobby", 45000);
		System.out.println(e);
		
		Policy p = new Policy(4,"Jimmy", 86000);
		System.out.println(p);

		Salesperson s = new Salesperson(5, "Phil", 69000, p);
		System.out.println(s);
		
	}
	
	
}