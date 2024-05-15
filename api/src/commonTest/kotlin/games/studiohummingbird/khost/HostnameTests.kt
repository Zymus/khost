package games.studiohummingbird.khost

import kotlin.test.Test

class HostnameTests {

    @Test
    fun letters_are_permitted() {
        Hostname("localhost")
    }

    @Test
    fun multiple_parts_are_permitted() {
        Hostname("localhost.dev")
    }
}
