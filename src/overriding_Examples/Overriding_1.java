package overriding_Examples;

public class Overriding_1 {
	public static void main(String args[]) {
		Test t = new Fest();
		t.tests();
	}
}

class Test {
	void tests() {
		System.out.println("Test class : tests");
	}
}

class Fest extends Test {
	// static method is hiding the instance method
	/*
	 * static void tests(){ System.out.println("Fest class : tests"); }
	 */
}
