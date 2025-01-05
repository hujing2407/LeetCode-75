from typing import List

def generateParenthesis( n: int) -> List[str]:
    arr = []
    s = ""
    p(arr,s,0,0, n)
    return arr

def p(arr:List[str], s:str, left: int, right:int, n:int) -> None:
    if len(s) == 2*n: 
        arr.append(s)
        return
    
    if left < n :
        p(arr,s+'(',left+1,right, n)

    if right < left:
        p(arr,s+')',left,right+1,n)

    
def main():
    arr = generateParenthesis(3)
    print(arr)

main()
