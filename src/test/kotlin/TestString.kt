import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

internal class TestString {

    @Test
    @DisplayName("Verify string initialize correctly")
    fun verifyStringInitializeCorrectly() {
        var text: String? = null
        assertNull(text)

        var anotherText = text ?: "This is another string"
        assertEquals(anotherText, "This is another string")

        text = "This is a string"
        assertNotNull(text)

        anotherText = text ?: "This is another string"
        assertEquals(anotherText, "This is a string")
    }
}