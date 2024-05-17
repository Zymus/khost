package games.studiohummingbird.khost.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class HostsSerializer : KSerializer<Any> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("hosts") {
        
    }

    override fun deserialize(decoder: Decoder): Any {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: Any) {
        TODO("Not yet implemented")
    }
}