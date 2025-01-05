def quicksort(arr):
    if len(arr) <= 1:return arr
    else:
        pivot = arr[len(arr)-1]
        left = [i for i in arr if i < pivot]
        right = [i for i in arr if i > pivot]
        return quicksort(left)+[pivot]+quicksort(right)

def main() -> None:
    arr = [3, 6, 8, 10, 1, 2, 1]
    print("Original array:", arr)
    sorted_arr = quicksort(arr)
    print("Sorted array:", sorted_arr)

main()