package games.studiohummingbird.khost

import kotlin.test.Test

class IPAddressesTests {

    @Test
    fun `only IPv4`() {
        IPAddresses(
            v4 = IPv4Address("1.1.1.1")
        )
    }

    @Test
    fun `only IPv6`() {
        IPAddresses(
            v6 = IPv6Address("TODO")
        )
    }

    @Test
    fun `both`() {
        IPAddresses(
            v4 = IPv4Address("1.1.1.1"),
            v6 = IPv6Address("TODO")
        )
    }
}