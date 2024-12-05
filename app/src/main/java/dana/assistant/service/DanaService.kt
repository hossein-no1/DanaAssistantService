package dana.assistant.service

import android.content.Context
import android.content.IntentFilter
import androidx.core.content.ContextCompat
import dana.assistant.service.Util.getDanaVersionCode
import dana.assistant.service.Util.isDanaInstalled
import dana.assistant.service.Util.openDana
import dana.assistant.service.model.ClientScreenType
import dana.assistant.service.model.ClientType
import dana.assistant.service.model.DanaScreenType
import dana.assistant.service.model.WakeupType


class DanaService(private val context: Context) {

    private var assistantReceiver: AssistantBroadcastReceiver? = null

    fun openAssistant(
        packageName: ClientType = ClientType.Launcher,
        screenName: ClientScreenType = ClientScreenType.Home,
        wakeupType: WakeupType = WakeupType.Microphone
    ) {

        if (context.isDanaInstalled()) {
            openDana(
                context = context,
                danaScreenType = DanaScreenType.Overlay,
                clientType = packageName,
                screenType = screenName,
                wakeupType = wakeupType
            )
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }

    }

    fun openExplorer(
        packageName: ClientType = ClientType.Launcher,
        screenName: ClientScreenType = ClientScreenType.Home
    ) {

        if (context.isDanaInstalled()) {
            openDana(
                context = context,
                danaScreenType = DanaScreenType.Explorer,
                clientType = packageName,
                screenType = screenName
            )
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }

    }

    fun registerService(callBack: AssistantCallBack) {
        assistantReceiver = AssistantBroadcastReceiver(callBack)
        val intentFilter = IntentFilter("dana.assistant.service.DETECT_COMMAND")
        ContextCompat.registerReceiver(
            context,
            assistantReceiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )
    }

    fun unregisterService() {
        context.unregisterReceiver(assistantReceiver)
    }

    fun isDanaInstalled() = context.isDanaInstalled()

    fun getDanaVersionCode() = context.getDanaVersionCode()

    fun isDanaSupportedOnDevice() = Util.isDanaSupportedOnDevice()

    fun isDanaSupportedOnDevice(screenType: ClientScreenType) =
        Util.isDanaSupportedOnDevice() && Util.isDanaSupportedOnClientScreen(
            context = context,
            screenType = screenType
        )

}