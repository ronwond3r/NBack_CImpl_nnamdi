package mobappdev.example.nback_cimpl

/**
 * This class provides the connection to the C-model
 *
 * The class loads the JniBridge when it is initialized.
 * Secondly, it provides the funtion generateNBackString to the rest of the code.
 *
 * Date: 25-08-2023
 * Version: Version 1.1
 * Author: Yeetivity
 *
 */



class NBackHelper {

    // Native function declaration (calls the C function)
    private external fun createNBackString(size: Int, combinations: Int, percentMatch: Int, nBack: Int): IntArray

    fun generateNBackString(size: Int, combinations: Int, percentMatch: Int, nBack: Int): IntArray {
        return createNBackString(size, combinations, percentMatch, nBack)
    }

    companion object {
        init {
            System.loadLibrary("JniBridge") // Load the native C library
        }
    }
}
