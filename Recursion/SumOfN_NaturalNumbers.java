import java.util.Scanner;

public class SumOfN_NaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Natural Number :");
        int num = sc.nextInt();
        System.out.print(sum(num));

    }
    static int sum(int num){
        if(num == 0){
            return 0;
        }
        return num + sum(num -1);
    }
}
