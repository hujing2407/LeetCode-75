from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def dfs(positions, xy_dif, xy_sum):
            y = len(positions)
            if y == n:
                p_arr.append(positions)
                return
            for x in range(n):
                if x not in positions and x-y not in xy_dif and x+y not in xy_sum:
                    dfs(positions+[x], xy_dif+[x-y], xy_sum+[x+y])

        p_arr = []
        dfs([], [], [])
        return [["."*i+"Q"+"."*(n-i-1) for i in col] for col in p_arr]


def main():
    print(Solution().solveNQueens(4))


main()
