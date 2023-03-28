package tech.shiftmc.lobby

import net.minestom.server.extensions.Extension
import org.tinylog.kotlin.Logger

class LobbyExtension : Extension() {
    override fun initialize() {
        Logger.info { "LobbyExtension has been initialized!" }
    }
    
    override fun terminate() { }
}