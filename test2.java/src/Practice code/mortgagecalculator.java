import java.util.Scanner;

public class mortgagecalculator {
    public static void main(String[] args) {
      final byte months_in_year = 12;
      final byte percent = 100;
int principal = 0;
float annualInterest = 0;
float monthlyInterest = 0;
int numberofpayments = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.print("Mortgage Amounth: ");
          principal = scanner.nextInt();
          if (principal >=1000 && principal <= 1_000_000)
          break;
          System.out.println("Enter a Value between 1000 and 1000000 ");
        }
        while (true) {
          System.out.print("Annual Interest Rate:");
          annualInterest = scanner.nextFloat();
          if (annualInterest >= 0 && annualInterest <=30) {
          monthlyInterest = annualInterest / percent / months_in_year;
          break;
          }
          System.out.println(" Please Enter a Value Between 1 to 30");
          
        }
        while (true) {
          System.out.print(" Period (Years):");
          byte years = scanner.nextByte();
          numberofpayments = years * months_in_year;
          if (years >=0 && years <= 30)
          break;
          System.out.println("Please Enter a ValureBetween 1 and 30");
        }
          double mortgage = principal * (monthlyInterest * (Math.pow(1+monthlyInterest, numberofpayments)))/(Math.pow(1+monthlyInterest, numberofpayments)-1);
          System.out.println(mortgage);
    }
    }

