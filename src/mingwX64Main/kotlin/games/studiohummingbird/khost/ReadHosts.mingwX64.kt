package games.studiohummingbird.khost

import platform.posix.fopen

actual fun interface ReadHosts {
    actual operator fun invoke()
}

object MingwX64