package dana.assistant.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dana.assistant.service.model.parseCommand

internal class AssistantBroadcastReceiver(private val callBack: AssistantCallBack) :
    BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val command = intent?.data?.getQueryParameter("command")
            ?: intent?.getStringExtra("command") ?: ""

        val values = intent?.data?.getQueryParameters("values")
            ?: intent?.getStringArrayListExtra("values") ?: arrayListOf<String>()

        callBack.onReceiveCommand(
            commandType = parseCommand(command = command),
            values = values.toList()
        )
    }

}