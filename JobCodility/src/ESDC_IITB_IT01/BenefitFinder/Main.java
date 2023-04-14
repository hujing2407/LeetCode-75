package ESDC_IITB_IT01.BenefitFinder;

/**
 * Demonstate whether an applicant is eligible for a benefit
 * and how to print all the benefit names of the applicant.
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class Main {
    public static void main(String[] args) {

        // Create three demo citizen instances.
        Citizen citizen1 = new Citizen(true, false, false);
        Citizen citizen2 = new Citizen(false, true, true);
        Citizen citizen3 = new Citizen(true, true, true);

        // Output whether an applicant is eligible for a benefit.
        System.out.println("-------------------------------");
        System.out.println("Citizen1:");
        System.out.printf("Is eligible for Employee Insurance Benefit: %b\n", citizen1.getWorkTime());
        System.out.printf("Is eligible for Canada Pension Plan Benefit: %b\n", citizen1.getPaidCPP());
        System.out.printf("Is eligible for Student Grant Benefit: %b\n", citizen1.getLowIncome());
        // Output their benefits based on the attributes.
        System.out.println("===============================");
        System.out.println("Print the benefits of citizen1:");
        citizen1.printBenefit();

        // Output whether an applicant is eligible for a benefit.
        System.out.println("-------------------------------");
        System.out.println("Citizen2:");
        System.out.printf("Is eligible for Employee Insurance Benefit: %b\n", citizen2.getWorkTime());
        System.out.printf("Is eligible for Canada Pension Plan Benefit: %b\n", citizen2.getPaidCPP());
        System.out.printf("Is eligible for Student Grant Benefit: %b\n", citizen2.getLowIncome());
        // Output their benefits based on the attributes.
        System.out.println("===============================");
        System.out.println("Print the benefits of citizen2:");
        citizen2.printBenefit();

        // Output whether an applicant is eligible for a benefit.
        System.out.println("-------------------------------");
        System.out.println("Citizen3:");
        System.out.printf("Is eligible for Employee Insurance Benefit: %b\n", citizen3.getWorkTime());
        System.out.printf("Is eligible for Canada Pension Plan Benefit: %b\n", citizen3.getPaidCPP());
        System.out.printf("Is eligible for Student Grant Benefit: %b\n", citizen3.getLowIncome());
        // Output their benefits based on the attributes.
        System.out.println("===============================");
        System.out.println("Print the benefits of citizen3:");
        citizen3.printBenefit();

        Citizen citizen = new Citizen();
        citizen.printBenefit();

    }
}
