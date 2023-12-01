package ESDC_IITB_IT01.BenefitFinder.BenefitImpl;

import ESDC_IITB_IT01.BenefitFinder.Benefit;

/**
 * The CanandaPensionPlanBenefit class represents the Canada Pension Plan Benefit.
 * It implements the Benefit interface and provides an implementation for the
 * benefit() method, which output the benefit name.
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class CanandaPensionPlanBenefit implements Benefit {

    /**
     * Outputs the Canada Pension Plan benefit name.
     */
    @Override
    public void benefit() {
        System.out.println("Canada Pension Plan Benefit");
    }
}
