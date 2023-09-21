public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; // Change the number of terms as needed
        
        long[] fibonacciSeries = new long[n];
        
        // First two terms of the Fibonacci series
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        
        // Generate the rest of the series
        for (int i = 2; i < n; i++) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }
        
        // Print the Fibonacci series
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSeries[i] + " ");
        }
    }
}
