/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================

 * Use Case 13: Performance Comparison

 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.

 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results

 * This use case focuses purely on performance
 * measurement and algorithm comparison.

 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

public class PalindromeApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Choose strategy (StackStrategy reused here)
        PalindromeStrategy strategy = new StackStrategy();

        // Capture start time
        long startTime = System.nanoTime();

        boolean result = strategy.check(input);

        // Capture end time
        long endTime = System.nanoTime();

        // Calculate duration
        long duration = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println("Execution Time (nanoseconds): " + duration);
    }
}

/**
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * Stack-based Strategy Implementation
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) {
            return false;
        }

        // Normalize for fair comparison
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push characters onto stack
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}