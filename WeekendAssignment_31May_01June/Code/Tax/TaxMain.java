package WeekendAssignment_31May_01June.Tax;
import java.util.*;
public class TaxMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your investment in tax-saving instruments: ");
        double investments = sc.nextDouble();
        System.out.print("Enter your health insurance premium: ");
        double healthInsurance = sc.nextDouble();
        System.out.print("Enter your home loan interest paid: ");
        double homeLoanInterest = sc.nextDouble();

        double totalTax = TaxCalculator.calculateTotalTax(salary, age, investments, healthInsurance, homeLoanInterest);
        System.out.println("\nTotal Tax Owed: " + totalTax);
        sc.close();
    }
}
