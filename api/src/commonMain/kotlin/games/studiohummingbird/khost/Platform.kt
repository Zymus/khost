package games.studiohummingbird.khost

expect interface Platform {

    suspend fun readHosts(): Result<Hosts>
}
