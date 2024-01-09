import java.util.Scanner;

public class percent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Here we are going calculate all the calc");

        System.out.println("First tell me total marks of all subjects");
        float sub_total = sc.nextFloat();

        System.out.println("enter marks for sub1");
        float m1 = sc.nextFloat();

        System.out.println("enter marks for sub2");
        float m2 = sc.nextFloat();

        System.out.println("enter marks for sub3");
        float m3 = sc.nextFloat();

        System.out.println("enter marks for sub4");
        float m4 = sc.nextFloat();

        System.out.println("enter marks for sub5");
        float m5 = sc.nextFloat();

        float sum = m1+m2+m3+m4+m5;
        System.out.println("the total marks obtained out of -" + sub_total + "is :"+sum);

        float percent = sum*100/sub_total;
        System.out.println("the percentage is :"+percent);


//        System.out.println("Enter kilometers");
//        float kilo = sc.nextFloat();
//
//
//        float mile =(float) (kilo/1.609344);
//        System.out.println(kilo + "kilo meter is" + mile + "miles");

    }
}
