/**
 * @author Jing Hu
 * @date Feb 13 2021
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    public int countPrime(int n){
        //create an array to mark it's prime or not
        boolean[] isPrime = new boolean[n];
        // initiate array
        for (int i = 2; i < n; i++) {
            isPrime[i]=false;
        }
        // Loop's ending condition is i*i <n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt()
        for (int i = 2; i*i < n; i++) {
            if(!isPrime[i]) continue;
            for (int j = i*i; j < n; j+=i) {
                isPrime[j]=false;
            }
        }
        int count = 0;
        for (int j = 2; j <n; j++) {
            if(isPrime[j]) count++;
        }
        return count;
    }
}
