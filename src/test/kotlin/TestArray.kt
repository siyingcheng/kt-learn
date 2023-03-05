import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class TestArray {
    private lateinit var array: Array<String>

    @BeforeEach
    fun beforeEach() {
        array = arrayOf("Simon", "Owen", "Amy")
    }

    @Test
    @DisplayName("Verify array initialize correctly")
    fun verifyArrayInitializeCorrectly() {
        assertEquals(3, array.size)
        assertEquals("Simon", array[0])
        assertEquals("Amy", array[2])
    }

    @Test
    @DisplayName("Verify out of bound exception when retrieve an out of bound index of array")
    fun verifyOutOfBoundExceptionWhenRetrieveAnOutOfBoundIndexOfArray() {
        assertThrows<IndexOutOfBoundsException> { array[3] }
    }

    @Test
    @DisplayName("Verify element of array could be anything what implemented comparable and serializable")
    fun verifyElementOfArrayCouldBeAnythingWhatImplementedComparableAndSerializable() {
        var mixElements = arrayOf("Simon", 18, 'M')
        assertEquals("Simon", mixElements[0])
        assertEquals(18, mixElements[1])
        assertEquals('M', mixElements[2])
    }

}