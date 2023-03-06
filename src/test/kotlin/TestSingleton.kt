import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class TestSingleton {

    @Test
    @DisplayName("Verify create two object of singleton class, they are same object")
    fun verifyCrateTwoObjectOfSingletonClassTheyAreSameObject() {
        var obj1 = ASingleton.getInstance()
        var obj2 = ASingleton.getInstance()
        assertNotNull(obj1)
        assertNotNull(obj2)
        assertEquals(obj1, obj2)
        assertEquals(obj1.hashCode(), obj2.hashCode())
        assertEquals(obj1.toString(), obj2.toString())
    }

    @Test
    @DisplayName("Verify object type just initialize once")
    fun verifyObjectTypeJustInitializeOnce() {
        assertEquals(BSingleton, BSingleton)
        assertEquals(BSingleton.hashCode(), BSingleton.hashCode())
        assertEquals(1, BSingleton.objectInitTimes())
        assertEquals(1, BSingleton.objectInitTimes())
    }
}

private object BSingleton {
    private var initTimes = 0

    init {
        println("The object BSingleton initializing")
        initTimes++
    }

    fun objectInitTimes(): Int {
        return initTimes;
    }
}

internal class ASingleton private constructor() {
    companion object {
        private var instance: ASingleton? = null

        fun getInstance(): ASingleton? {
            if (instance == null) {
                instance = ASingleton()
            }
            return instance;
        }
    }
}