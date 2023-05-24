import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class fizzbuzz {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number:");
        int number = scanner.nextInt();

        if (number%5 ==0 && number%3 == 0)
        System.out.println("Fizz Buzz");
        else if (number%3 == 0)
        System.out.println("Buzz");
        else if (number%5 == 0)
        System.out.println("Fizz ");
        else 
        System.out.println(number);

    }
}
