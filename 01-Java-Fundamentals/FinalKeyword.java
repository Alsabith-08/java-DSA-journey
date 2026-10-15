//FINAL - VARIABLE , METHOD ,CLASS

/*final*/ class calc{  //final class stop the inheritance
    final public void show(){ //final method stop the method overriding
        System.out.println("by Alsabith");
    }
    public void add(int a , int b){
        System.out.println(a+b);
    }
}
class AdvCalc extends calc{
    // cannot use the same method name(overriding) bcoz the method has final keyword
//    public void show(){
//        System.out.println("by Alsa");
//    }
}


public class FinalKeyword {
    public static void main (String []args){

        final int num = 9; // make it constant value  , doesn't change
        System.out.println(num);

        AdvCalc obj = new AdvCalc();
        obj.show();      // this executes the final method
        obj.add(3,5);
    }
}
