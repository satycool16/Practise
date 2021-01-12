public class HeapSort {
    public void sort(int[] arr){
    int n = arr.length;
    int non_leaf = (n/2)-1;
    for (int i= non_leaf; i>=0 ; i--){
        max_heapify(arr, n, i);
    }
    for(int i=n-1; i>=0; i--){
        int temp = arr[i];
        arr[i] = arr[0];
        arr[0] = temp;
        max_heapify(arr, i, 0);
    }
    }
    private void max_heapify(int[] arr, int n, int i){
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;
    if (left < n && arr[i]< arr[left]){
        largest = left;
    }
    if (right < n && arr[largest]<arr[right]){
        largest = right;
    }
    if (largest != i){
        int temp =arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        max_heapify(arr, n, largest);
    }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {12, 11,33,44,45, 1, 0, 3333, 13, 5, 6, 7};
        HeapSort hs = new HeapSort();
        hs.sort(arr);
        printArray(arr);
    }
}
