package games.studiohummingbird.khost

import kotlin.test.Test
import kotlin.test.assertEquals

class ByteArrayIndicesOfTests {

    @Test
    fun returns_all_indices_of_the_given_value() {
        val byteArray = byteArrayOf(
            1, 0, 1
        )

        val indicesOfZero = byteArray.indicesOf(0)
        assertEquals(1, indicesOfZero.size)
        assertEquals(1, indicesOfZero[0])

        val indicesOfOne = byteArray.indicesOf(1)
        assertEquals(2, indicesOfOne.size)
        assertEquals(0, indicesOfOne.first())
        assertEquals(2, indicesOfOne.last())

        val indicesOfTwo = byteArray.indicesOf(2)
        assertEquals(0, indicesOfTwo.size)
    }
}