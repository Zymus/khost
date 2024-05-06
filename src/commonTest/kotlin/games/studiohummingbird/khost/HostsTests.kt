package games.studiohummingbird.khost

import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertEquals

class HostsTests {

    @Test
    fun `it works`() {
        val hostname = Hostname("localhost")
        val ipAddresses = IPAddresses(
            v4 = ipv4("127.0.0.1"),
            v6 = ipv6("::1"),
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