import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TestCaseWhen {
    companion object {
        const val REGULAR_CUSTOMER = "Regular customer"
        const val VIP = "VIP"
    }

    @Test
    @DisplayName("Verify the function can return correctly when the parameter is CustomerType.REGULAR")
    fun verifyTheFunctionCanReturnCorrectlyWhenTheParameterIsCustomerTypeRegular() {
        assertEquals(REGULAR_CUSTOMER, customerType(CustomerType.REGULAR))
    }


    @Test
    @DisplayName("Verify the function can return correctly when the parameter is CustomerType.VIP")
    fun verifyTheFunctionCanReturnCorrectlyWhenTheParameterIsCustomerTypeVIP() {
        assertEquals(VIP, customerType(CustomerType.VIP))
    }


    private fun customerType(customer: CustomerType): String {
        val res: String = when (customer) {
            CustomerType.REGULAR -> REGULAR_CUSTOMER
            CustomerType.VIP -> VIP
        }
        return res
    }
}

enum class CustomerType {
    REGULAR,
    VIP
}