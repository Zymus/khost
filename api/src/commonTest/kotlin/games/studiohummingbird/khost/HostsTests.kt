package games.studiohummingbird.khost

import arrow.core.some
import kotlin.test.Test
import kotlin.test.assertEquals

class HostsTests {

    @Test
    fun it_works() {
        val hostname = Hostname("localhost")
        val ipAddresses = IPAddresses(
            v4 = IPv4("127.0.0.1").some(),
            v6 = IPv6("::1").some(),
        )

        val hosts = Hosts(mapOf(
            hostname to ipAddresses
        ))

        val expected = """
            127.0.0.1 localhost
            ::1 localhost
        """.trimIndent()
        assertEquals(expected, hosts.toString())
    }
}