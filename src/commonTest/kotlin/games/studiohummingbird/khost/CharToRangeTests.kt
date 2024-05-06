package games.studiohummingbird.khost

import kotlin.test.Test
import kotlin.test.assertEquals

class CharToRangeTests {
    @Test
    fun `toRange creates a range with a single value`() {
        val range = 'Z'.range
        assertEquals('Z', range.first)
        assertEquals('Z', range.last)
    }
}