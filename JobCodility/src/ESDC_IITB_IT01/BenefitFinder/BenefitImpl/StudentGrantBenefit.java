package ESDC_IITB_IT01.BenefitFinder.BenefitImpl;

import ESDC_IITB_IT01.BenefitFinder.Benefit;

/**
 * The StudentGrantBenefit class represents the Student Grant Benefit.
 * It implements the Benefit interface and provides an implementation for the
 * benefit() method, which output the benefit name.
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class StudentGrantBenefit implements Benefit {

    /**
     * Outputs the Student Grant benefit name.
     */
    @Override
    public void benefit() {
        System.out.println("Student Grant Benefit");
    }
}
