/**
 * ============================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ============================================================

 * Use Case 11: Object-Oriented Palindrome Service

 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.

 * The palindrome logic is encapsulated inside a
 * PalindromeService class.

 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @author Developer
 * @version 11.0
 */

public class PalindromeApp {

    /**
     * Application entry point for UC11.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        String input = "racecar";

        // Create service object
        PalindromeService service = new PalindromeService();

        // Call service method
        boolean isPalindrome = service.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {

            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}