package games.studiohummingbird.khost

import kotlin.test.Test

class HostnameTests {

    @Test
    fun `letters are permitted`() {
        Hostname("localhost")
    }

    @Test
    fun `multiple parts are permitted`() {
        Hostname("localhost.dev")
    }
}
