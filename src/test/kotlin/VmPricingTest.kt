import org.junit.Test
import kotlin.test.assertEquals

class VmPricingTest {

    @Test
    fun `when given a middle instance returns result`() {
        assertEquals("2.0", interpolate(5, arrayOf(2, 8, 11), arrayOf(1.0f, 3.0f, 5.0f)))
    }

    @Test
    fun `when given a small instance returns result`() {
        assertEquals("2.0", interpolate(2, arrayOf(5, 11, 17), arrayOf(3.0f, 5.0f, 7.0f)))
    }

    @Test
    fun `when given a large instance returns result`() {
        assertEquals("9.0", interpolate(23, arrayOf(5, 11, 17), arrayOf(3.0f, 5.0f, 7.0f)))
    }

    @Test
    fun `when given a middle instance with zero prices returns result`() {
        assertEquals("2.0", interpolate(5, arrayOf(2, 4, 8, 10, 11), arrayOf(1.0f, 0.0f, 3.0f, 0.0f, 5.0f)))
    }
}
