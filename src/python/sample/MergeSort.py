def mergesort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) >> 1
    left = arr[:mid]
    right = arr[mid:]
    mergesort(left)
    mergesort(right)

    i = j = k = 0

    # merge sorted arr
    while i < len(left) and j < len(right) :
        if left[i] < right[j]:
            arr[k] = left[i]
            i += 1
        else:
            arr[k] = right[j]
            j += 1
        k += 1
    while i < len(left):
        arr[k] = left[i]
        k += 1
        i += 1
    while j < len(right):
        arr[k] = right[j]
        k += 1
        j += 1
    return arr

    

def main() -> None:
    arr = [3, 6, 8, 10, 1, 2, 1]
    print("Original array:", arr)
    sorted_arr = mergesort(arr)
    print("Sorted array:", sorted_arr)

main()