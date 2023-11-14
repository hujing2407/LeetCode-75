package ESDC_IITB_IT01.BenefitFinder.BenefitImpl;

import ESDC_IITB_IT01.BenefitFinder.Benefit;

/**
 * The EmployeeInsuranceBenefit class represents the Employee Insurance Benefit.
 * It implements the Benefit interface and provides an implementation for the
 * benefit() method, which output the benefit name.
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class EmployeeInsuranceBenefit implements Benefit {

    /**
     * Outputs the Employee Insurance benefit name.
     */
    @Override
    public void benefit() {
        System.out.println("Employee Insurance Benefit");
    }
}
