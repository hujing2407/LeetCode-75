import numpy as np

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        if n == 2: return max(nums[1], nums[0])
        
        arr = np.zeros((n, 2))

        # the second dimension: 1 is rob, otherwise 0
        arr[0][0] = 100
        arr[0][1] = nums[0]
        res = nums[0]

        for i in range(1,n):
            arr[i][0] = arr[i-1][1]
            arr[i][1] = arr[i-1][0] + arr[i][1]
            res = max(res, arr[i][1])
        return res

def main() -> None:
    nums = [1,2,3]
    Solution().rob(nums)
    
main()
