package WeekendAssignment_31May_01June.Tax;

public class TaxCalculator {
    public static double taxBelow60(double taxIncome){
        double tax = 0.0;
        if(taxIncome <= 250000){
            tax=0.0;
        } else if (taxIncome <= 500000) {
            tax = (taxIncome-250000) * 0.05;
        } else if (taxIncome <= 1000000) {
            tax = (500000-250000) * 0.05 + (taxIncome - 500000) * 0.20;
        } else{
            tax = (500000 - 250000) * 0.05 + (1000000 - 500000) * 0.20 + (taxIncome - 1000000) * 0.30;
        }
        return tax;
    }

    public static double taxFor60to80(double taxIncome) {
        double tax = 0.0;
        if (taxIncome <= 300000) {
            tax = 0.0;
        } else if (taxIncome <= 500000) {
            tax = (taxIncome - 300000) * 0.05;
        } else if (taxIncome <= 1000000) {
            tax = (500000 - 300000) * 0.05 + (taxIncome - 500000) * 0.20;
        } else {
            tax = (500000 - 300000) * 0.05 + (1000000 - 500000) * 0.20 + (taxIncome - 1000000) * 0.30;
        }
        return tax;
    }

    public static double taxForAbove80(double taxIncome) {
        double tax = 0.0;

        if (taxIncome <= 500000) {
            tax = 0.0;
        } else if (taxIncome <= 1000000) {
            tax = (taxIncome - 500000) * 0.20;
        } else {
            tax = (1000000 - 500000) * 0.20 + (taxIncome - 1000000) * 0.30;
        }
        return tax;
    }

    public static double calculateTotalTax(double salary, int age, double investments, double healthInsurance, double homeLoanInterest) {
        double section80C = Math.min(investments, 150000);
        double section80D = (age > 60) ? Math.min(healthInsurance, 50000) : Math.min(healthInsurance, 25000);
        double section24 = Math.min(homeLoanInterest, 200000);
        double totalDeductions = section80C + section80D + section24;
        double taxIncome = salary - totalDeductions;
        double tax = 0.0;
        if (age < 60) {
            tax = taxBelow60(taxIncome);
        } else if (age <= 80) {
            tax = taxFor60to80(taxIncome);
        } else {
            tax = taxForAbove80(taxIncome);
        }
        return tax;
    }
}
