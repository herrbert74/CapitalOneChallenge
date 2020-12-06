import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ArrayRotationGameTest {

    @Test
    fun `too many hashes raise exception`() {
        assertTrue(
            getMaxElementIndexesQuicker(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 3, 4)) contentEquals  arrayOf( 2, 1, 0, 3)
        )
    }

}