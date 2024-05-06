package games.studiohummingbird.khost

data class IPAddresses(
    val v4: IPv4Address? = null,
    val v6: IPv6Address? = null,
) : List<IPAddress> by listOfNotNull(v4, v6) {
    init {
        require(v4 != null || v6 != null) { "Either a v4 or v6 IP Address is required" }
    }
}
