public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        heapSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap (convert the array into a max-heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one from the max heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root (maximum element) to the end of the array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in the array
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as the root
        int leftChild = 2 * i + 1; // Left child
        int rightChild = 2 * i + 2; // Right child

        // If left child is larger than root
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // If right child is larger than largest so far
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If the largest element is not the root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Utility function to print an array
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
