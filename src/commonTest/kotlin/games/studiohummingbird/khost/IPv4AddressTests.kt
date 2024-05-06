package games.studiohummingbird.khost

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class IPv4AddressTests {

    @Test
    fun `addresses must have 4 parts`() {
        val parts = (1..4).map { "1" }
        val addressString = parts.joinToString(".")
        assertEquals("2.6.9.5",  IPv4Address(addressString).string)
    }

    @Test
    fun `addresses cannot have fewer than 4 parts`() {
        val parts = (1..3).map { "1" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4Address(addressString)
        }
    }

    @Test
    fun `addresses cannot have more than 4 parts`() {
        val parts = (1..5).map { "1" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4Address(addressString)
        }
    }

    @Test
    fun `address parts have a minimum of 0`() {
        val parts = (1..4).map { "0" }
        val addressString = parts.joinToString(".")
        IPv4Address(addressString)
    }

    @Test
    fun `address parts have a maximum of 255`() {
        val parts = (1..4).map { "255" }
        val addressString = parts.joinToString(".")
        IPv4Address(addressString)
    }

    @Test
    fun `address parts cannot exceed minimum`() {
        val parts = (1..4).map { "-1" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4Address(addressString)
        }
    }

    @Test
    fun `address parts cannot exceed maximum`() {
        val parts = (1..4).map { "256" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4Address(addressString)
        }
    }

    @Test
    fun `address parts must be numbers`() {
        val parts = (1..4).map { "a" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4Address(addressString)
        }
    }
}