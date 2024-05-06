package games.studiohummingbird.khost

data class IPv4Address(
    override val string: String
) : IPAddress {
    init {
        val parts = string.split(".")
        require(parts.size == 4) { "IPv4 addresses have 4 parts: $string" }
        require(parts.all { it.toUByteOrNull(10) != null }) { "IPv4 parts must be number in range 0..255: $string" }
    }

    override fun toString(): String = string
}

fun ipv4(string: String) = IPv4Address(string)
