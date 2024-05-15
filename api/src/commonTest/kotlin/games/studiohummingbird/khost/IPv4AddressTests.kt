package games.studiohummingbird.khost

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class IPv4AddressTests {

    @Test
    fun addresses_must_have_4_parts() {
        val parts = (1..4).map { "1" }
        val addressString = parts.joinToString(".")
        assertEquals("1.1.1.1",  IPv4(addressString).address)
    }

    @Test
    fun addresses_cannot_have_fewer_than_4_parts() {
        val parts = (1..3).map { "1" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4(addressString)
        }
    }

    @Test
    fun addresses_cannot_have_more_than_4_parts() {
        val parts = (1..5).map { "1" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4(addressString)
        }
    }

    @Test
    fun address_parts_have_a_minimum_of_0() {
        val parts = (1..4).map { "0" }
        val addressString = parts.joinToString(".")
        IPv4(addressString)
    }

    @Test
    fun address_parts_have_a_maximum_of_255() {
        val parts = (1..4).map { "255" }
        val addressString = parts.joinToString(".")
        IPv4(addressString)
    }

    @Test
    fun address_parts_cannot_exceed_minimum() {
        val parts = (1..4).map { "-1" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4(addressString)
        }
    }

    @Test
    fun address_parts_cannot_exceed_maximum() {
        val parts = (1..4).map { "256" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4(addressString)
        }
    }

    @Test
    fun address_parts_must_be_numbers() {
        val parts = (1..4).map { "a" }
        val addressString = parts.joinToString(".")
        assertFailsWith<IllegalArgumentException> {
            IPv4(addressString)
        }
    }
}