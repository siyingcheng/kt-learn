import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

internal class TestLoop {
    @Test
    @DisplayName("Verify from-to loop should contain both sides")
    fun verifyFromToLoopShouldContainBothSides() {
        var list = getFromToList(1, 10)
        assert(list.contains(1))
        assert(list.contains(10))
    }

    @Test
    @DisplayName("Verify from-until loop should not contain last element in right side")
    fun verifyFromUntilLoopShouldNotContainLastElementInRightSide() {
        var list = getFromUntilList(1, 10)
        assert(list.contains(1))
        assertFalse(list.contains(10))
    }

    @Test
    @DisplayName("Verify from-downTo loop should contain both sides")
    fun verifyFromDownToLoopShouldContainBothSides() {
        var list = getFormDownToList(10, 1)
        assertEquals(10, list.first())
        assertEquals(1, list.last())
    }

    private fun getFormDownToList(from: Int, downTo: Int): ArrayList<Int> {
        val res = ArrayList<Int>()
        for (i in from downTo downTo) {
            res.add(i)
        }
        return res
    }

    private fun getFromUntilList(from: Int, until: Int): ArrayList<Int> {
        val res = ArrayList<Int>()
        for (i in from until until) {
            res.add(i)
        }
        return res
    }

    private fun getFromToList(from: Int, to: Int): ArrayList<Int> {
        val res = ArrayList<Int>()
        for (i in from..to) {
            res.add(i)
        }
        return res
    }
}