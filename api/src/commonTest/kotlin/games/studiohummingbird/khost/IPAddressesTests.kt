package games.studiohummingbird.khost

import arrow.core.some
import kotlin.test.Test

class IPAddressesTests {

    @Test
    fun only_IPv4() {
        IPAddresses(
            v4 = IPv4("1.1.1.1").some()
        )
    }

    @Test
    fun only_IPv6() {
        IPAddresses(
            v6 = IPv6("TODO").some()
        )
    }

    @Test
    fun both() {
        IPAddresses(
            v4 = IPv4("1.1.1.1").some(),
            v6 = IPv6("TODO").some()
        )
    }
}