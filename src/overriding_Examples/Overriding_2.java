package overriding_Examples;

public class Overriding_2 {
    public static void main(String aga[]){
    Test1 t =new Fest1();
    // compilation error due to 0 visibility of tests() [private]
    //t.tests();
    }
}
class Test1{
     private void tests(){
        System.out.println("Test class : tests");
    }
}
class Fest1 extends Test1{
    public void tests(){
        System.out.println("Fest class : fests");
    }
}