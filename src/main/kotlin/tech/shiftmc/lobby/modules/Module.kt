package tech.shiftmc.lobby.modules

import org.tinylog.kotlin.Logger

internal interface Module {
    fun start()
}

fun loadAllModules() {
    val modules = listOf(
        DoubleJumpModule(),
    )
    
    modules.forEach {
        it.start()
        Logger.info { "Loaded module ${it::class.simpleName}" }
    }
}