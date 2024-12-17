package dana.assistant.service

import android.annotation.SuppressLint
import android.app.Application
import androidx.core.app.ComponentActivity
import dana.assistant.service.commandhandler.PlayerCommandHandler

@SuppressLint("RestrictedApi")
fun main() {
    val danaService = DanaService(context = Application())

    danaService.registerCommandHandler(
        commandHandler = object : PlayerCommandHandler {
            override fun onMediaPlay() {
                println("onMediaPlay")
            }

            override fun onMediaPause() {
                println("onMediaPause")
            }

            override fun onMediaRewind(amount: Int) {
                println("onMediaRewind")
            }
        }
    )
    danaService.setupMicReceiver {  }

    val lifecycleOwner = ComponentActivity()

    lifecycleOwner.lifecycle.addObserver(danaService)
}
