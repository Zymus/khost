package games.studiohummingbird.khost

data class Hosts(val map: Map<Hostname, IPAddresses>) : Map<Hostname, IPAddresses> by map {
    override fun toString(): String = map
        .flatMap { (hostname, addresses) -> addresses.map { hostname to it} }
        .groupBy({ it.second }) { it.first }
        .map { (address, hostnames)  -> (listOf(address.string) + hostnames.map(Hostname::string)).joinToString(" ") }
        .joinToString("\n")
}
