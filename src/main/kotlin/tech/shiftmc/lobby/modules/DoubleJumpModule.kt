package tech.shiftmc.lobby.modules

import com.github.shynixn.mccoroutine.minestom.launch
import kotlinx.coroutines.delay
import net.kyori.adventure.sound.Sound
import net.minestom.server.MinecraftServer
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerStartFlyingEvent
import net.minestom.server.sound.SoundEvent
import tech.shiftmc.lobby.LobbyExtension

class DoubleJumpModule : Module {
    override fun start() {
        val globalEventHandler = MinecraftServer.getGlobalEventHandler()

        // Enable flight on login
        globalEventHandler.addListener(PlayerLoginEvent::class.java) { event: PlayerLoginEvent -> LobbyExtension.instance.launch {
            event.player.isAllowFlying = true
        }}
        
        // On flight toggle, disable then push the player
        globalEventHandler.addListener(PlayerStartFlyingEvent::class.java) { event: PlayerStartFlyingEvent -> LobbyExtension.instance.launch {
            val player = event.player
            
            player.isAllowFlying = false
            player.isFlying = false
            player.velocity = event.player.position.direction().mul(30.0)
            player.playSound(Sound.sound(SoundEvent.ENTITY_BAT_TAKEOFF, Sound.Source.RECORD, 1f, 1f))
    
            delay(2000)
            
            player.playSound(Sound.sound(SoundEvent.BLOCK_NOTE_BLOCK_PLING, Sound.Source.RECORD, 1f, 1f));
            player.isAllowFlying = true
        }}
    }
}