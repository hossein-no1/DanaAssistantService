package dana.assistant.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import dana.assistant.service.Util.getDanaVersionCode
import dana.assistant.service.Util.isDanaInstalled
import dana.assistant.service.Util.openDanaByMicrophone
import dana.assistant.service.Util.registerMicReceiver
import dana.assistant.service.Util.registerService
import dana.assistant.service.Util.unregisterMicReceiver
import dana.assistant.service.Util.unregisterService
import dana.assistant.service.commandhandler.CommandHandler
import dana.assistant.service.model.ClientScreenType
import dana.assistant.service.model.DanaScreenType
import dana.assistant.service.model.WakeupType

class DanaService(
    val context: Context,
) : DefaultLifecycleObserver {

    internal var assistantReceiver: AssistantBroadcastReceiver? = null

    internal lateinit var micReceiver: BroadcastReceiver

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        registerService()
        registerMicReceiver()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        unregisterService()
        unregisterMicReceiver()
    }

    fun setupMicReceiver(
        screenName: ClientScreenType = ClientScreenType.Home,
        onOpened: () -> Unit = {}
    ) {
        micReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                openDanaByMicrophone(
                    clientScreenType = screenName,
                    onOpened = onOpened,
                )
            }
        }
    }

    fun openAssistant(
        screenName: ClientScreenType = ClientScreenType.Home,
        onOpened: () -> Unit = {},
    ) {
        if (context.isDanaInstalled()) {
            openDanaByMicrophone(
                context = context,
                danaScreenType = DanaScreenType.Overlay,
                screenType = screenName,
                wakeupType = WakeupType.ClickOnObject
            )
            onOpened()
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }

    }

    fun openExplorer(
        screenName: ClientScreenType = ClientScreenType.Home,
        onOpened: () -> Unit = {},
    ) {

        if (context.isDanaInstalled()) {
            openDanaByMicrophone(
                context = context,
                danaScreenType = DanaScreenType.Explorer,
                screenType = screenName,
                wakeupType = WakeupType.ClickOnObject
            )
            onOpened()
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }

    }

    fun registerCommandHandler(commandHandler: CommandHandler) {
        assistantReceiver = AssistantBroadcastReceiver(commandHandler)
    }

    fun isDanaInstalled() = context.isDanaInstalled()

    fun getDanaVersionCode() = context.getDanaVersionCode()

    fun isDanaSupportedOnDevice() = Util.isDanaSupportedOnDevice()

    fun isDanaSupportedInScreen(screenType: ClientScreenType) =
        Util.isDanaSupportedOnClientScreen(
            context = context,
            screenType = screenType,
        )

}