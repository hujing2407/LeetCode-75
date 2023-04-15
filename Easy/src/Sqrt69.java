/**
 * Runtime
 * 1 ms
 * Beats
 * 100%
 *
 * Memory
 * 39.7 MB
 * Beats
 * 77.43%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class Sqrt69 {
    public int mySqrt(int x) {
        int min = 0;
        int max = x;
        int mid = x/2;
        while (min<max){
            // Note: It could be overflow
            if ((long)mid*mid== x) return mid;
            else if ((long)mid*mid > x){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
            mid = (min+max)/2;
        }
        return (int)(min*min>x?min-1:min);
    }
}
