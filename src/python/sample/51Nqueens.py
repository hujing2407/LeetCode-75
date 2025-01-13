from typing import List
import copy

class Solution:
    def solveNQueens1(self, n: int) -> List[List[str]]:
        res = []
        self.dfs1(res, [], [], [], n)
        return [["." * i + "Q" + "." * (n - i - 1) for i in pos] for pos in res]

    def dfs1(self, res, positions, xy_dif, xy_sum, n):
        row = len(positions)
        if row == n:
            res.append(positions)
        for col in range(n):
            if (col not in positions and col - row not in xy_dif and col + row not in xy_sum):
                self.dfs1(res, positions + [col], xy_dif +
                          [col - row], xy_sum + [col + row], n)

    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        self.dfs(res, n, 0, 0, 0, 0,[])
        return [["." * i + "Q" + "." * (n - i - 1) for i in pos] for pos in res]

    def dfs(self, res: List[List[int]], n: int, row: int, cols: int, pie: int, na: int, temp: List[int]) -> None:
        if row == n:
            res.append(copy.deepcopy(temp))
            return
        bits = (~(cols | pie | na)) & ((1 << n)-1)
        while bits:
            p = bits & -bits  # Get the LSB 1
            temp.append(self.trans(p,n))
            bits = bits & (bits-1)  # Put a new queen on p
            self.dfs(res, n, row+1, cols | p, (pie | p) << 1, (na | p) >> 1,temp)
            temp.pop()

    def trans(self, bin: int, n:int) -> int:
        p = 0
        while bin:
            p += 1
            bin >>= 1
        return n - p

def main():
    print(Solution().solveNQueens(4))


main()
