interface X{
    // in interface there is automatically they consider is public and abstract method ....
    int age = 33;   //in  interface there is the variable is always there are is final and static
    String name = "Alsabith";

    void show();
    void config();
}

interface W {
    void run();
}

class R implements X,W{
    public void show(){
        System.out.println("in show");
    }
    public void config(){
        System.out.println("in config");
    }
    public void run(){
        System.out.println("in running...");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        W obj;
        obj =new R();
        obj.run();

        X obj1 = new R();
        obj1.show();
        obj1.config();

        System.out.println(X.name);  //use the interface variable without creating there objects...
        System.out.println(X.age);
    }
}
