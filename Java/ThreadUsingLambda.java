
//class L1 implements Runnable{
//    public void run() {
//        for(int i=0 ; i<5 ; i++){
//            System.out.println("hi");
//            try{ Thread.sleep(10); } catch(InterruptedException e){ e.printStackTrace();}
//        }
//    }
//}
//
//class L2 implements Runnable{
//    public void run() {
//        for(int i=0 ; i<5 ; i++){
//            System.out.println("hello");
//            try{ Thread.sleep(10); } catch(InterruptedException e){ e.printStackTrace();}
//        }
//    }
//}

public class ThreadUsingLambda {
    public static void main(String[] args) {
        Runnable obj1 = () -> {
            for(int i=0 ; i<5 ; i++){
                System.out.println("hi");
                try{ Thread.sleep(10); } catch(InterruptedException e){ e.printStackTrace();}
            }
        };
        Runnable obj2 = () -> {
            for(int i=0 ; i<5 ; i++){
                System.out.println("hello");
                try{ Thread.sleep(10); } catch(InterruptedException e){ e.printStackTrace();}
            }
        };

        // it does't have a start method so refer the parentclass for each class obj /
        //then the constructor pass the obj into the threads obj then, the thread will be execute the start method..

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}

