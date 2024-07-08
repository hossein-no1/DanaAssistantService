package dana.assistant.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

internal class AssistantBroadcastReceiver(private val callBack: AssistantCallBack) :
    BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val command = intent?.getStringExtra("command") ?: ""
        val value = intent?.getStringExtra("value") ?: ""
        callBack.onReceiveCommand(
            commandType = parseCommand(command = command),
            value = value
        )
    }

    private fun parseCommand(command: String) = when (command) {
        "VolumeUp" -> CommandType.VolumeUp
        "VolumeDown" -> CommandType.VolumeDown
        "MediaPause" -> CommandType.MediaPause
        "MediaStop" -> CommandType.MediaStop
        "MediaNext" -> CommandType.MediaNext
        "MediaPrevious" -> CommandType.MediaPrevious
        "MediaRewind" -> CommandType.MediaRewind
        "MediaFastForward" -> CommandType.MediaFastForward
        "MediaAudioTrack" -> CommandType.MediaAudioTrack
        "ChangeMediaPosition" -> CommandType.ChangeMediaPosition
        "ChangeMediaQuality" -> CommandType.ChangeMediaQuality
        "ChangeMediaSubtitle" -> CommandType.ChangeMediaSubtitle
        "ChangeSubtitleSize" -> CommandType.ChangeSubtitleSize
        else -> CommandType.Unknown
    }
}