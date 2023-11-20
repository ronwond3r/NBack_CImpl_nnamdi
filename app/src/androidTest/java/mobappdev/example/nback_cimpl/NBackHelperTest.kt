package mobappdev.example.nback_cimpl

import org.junit.Assert
import org.junit.Test

class NBackHelperTest {

    @Test
    fun testGenerateNBackString() {
        val size = 10
        val combinations = 4
        val percentMatch = 30
        val nBack = 1

        val nBackHelper = NBackHelper()
        val result: IntArray = nBackHelper.generateNBackString(size, combinations, percentMatch, nBack)

        // Assert that result is non null
        Assert.assertNotNull(result)

        // Calculate the expected number of matches
        val expectedMatches = (size * percentMatch) / 100

        // Check the number of actual matches
        var actualMatches = 0
        for (i in nBack until size) {
            if (result[i] == result[i - nBack]) {
                actualMatches++
            }
        }

        // Assert that the number of matches is within acceptable range
        val tolerance = 1
        val lowerBound = expectedMatches - tolerance
        val upperBound = expectedMatches + tolerance
        Assert.assertTrue("Number of matches ($actualMatches) is not within the acceptable range [$lowerBound, $upperBound]",
            actualMatches in lowerBound..upperBound)

        // Print the string for manual check
        println("Generated nBackString: ${result.joinToString(", ")} with $actualMatches matches")
    }
}