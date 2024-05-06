package games.studiohummingbird.khost

data class IPv6Address(
    override val string: String
) : IPAddress {

    // TODO

    override fun toString(): String = string
}

fun ipv6(string: String) = IPv6Address(string)