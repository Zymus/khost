package games.studiohummingbird.khost

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import java.nio.file.*
import kotlin.io.path.Path
import kotlin.io.path.isRegularFile
import kotlin.io.path.readText
import kotlin.io.path.writeText

class Khost : CliktCommand() {
    val gui by option().flag()
    val hosts by option().default("hosts")
    val profile by argument().default("")

    override fun run() {
        val osName = System.getProperty("os.name")
        println("Detected $osName")
        val userDir = Path(System.getProperty("user.dir"))
        println("Started in $userDir")

        val profilePath = userDir.resolve(Path(hosts, profile))
        if (!profilePath.isRegularFile()) {
            error("$profilePath is not a hosts file")
        }

        val hostsPath: Path = if (osName.startsWith("Windows")) {
            val systemRoot = System.getenv("SystemRoot")
            Path(systemRoot, "System32", "drivers", "etc", "hosts")
        }
        else {
            TODO("need to handle $osName")
        }

        try {
            val profileContent = profilePath.readText(Charsets.UTF_8)
            println("Read $profilePath")
            println(profileContent)
            hostsPath.writeText(profileContent, Charsets.UTF_8)
            println("Updated with profile $profile")
        }
        catch (e: AccessDeniedException) {
            println("Please run in an admin console")
            e.printStackTrace()
        }
    }
}
