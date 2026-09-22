package HeapImplementation;



class MinHeap2max {
    public void convertToMinHeap(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        // The traversal loop remains exactly the same
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMin(i, n, arr);
        }
    }

    // Iterative Min-Heapify down
    public void heapifyMin(int index, int n, int[] arr) {

        while (hasLeftChild(index, n)) {

            int smallestIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            // FLIPPED LOGIC 1: If right child is present AND is SMALLER than left child
            if (hasRightChild(index, n) && arr[rightChildIndex] < arr[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            // FLIPPED LOGIC 2: If current node is GREATER than the smallest child, swap and move down
            if (arr[index] > arr[smallestIndex]) {
                swap(arr, index, smallestIndex);
                index = smallestIndex;
            } else {
                // The node is smaller than both children. It's perfectly placed!
                break;
            }
        }
    }

    // Helper methods (hasLeftChild, hasRightChild, getLeftChildIndex, getRightChildIndex, swap)
    // remain exactly the same as your previous code!
}