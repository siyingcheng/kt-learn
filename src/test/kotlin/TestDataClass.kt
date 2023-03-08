import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TestDataClass {

    @Test
    @DisplayName("Verify data class auto generate equals correctly")
    fun verifyDataClassAutoGenerateEqualsCorrectly() {
        var user1 = User("Simon", "Si", 18)
        var user2 = User("Simon", "Si", 18)
        assertEquals(user1, user2)
    }

    @Test
    @DisplayName("Verify data class destructuring correctly")
    fun verifyDataClassDestructuringCorrectly() {
        var user = User("Simon", "Si", 18)
        var (firstName, lastName, age) = user
        assertEquals(firstName, user.component1())
        assertEquals(lastName, user.component2())
        assertEquals(age, user.component3())
    }
}

/**
 * The compiler automatically derives the following members from all properties declared in the primary constructor:
 *  - equals()/hashCode() pair
 *  - toString() of the form "User(name=John, age=42)"
 *  - componentN() functions corresponding to the properties in their order of declaration.
 *  - copy() function
 */
internal data class User(var firstName: String, var lastName: String, var age: Int)