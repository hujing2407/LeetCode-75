class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = right;
        int pos = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr[i], arr[pos]);
                pos++;
            }
        }
        swap(arr[pos], arr[pivot]);
        return pos;
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}