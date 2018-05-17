package overriding_Examples;

import java.io.IOException;

public class Overriding_4 {
}	 
	class Animal {
	  public void eat() throws IOException {
	  }
	}
	class Dog extends Animal {
		// Compilation error
		// Exception not comaptible with overrided method
		// U can only downgrade the Exception NOT expand
	  /*public void  eat() throws Exception {
	  }*/
	}
