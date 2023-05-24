import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
for (int i = 0; i<10 ; i++)
        System.out.println("Hello World" + "  " + i );
int i = 0;
while (i > 0) {
    System.out.println("Hello World" + "  " + i);
}
Scanner scanner = new Scanner(System.in);
String input = "";
while (true) {
   System.out.print("Input: ");
    input = scanner.next().toLowerCase();
    if (input.equals("pass"))
    continue;
    if (input.equals("quit"))
    break;
    System.out.println(input);
  
}
    }
    
}
