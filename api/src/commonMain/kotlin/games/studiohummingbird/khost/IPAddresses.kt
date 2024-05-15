@file:UseSerializers(
    OptionSerializer::class,
)
package games.studiohummingbird.khost

import arrow.core.Option
import arrow.core.none
import arrow.core.serialization.OptionSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
data class IPAddresses(
    val v4: Option<IPv4> = none(),
    val v6: Option<IPv6> = none(),
) : List<IPAddress> by listOfNotNull(v4.getOrNull(), v6.getOrNull()) {
    init {
        require(v4.isSome() || v6.isSome()) { "Either a v4 or v6 IP Address is required" }
    }
}
