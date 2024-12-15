package dana.assistant.service

import android.content.Context
import android.content.IntentFilter
import androidx.core.content.ContextCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import dana.assistant.service.Util.getDanaVersionCode
import dana.assistant.service.Util.isDanaInstalled
import dana.assistant.service.Util.openDana
import dana.assistant.service.commandhandler.CommandHandler
import dana.assistant.service.model.ClientScreenType
import dana.assistant.service.model.DanaScreenType
import dana.assistant.service.model.WakeupType

class DanaService(
    private val context: Context,
    private val callBack: CommandHandler,
) : DefaultLifecycleObserver {

    private var assistantReceiver: AssistantBroadcastReceiver? = null

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        registerService()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        unregisterService()
    }

    fun openAssistant(
        screenName: ClientScreenType = ClientScreenType.Home,
        wakeupType: WakeupType = WakeupType.Microphone,
    ) {

        if (context.isDanaInstalled()) {
            openDana(
                context = context,
                danaScreenType = DanaScreenType.Overlay,
                screenType = screenName,
                wakeupType = wakeupType
            )
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }

    }

    fun openExplorer(
        screenName: ClientScreenType = ClientScreenType.Home,
    ) {

        if (context.isDanaInstalled()) {
            openDana(
                context = context,
                danaScreenType = DanaScreenType.Explorer,
                screenType = screenName
            )
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }

    }

    private fun registerService() {
        assistantReceiver = AssistantBroadcastReceiver(callBack)
        val intentFilter = IntentFilter("dana.assistant.service.DETECT_COMMAND")
        ContextCompat.registerReceiver(
            context,
            assistantReceiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )
    }

    private fun unregisterService() {
        context.unregisterReceiver(assistantReceiver)
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