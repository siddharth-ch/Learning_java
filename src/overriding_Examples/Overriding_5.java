package overriding_Examples;

import java.util.ArrayList;
import java.util.List;

public class Overriding_5 {
	
	static {
		System.out.println("static");
	}
	
	public static void main(String[] args) {
		int val = 0;
		if(val >4 ){
			
		} else if (val >9){
			
		} else
			
			System.out.println("hello");
	}
}
/*
 * class MyClass { static void foo() {} } class MySubclass extends MyClass { //
 * Compilation Error at method foo() below // Override needs to be removed //
 * @Override //static void foo() {} }
 */