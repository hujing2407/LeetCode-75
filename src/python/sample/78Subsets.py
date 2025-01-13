from typing import List
import copy

class Solution:
    
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtrack(nums,0, res, [])
        return res

    def backtrack(self, nums:List[int], start: int, res: List[List[int]], track:List[int]) -> None:
        res.append(track)
        for i in range(start,len(nums)):
            self.backtrack(nums,i+1,res,track+[nums[i]])

def main():
    print(Solution().subsets([1,2,3]))


main()