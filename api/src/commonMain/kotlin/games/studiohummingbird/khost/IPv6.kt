package games.studiohummingbird.khost

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class IPv6(
    override val address: String
) : IPAddress {
    override fun toString(): String = address
}
