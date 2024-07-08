package dana.assistant.service

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri

class DanaService(private val context: Context) {

    private var assistantReceiver: AssistantBroadcastReceiver? = null

    fun openAssistant(packageName: String, screenName: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("app://assistant.dana.ir/?page=overlay"))
        intent.putExtra("client_package_name", packageName)
        intent.putExtra("current_screen", screenName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun registerService(callBack: AssistantCallBack) {
        assistantReceiver = AssistantBroadcastReceiver(callBack)
        val intentFilter = IntentFilter("dana.assistant.service")
        context.registerReceiver(assistantReceiver, intentFilter)
    }

    fun unregisterService(){
        context.unregisterReceiver(assistantReceiver)
    }

}