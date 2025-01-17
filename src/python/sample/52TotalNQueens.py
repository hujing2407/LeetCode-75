class Solution:
    def totalNQueens(self, n: int) -> int:
        if n < 1:
            return []
        self.count = 0
        self.dfs(n, 0, 0, 0, 0)
        return self.count

    def dfs(self, n: int, row: int, cols: int, pie: int, na: int) -> None:
        # print(row, bin(cols),bin(pie),bin(na))
        if row >= n:
            self.count += 1
            return
        bits = (~(cols | pie | na)) & ((1 << n)-1)
        # print(bin(bits))

        while bits:
            p = bits & -bits  # Get the LSB 1
            bits = bits & (bits-1)  # Put a new queen on p (set p bit to 0)
            self.dfs(n, row+1, cols | p, (pie | p) << 1, (na | p) >> 1)    

def main():
    print(Solution().totalNQueens(4))


main()