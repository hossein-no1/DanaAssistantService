package dana.assistant.service

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.core.content.ContextCompat
import dana.assistant.service.commandhandler.CommandHandler
import dana.assistant.service.model.ClientScreenType
import dana.assistant.service.model.DanaScreenType
import dana.assistant.service.model.WakeupType
import dana.assistant.service.model.parseClient

internal object Util {

    private const val DANA_PACKAGE_NAME = "ir.huma.voiceassistant"
    private const val VOICE_RECEIVER_ACTION = "ir.huma.action.newVoiceSearch"
    private const val LAST_DANA_VERSION_AFTER_REFACTOR = 63
    private val notSupportedAssistantDevices = listOf("R1")

    fun Context.isDanaInstalled(): Boolean {
        try {
            packageManager.getPackageInfo(packageName = DANA_PACKAGE_NAME)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
    }

    fun Context.getDanaVersionCode(): Long {
        if (!isDanaInstalled()) return -1

        val danaInfo = packageManager.getPackageInfo(packageName = DANA_PACKAGE_NAME)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) danaInfo.longVersionCode else danaInfo.versionCode.toLong()
    }

    fun isDanaSupportedOnDevice(): Boolean {
        notSupportedAssistantDevices.forEach { model ->
            if (Build.MODEL.contains(model))
                return false
        }
        return true
    }

    fun isDanaSupportedOnClientScreen(context: Context, listenerType: CommandHandler): Boolean =
        parseClient(context.packageName).isDanaSupported(
            danaVersion = context.getDanaVersionCode(),
            type = listenerType
        )

    private fun PackageManager.getPackageInfo(packageName: String): PackageInfo =
        getPackageInfo(packageName, 0)

    private fun Context.openAppWithoutLauncher(
        packageName: String,
        activityName: String,
    ): Boolean {
        return try {
            val intent = Intent(Intent.ACTION_MAIN).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                setClassName(packageName, activityName)
            }
            startActivity(intent)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun openDanaByMicrophone(
        context: Context,
        danaScreenType: DanaScreenType,
        screenType: ClientScreenType = ClientScreenType.HOME,
        wakeupType: WakeupType = WakeupType.MICROPHONE,
    ) {
        if (context.getDanaVersionCode() >= LAST_DANA_VERSION_AFTER_REFACTOR)
            openDanaNewWay(
                context = context,
                danaScreenType = danaScreenType,
                screenType = screenType,
                wakeupType = wakeupType
            )
        else
            openDanaOldWay(
                context = context,
                danaScreenType = danaScreenType
            )
    }

    private fun openDanaNewWay(
        context: Context,
        danaScreenType: DanaScreenType,
        screenType: ClientScreenType,
        wakeupType: WakeupType,
    ) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("app://assistant.dana.ir/?page=${danaScreenType.value}")
        )
        intent.putExtra("client_package_name", context.packageName)
        intent.putExtra("current_screen", screenType.screen)
        intent.putExtra("wakeup_type", wakeupType.way)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun openDanaOldWay(context: Context, danaScreenType: DanaScreenType) {
        context.openAppWithoutLauncher(
            packageName = DANA_PACKAGE_NAME,
            activityName = danaScreenType.activityName
        )
    }

    fun DanaService.registerService() {
        val intentFilter = IntentFilter("dana.assistant.service.DETECT_COMMAND")
        ContextCompat.registerReceiver(
            context,
            assistantReceiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )
    }

    fun DanaService.unregisterService() {
        context.unregisterReceiver(assistantReceiver)
    }

    fun DanaService.registerMicReceiver() {
        ContextCompat.registerReceiver(
            context,
            micReceiver,
            IntentFilter(VOICE_RECEIVER_ACTION),
            ContextCompat.RECEIVER_EXPORTED,
        )
    }

    fun DanaService.unregisterMicReceiver() {
        context.unregisterReceiver(micReceiver)
    }

    fun DanaService.openDanaByMicrophone(
        clientScreenType: ClientScreenType,
        onOpened: () -> Unit,
    ) {
        if (context.isDanaInstalled()) {
            openDanaByMicrophone(
                context = context,
                danaScreenType = DanaScreenType.OVERLAY,
                screenType = clientScreenType,
                wakeupType = WakeupType.MICROPHONE
            )
            onOpened()
        } else {
            throw AssistantException(message = "Dana is not installed on your device!")
        }
    }

}