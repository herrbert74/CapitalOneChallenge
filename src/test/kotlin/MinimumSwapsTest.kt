import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MinimumSwapsTest {

    @Test
    fun `when given arrays then returns valid results`() {
        assertEquals(1, minimumSwaps(arrayOf(1, 2, 3)))
        assertEquals(1, minimumSwaps(arrayOf(4, 1, 2, 3)))
        assertEquals(2, minimumSwaps(arrayOf(1, 2, 3, 4)))
    }
}
