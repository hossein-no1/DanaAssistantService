package dana.assistant.service

import android.annotation.TargetApi
import android.content.Context
import android.content.Context.RECEIVER_EXPORTED
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build

class DanaService(private val context: Context) {

    private var assistantReceiver: AssistantBroadcastReceiver? = null
    private var receiverPackageName = ""

    fun openAssistant(packageName: String, screenName: String) {
        receiverPackageName = packageName
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("app://assistant.dana.ir/?page=overlay"))
        intent.putExtra("client_package_name", receiverPackageName)
        intent.putExtra("current_screen", screenName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun registerService(callBack: AssistantCallBack) {
        assistantReceiver = AssistantBroadcastReceiver(callBack)
        val intentFilter = IntentFilter("dana.assistant.service.DETECT_COMMAND")
        context.registerReceiver(assistantReceiver, intentFilter, RECEIVER_EXPORTED)
    }

    fun unregisterService() {
        context.unregisterReceiver(assistantReceiver)
    }

}