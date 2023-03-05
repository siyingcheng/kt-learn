import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals

internal class TestCaseWhen {
    companion object {
        const val REGULAR_CUSTOMER = "Regular customer"
        const val VIP = "VIP"
        const val BABY = "Baby"
        const val CHILDREN = "Children"
        const val ADULT = "Adult"
        const val OLD = "Old"
        const val ERROR_AGE = "Error age"
    }

    @Test
    @DisplayName("Verify the function return correctly when the parameter is CustomerType.REGULAR")
    fun verifyTheFunctionReturnCorrectlyWhenTheParameterIsCustomerTypeRegular() {
        assertEquals(REGULAR_CUSTOMER, customerType(CustomerType.REGULAR))
    }


    @Test
    @DisplayName("Verify the function return correctly when the parameter is CustomerType.VIP")
    fun verifyTheFunctionReturnCorrectlyWhenTheParameterIsCustomerTypeVIP() {
        assertEquals(VIP, customerType(CustomerType.VIP))
    }

    @Test
    @DisplayName("Verify the function return correctly when age in 0 to 3")
    fun verifyTheFunctionReturnCorrectlyWhenAgeIn0To3() {
        assertEquals(BABY, personType(Random.nextInt(0, 4)))
    }

    @Test
    @DisplayName("Verify the function return correctly when age in 4 to 17")
    fun verifyTheFunctionReturnCorrectlyWhenAgeIn4To17() {
        assertEquals(CHILDREN, personType(Random.nextInt(4, 18)))
    }

    @Test
    @DisplayName("Verify the function return correctly when age in 18 to 59")
    fun verifyTheFunctionReturnCorrectlyWhenAgeIn18To59() {
        assertEquals(ADULT, personType(Random.nextInt(18, 60)))
    }

    @Test
    @DisplayName("Verify the function return correctly when age in 60 to 150")
    fun verifyTheFunctionReturnCorrectlyWhenAgeIn60To150() {
        assertEquals(OLD, personType(Random.nextInt(60, 151)))
    }

    @Test
    @DisplayName("Verify the function return correctly when age not in 0 to 150")
    fun verifyTheFunctionReturnCorrectlyWhenAgeNotIn0To150() {
        assertEquals(ERROR_AGE, personType(-1))
        assertEquals(ERROR_AGE, personType(151))
    }

    private fun customerType(customer: CustomerType): String {
        val res: String = when (customer) {
            CustomerType.REGULAR -> REGULAR_CUSTOMER
            CustomerType.VIP -> VIP
        }
        return res
    }

    private fun personType(age: Int): String {
        return when (age) {
            0, 1, 2, 3 -> BABY
            in 4..17 -> CHILDREN
            in 18..59 -> ADULT
            in 60..150 -> OLD
            else -> ERROR_AGE
        }
    }
}

enum class CustomerType {
    REGULAR,
    VIP
}