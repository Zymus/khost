package games.studiohummingbird.khost

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class IPv4(
    override val address: String
) : IPAddress {
    init {
        val parts = address.split(".")
        require(parts.size == 4) { "IPv4 addresses have 4 parts: $address" }
        require(parts.all { it.toUByteOrNull(10) != null }) { "IPv4 parts must be number in range 0..255: $address" }
    }

    override fun toString(): String = address
}
