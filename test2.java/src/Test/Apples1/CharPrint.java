package Test.Apples1;

public class CharPrint {

    public static void main(String[] args) {
char c;
long startTime = System.currentTimeMillis();
for(int i = 65; i < 91; i++) {
    c =(char) i;
    char  d= (char)(c + 32);
    System.out.print(" " + c + " " + (d) + " ");
}
long endTime = System.currentTimeMillis();
System.out.println();
System.out.println(" it took : " + (endTime - startTime) + " miliseconds to run the program..");
    
    }
}
