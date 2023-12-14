package Contest.Dec09_2023;

/**
 * @author Jing Hu
 * @date Dec. 09 2023
 */
public class CountTestedDevicesAfterTestOperations {
    public int countTestedDevices(int[] batteryPercentages) {
        int cnt  = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if(batteryPercentages[i]-cnt > 0 ) cnt++;
        }
        return cnt;
    }
}
