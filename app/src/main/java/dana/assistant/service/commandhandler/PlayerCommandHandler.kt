package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType

interface PlayerCommandHandler : CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        super.onReceiveCommand(commandType, values)
        when (commandType) {
            CommandType.MEDIA_PLAY -> onMediaPlay()
            CommandType.MEDIA_PAUSE -> onMediaPause()
            CommandType.MEDIA_REWIND -> onMediaRewind(amount = values[0].toInt())
            CommandType.MEDIA_FAST_FORWARD -> onMediaFastForward(amount = values[0].toInt())
            CommandType.MEDIA_AUDIO_TRACK -> onMediaAudioTrack()
            CommandType.MEDIA_CHANGE_POSITION -> onMediaChangePosition(amount = values[0].toInt())
            CommandType.MEDIA_CHANGE_QUALITY -> onMediaChangeQuality()
            CommandType.MEDIA_CHANGE_SUBTITLE -> onMediaChangeSubtitle()
            CommandType.MEDIA_SUBTITLE_INCREASE -> onMediaSubtitleIncrease()
            CommandType.MEDIA_SUBTITLE_DECREASE -> onMediaSubtitleDecrease()
            else -> Unit
        }
    }

    fun onMediaPlay() = Unit
    fun onMediaPause() = Unit
    fun onMediaRewind(amount: Int) = Unit
    fun onMediaFastForward(amount: Int) = Unit
    fun onMediaAudioTrack() = Unit
    fun onMediaChangePosition(amount: Int) = Unit
    fun onMediaChangeQuality() = Unit
    fun onMediaChangeSubtitle() = Unit
    fun onMediaSubtitleIncrease() = Unit
    fun onMediaSubtitleDecrease() = Unit
}