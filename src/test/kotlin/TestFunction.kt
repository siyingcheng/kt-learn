import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TestFunction {
    companion object {
        const val HELLO = "HELLO"
    }

    @Test
    @DisplayName("Verify none arguments function work fine")
    fun verifyNoneArgumentsFunctionWorkFine() {
        assertEquals(HELLO, sayHello())
    }

    @Test
    @DisplayName("Verify regular arguments function work fine")
    fun verifyRegularArgumentsFunctionWorkFine() {
        assertEquals("This is Simon, 18 years old.", personInfo("Simon", 18))
    }

    @Test
    @DisplayName("Verify varargs arguments function work fine")
    fun verifyVarargsArgumentsFunctionWorkFine() {
        assertEquals(6, sum(1, 2, 3))
        assertEquals(45, sum(9, 8, 7, 6, 5, 4, 3, 2, 1))
    }

    private fun sum(vararg nums: Int): Int {
        var res = 0
        // Regular way
        /*
        for (num in nums) {
            res += num
        }
         */
        // Another way
        nums.forEach { i -> res += i }
        return res
    }

    private fun personInfo(name: String, age: Int): String {
        return "This is $name, $age years old."
    }

    private fun sayHello(): String {
        return HELLO
    }
}