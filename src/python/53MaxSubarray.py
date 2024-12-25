import copy
from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = copy.deepcopy(nums)
        for i in range(1,len(nums)):
            dp[i] = max(nums[i],nums[i]+dp[i-1])
        return max(dp)

    
def main():
    nums = [-2,1,-3,4,-1,2,1,-5,4]
    match = Solution().maxSubArray(nums)
    print(match)

main()
