package dana.assistant.service

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import dana.assistant.service.model.ClientScreenType
import dana.assistant.service.model.ClientType
import dana.assistant.service.model.DanaScreenType
import dana.assistant.service.model.WakeupType

internal object Util {

    private const val DANA_PACKAGE_NAME = "ir.huma.voiceassistant"
    private const val LAST_DANA_VERSION_AFTER_REFACTOR = 63

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

    private fun PackageManager.getPackageInfo(packageName: String): PackageInfo =
        getPackageInfo(packageName, 0)

    private fun Context.openAppWithoutLauncher(
        packageName: String,
        activityName: String
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

    fun openDana(
        context: Context,
        danaScreenType: DanaScreenType,
        clientType: ClientType = ClientType.Launcher,
        screenType: ClientScreenType = ClientScreenType.Home,
        wakeupType: WakeupType = WakeupType.Microphone
    ) {
        if (context.getDanaVersionCode() >= LAST_DANA_VERSION_AFTER_REFACTOR)
            openDanaNewWay(
                context = context,
                danaScreenType = danaScreenType,
                clientType = clientType,
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
        clientType: ClientType,
        screenType: ClientScreenType,
        wakeupType: WakeupType
    ) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("app://assistant.dana.ir/?page=${danaScreenType.value}")
        )
        intent.putExtra("client_package_name", clientType.packageName)
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

}