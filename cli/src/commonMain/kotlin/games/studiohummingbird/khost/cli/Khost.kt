package games.studiohummingbird.khost.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Khost : CliktCommand() {
    private val action by argument().default("show")

    private val scope = MainScope()

    override fun run() {
        scope.launch {
            when (action) {
                "show" -> println(readHosts())
                else -> TODO("unknown action $action")
            }
        }
    }
}
