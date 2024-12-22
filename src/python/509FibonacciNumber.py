class Solution:
    def fib1(self, n: int) -> int:
        def dfs(n):
            if n < 2: 
                return n
            return dfs(n-1) + dfs(n-2)
        return dfs(n)
    
    def fib(self, n: int) -> int:
        dp = [0,1] + [0] *(n-1)
        for i in range(2,n+1):
            dp[i] = dp[i-1] + dp[i-2]
            
        return dp[n]
    
def main():
    print(Solution().fib(10))

main()

