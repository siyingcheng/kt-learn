import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


internal class TestClass {

    @Test
    @DisplayName("Verify class initialized correctly")
    fun verifyClassInitializedCorrectly() {
        var name = "Simon"
        var age = 18
        var user = User(name, age)
        assertEquals(name, user.name)
        assertEquals(age, user.age)
        assertEquals("name='$name', age=$age", user.toString())
        assertFalse(user.isVip)

        name = "Amy"
        age = 0
        val amy = User("Amy")
        assertEquals(name, amy.name)
        assertEquals(age, amy.age)
        assertEquals("name='$name', age=$age", amy.toString())
        assertFalse(amy.isVip)

        name = "VIP_Owen"
        age = 20
        var owen = User(name, age)
        assertEquals("Owen", owen.name)
        assertTrue { owen.isVip }
    }

    @Test
    @DisplayName("Verify field can defined when create class with parameters")
    fun verifyFieldCanDefinedWhenCreateClassWithParameters() {
        var simon = Student("Simon", "Si", 18)
        assertEquals("Simon", simon.firstName)
        assertEquals("Si", simon.lastName)
        assertEquals(18, simon.age)

        var amy = Student("Amy", "Cao")
        assertEquals(0, amy.age)
    }

    @Test
    @DisplayName("Verify retrieve late-init field should got exception when the field not initialize")
    fun verifyRetrieveLateInitFieldShouldGotExceptionWhenTheFieldNotInitialize() {
        var simon = Student("Simon", "Si", 18)
        assertThrows<UninitializedPropertyAccessException> { simon.favoriteGame }

        simon.favoriteGame = "3 idiots"
        assertEquals("3 idiots", simon.favoriteGame)
    }

    @Test
    @DisplayName("Verify field can override by get() and set()")
    fun verifyFieldCanOverrideByGetAndSet() {
        var simon = UserInfo("Simon", "Si", 18)
        // override get()
        assertEquals("Fist Name: Simon", simon.firstName)

        // override set(...)
        simon.firstName = "Simon"
        assertEquals("Fist Name: SIMON", simon.firstName)
    }

    @Test
    @DisplayName("Verify the object create by lazy initializing should not start before the object has been use")
    fun verifyTheObjectCreateByLazyInitializingShouldNotStartBeforeTheObjectHasBeenUse() {
        Student.resetInitTimes()

        // Initializing start when a regular object creating
        Student("Amy", "Cao", 20)
        assertEquals(1, Student.initTimes)

        val simon: Student by lazy {
            Student("Simon", "Si", 20)
        }
        // The object `simon` create by lazy, so it's not initializing yet
        assertEquals(1, Student.initTimes)
        simon.favoriteGame = "3 idiots" // The object will initialize before use
        assertEquals(2, Student.initTimes)
    }

    private class UserInfo(firstName: String, lastName: String, age: Int = 0) {
        var firstName: String = firstName
            get() {
                return "Fist Name: $field"
            }
            set(value) {
                field = value.uppercase()
            }
    }

    private class Student(var firstName: String, var lastName: String, var age: Int = 0) {
        lateinit var favoriteGame: String

        companion object {
            var initTimes: Int = 0

            fun resetInitTimes() {
                initTimes = 0
            }
        }

        init {
            initTimes++
        }
    }

    private class User(name: String, age: Int) {
        var name: String
        var age: Int = age
        var isVip: Boolean = false

        private val vipPrefix = "vip_"

        init {
            if (name.lowercase().startsWith(vipPrefix)) {
                this.name = name.substring(vipPrefix.length)
                this.isVip = true
            } else {
                this.name = name
            }
        }

        // Add a constructor with the parameter - name, set age with 0 as default
        constructor(name: String) : this(name, 0)

        override fun toString(): String {
            return "name='$name', age=$age"
        }
    }
}