package tech.shiftmc.lobby

import net.minestom.server.extensions.Extension
import tech.shiftmc.lobby.modules.loadAllModules

class LobbyExtension : Extension() {
    
    companion object {
        lateinit var instance: LobbyExtension
    }
    
    override fun initialize() {
        loadAllModules()
        instance = this
    }
    
    override fun terminate() { }
}