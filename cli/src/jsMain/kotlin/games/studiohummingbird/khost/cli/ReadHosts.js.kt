package games.studiohummingbird.khost.cli

import node.buffer.BufferEncoding.Companion.utf8
import node.fs.readFile
import node.process.Platform.Companion.win32
import node.process.process

actual suspend fun readHosts(): String {
    val hostsfile = when (process.platform) {
        win32 -> "C:/Windows/System32/drivers/etc/hosts"
        else -> "/etc/hosts"
    }
    return readFile(hostsfile, utf8)
}
