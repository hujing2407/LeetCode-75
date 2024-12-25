# 1. brute force: recursive
# 2. BFS, minimum level
# 3. DP
#     a. sub problems: minus 1 or 2 or 5, min + 1
#     b. DP array: dp[i]
#     c. DP function: dp[i] = min(dp[i-1], dp[i-2], dp[i-5]) + 1

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        Max = float("inf")
        dp = [0] + [Max] * amount

        for i in range(1, amount + 1):
            dp[i] = min([dp[i - c] if i - c >= 0 else Max for c in coins]) + 1

        return [dp[amount], -1][dp[amount] == Max]
    
def main():
    coins =[1,2,5]
    amount = 11 
    match = Solution().coinChange(coins, amount)
    print(match)

main()