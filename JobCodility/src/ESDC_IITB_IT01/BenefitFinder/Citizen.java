package ESDC_IITB_IT01.BenefitFinder;

import ESDC_IITB_IT01.BenefitFinder.BenefitImpl.CanandaPensionPlanBenefit;
import ESDC_IITB_IT01.BenefitFinder.BenefitImpl.EmployeeInsuranceBenefit;
import ESDC_IITB_IT01.BenefitFinder.BenefitImpl.StudentGrantBenefit;

import java.util.ArrayList;

/**
 * Citizen Entity, includes three boolean attributes and a list of benefits
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class Citizen {

    private Boolean workTime;
    private Boolean paidCPP;
    private Boolean lowIncome;

    private ArrayList<Benefit> benefits;

    // Non-arg constructor
    public Citizen() {
        this.workTime = false;
        this.paidCPP = false;
        this.lowIncome = false;
        this.benefits = new ArrayList<>();
    }

    // Arg constructor
    public Citizen(Boolean workTime, Boolean paidCPP, Boolean lowIncome) {
        this.workTime = workTime;
        this.paidCPP = paidCPP;
        this.lowIncome = lowIncome;
        this.benefits = new ArrayList<>();
    }

    // Getters & Setters
    public Boolean getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Boolean workTime) {
        this.workTime = workTime;
    }

    public Boolean getPaidCPP() {
        return paidCPP;
    }

    public void setPaidCPP(Boolean paidCPP) {
        this.paidCPP = paidCPP;
    }

    public Boolean getLowIncome() {
        return lowIncome;
    }

    public void setLowIncome(Boolean lowIncome) {
        this.lowIncome = lowIncome;
    }

    /**
     * Print the benefits based on attributes
     */
    public void printBenefit() {

        if (workTime) {
            benefits.add(new EmployeeInsuranceBenefit());
        }
        if (paidCPP) {
            benefits.add(new CanandaPensionPlanBenefit());
        }
        if (lowIncome) {
            benefits.add(new StudentGrantBenefit());
        }

        for (Benefit b : benefits) {
            b.benefit();
        }
    }
}
