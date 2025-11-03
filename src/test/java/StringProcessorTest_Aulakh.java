import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for StringProcessor covering reverseText and countVowels behaviors.
 */
public class StringProcessorTest_Aulakh {

    private final StringProcessor processor = new StringProcessor();

    // Tests reverseText with a typical non-empty string input
    @Test
    public void testReverseNormalCase_S() {
        String input = "Hello World";
        String expected = "dlroW olleH";
        assertEquals(expected, processor.reverseText(input));
    }

    // Tests reverseText handles null input by returning null
    @Test
    public void testReverseNullInput_S() {
        assertNull(processor.reverseText(null));
    }

    // Tests countVowels with a string containing multiple vowels
    @Test
    public void testCountVowels_WithVowels_S() {
        String text = "education"; // e, u, a, i, o -> 5 vowels
        assertEquals(5, processor.countVowels(text));
    }

    // Tests countVowels with a string that has no vowels
    @Test
    public void testCountVowels_NoVowels_S() {
        String text = "rhythms"; // no a e i o u
        assertEquals(0, processor.countVowels(text));
    }

    // Tests countVowels with mixed case characters
    @Test
    public void testCountVowels_MixedCase_S() {
        String text = "ApplE OrAnGE"; // A, E, O, A, E -> 5 vowels
        assertEquals(5, processor.countVowels(text));
    }

    // Additional scenario: reverseText with empty string should return empty string
    @Test
    public void testReverseEmptyString_S() {
        assertEquals("", processor.reverseText(""));
    }

    // Additional: palindrome should reverse to itself
    @Test
    public void testReversePalindrome_S() {
        String input = "racecar";
        assertEquals("racecar", processor.reverseText(input));
    }

    // Additional: countVowels ignores numbers and special characters
    @Test
    public void testCountVowels_WithSpecialCharacters_S() {
        String input = "Hello123!@# World"; // e, o, o -> 3 vowels
        assertEquals(3, processor.countVowels(input));
    }

    // Additional: reverse single character returns same character
    @Test
    public void testReverseSingleCharacter_S() {
        assertEquals("A", processor.reverseText("A"));
    }
}
