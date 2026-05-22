package Assignment;

/**
 * Test Results and Demonstrations for Assignment Encoder
 * This file shows manual test cases and expected outputs
 */
public class TestResults {

    public static void main(String[] args) {
        System.out.println("=== TEXT ENCODER TEST RESULTS ===\n");

        // Test Case 1: Simple lowercase text
        System.out.println("TEST CASE 1: Simple lowercase text");
        System.out.println("Input: \"hello world\"");
        Encoded test1 = new Encoded("hello world");
        System.out.println("Output: \"" + test1.getResultText() + "\"");
        System.out.println("Character Count: " + test1.getCharCount());
        System.out.println("Final Shift: " + test1.getFinalShift());
        System.out.println();

        // Test Case 2: Text with digits
        System.out.println("TEST CASE 2: Text with digits");
        System.out.println("Input: \"test123\"");
        Encoded test2 = new Encoded("test123");
        System.out.println("Output: \"" + test2.getResultText() + "\"");
        System.out.println("Character Count: " + test2.getCharCount());
        System.out.println("Final Shift: " + test2.getFinalShift());
        System.out.println();

        // Test Case 3: Single character
        System.out.println("TEST CASE 3: Single character");
        System.out.println("Input: \"a\"");
        Encoded test3 = new Encoded("a");
        System.out.println("Output: \"" + test3.getResultText() + "\"");
        System.out.println("Character Count: " + test3.getCharCount());
        System.out.println("Final Shift: " + test3.getFinalShift());
        System.out.println();

        // Test Case 4: Text with multiple spaces
        System.out.println("TEST CASE 4: Text with multiple spaces");
        System.out.println("Input: \"hello   world\"");
        Encoded test4 = new Encoded("hello   world");
        System.out.println("Output: \"" + test4.getResultText() + "\"");
        System.out.println("Character Count: " + test4.getCharCount());
        System.out.println("Final Shift: " + test4.getFinalShift());
        System.out.println();

        // Test Case 5: Numbers only
        System.out.println("TEST CASE 5: Numbers only");
        System.out.println("Input: \"0123456789\"");
        Encoded test5 = new Encoded("0123456789");
        System.out.println("Output: \"" + test5.getResultText() + "\"");
        System.out.println("Character Count: " + test5.getCharCount());
        System.out.println("Final Shift: " + test5.getFinalShift());
        System.out.println();

        // Test Case 6: Mixed content
        System.out.println("TEST CASE 6: Mixed content");
        System.out.println("Input: \"abc 123 xyz\"");
        Encoded test6 = new Encoded("abc 123 xyz");
        System.out.println("Output: \"" + test6.getResultText() + "\"");
        System.out.println("Character Count: " + test6.getCharCount());
        System.out.println("Final Shift: " + test6.getFinalShift());
        System.out.println();

        // Test Case 7: Validation tests
        System.out.println("=== VALIDATION TESTS ===\n");
        Encoded validator = new Encoded();

        String[] validInputs = {"hello", "test123", "abc def", "0 1 2"};
        String[] invalidInputs = {"Hello", "TEST", "hello!", "abc@123", "Test_123"};

        System.out.println("Valid Inputs:");
        for (String input : validInputs) {
            System.out.println("  \"" + input + "\" -> " + validator.checkStringValidity(input));
        }
        System.out.println();

        System.out.println("Invalid Inputs (should be false):");
        for (String input : invalidInputs) {
            System.out.println("  \"" + input + "\" -> " + validator.checkStringValidity(input));
        }
        System.out.println();

        // Test Case 8: Understanding the cipher logic
        System.out.println("=== CIPHER LOGIC EXPLANATION ===\n");
        System.out.println("Group ID: G05/SE-G07");
        System.out.println("Base Shift (from groupID.hashCode()): " + validator.generateShift());
        System.out.println("This base shift (1-10) is added to the character count to get the final shift.\n");
        System.out.println("Example: 'hello' has 5 characters");
        System.out.println("Final Shift = " + validator.generateShift() + " + 5 = " + (validator.generateShift() + 5));
        System.out.println("Each letter is shifted by this amount (wrapping around the alphabet)");
        System.out.println("Each digit is shifted by this amount (wrapping around 0-9)");
    }
}
