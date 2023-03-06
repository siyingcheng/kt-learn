import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TestCompanionObject {

    @Test
    @DisplayName("Verify invoke function of companion object correctly")
    fun verifyInvokeFunctionOfCompanionObjectCorrectly() {
        assertEquals(6, Calculator.sum(1, 2, 3))
    }

}

internal class Calculator {
    companion object {
        fun sum(vararg numbers: Int): Int {
            return numbers.sum()
        }
    }
}