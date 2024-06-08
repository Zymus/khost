package games.studiohummingbird.khost

actual interface Platform {
    actual suspend fun readHosts(): Result<Hosts>
}