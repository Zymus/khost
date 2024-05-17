package games.studiohummingbird.khost

import kotlinx.serialization.Serializable

@Serializable
data class Hosts(val map: Map<Hostname, IPAddresses>) : Map<Hostname, IPAddresses> by map {

    // TODO move to serialization
    override fun toString(): String = map
        .flatMap { (hostname, addresses) -> addresses.map { hostname to it } }
        .groupBy({ it.second }) { it.first }
        .map { (address, hostnames)  -> (listOf(address.toString()) + hostnames.map(Hostname::string)).joinToString(" ") }
        .joinToString("\n")
}
