package POTD;

public class MinimumSwaps3551 {
}

// graph cycle problem





/*
import java.util.Arrays;

class Solution {
    // Helper function: Number ke digits ka sum nikalne ke liye
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] arr) {
        int n = arr.length;

        // Step 1: Ek 2D array jisme hum [value, digit_sum, original_index] store karenge
        int[][] arrPos = new int[n][3];

        for (int i = 0; i < n; i++) {
            arrPos[i][0] = arr[i];  //number
            arrPos[i][1] = getDigitSum(arr[i]);  // sum
            arrPos[i][2] = i;  // index in original array
        }

        // Step 2: Custom Sorting
        Arrays.sort(arrPos, (a, b) -> {
            // Agar digit sum same nahi hai, toh digit sum se sort karo
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            // Agar digit sum same hai, toh actual value se sort karo (tie-breaker)
            return Integer.compare(a[0], b[0]);
        });

        // Step 3: Cycle trace karke swaps count karna
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Agar pehle visit ho chuka hai ya pehle se sahi jagah par hai
            if (visited[i] || arrPos[i][2] == i) {
                continue;
            }

            // Nayi cycle trace karo
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                // Agle element par jump karo original index dekh kar
                j = arrPos[j][2];
                cycleSize++;
            }

            // Swaps = (Cycle ki size - 1)
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}


 */