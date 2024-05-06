package games.studiohummingbird.khost

val asciiRanges = listOf(
    'a'..'z',
    '0'..'9',
    '-'.range,
    '_'.range,
)

val hostnameRange: List<Char> = asciiRanges.flatten()

inline fun String.inHostnameRange(): Boolean =
    all(hostnameRange::contains)

data class Hostname(
    val string: String
) {
    init {
        require(string.length <= 253) { "Hostnames have a max length of 253 ASCII bytes" }
        val localParts = string.split('.')
        require(localParts.all { it.length in 1..63 }) { "Hostnames have a max local part length of 63 ASCII bytes" }
        require(localParts.all(String::inHostnameRange)) { "Hostnames only contain characters from $asciiRanges" }
    }

    override fun toString(): String = string
}

inline fun ByteArray.indicesOf(value: Byte): List<Int> =
    mapIndexed { index, byte -> index.takeIf { byte == value } }.filterNotNull()
