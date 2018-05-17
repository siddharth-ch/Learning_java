package overriding_Examples;

public class Overriding_3 {
    public static void main(String aga[]){
    Super superRef =new Sub();
    Sub subRef = new Sub();
    Super suRef=new Super();
     
    superRef.tests();
    subRef.tests();
    suRef.tests();
    }
}
class Super{
     public static void tests(){
        System.out.println("Super static");
    }
}
class Sub extends Super{
    public static void tests(){
        System.out.println("Sub static");
    }
}