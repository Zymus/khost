package games.studiohummingbird.khost

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

val hostnameRange: List<Char> = ('a'..'z') + ('0'..'9') + '-'

fun String.inHostnameRange(): Boolean =
    all(hostnameRange::contains)

@JvmInline
@Serializable
value class Hostname(
    val string: String
) {
    init {
        require(string.length <= 253) { "Hostnames have a max length of 253 ASCII bytes" }
        val localParts = string.split('.')
        require(localParts.all { it.length in 1..63 }) { "Hostnames have a max local part length of 63 ASCII bytes" }
        require(localParts.all(String::inHostnameRange)) { "Hostnames only contain characters from $hostnameRange" }
    }

    override fun toString(): String = string
}

fun ByteArray.indicesOf(value: Byte): List<Int> =
    toTypedArray().mapIndexedNotNull { index, byte -> index.takeIf { byte == value } }
