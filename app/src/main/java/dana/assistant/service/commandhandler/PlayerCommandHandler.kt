package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType

interface PlayerCommandHandler : CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        super.onReceiveCommand(commandType, values)
        when (commandType) {
            CommandType.MediaPlay -> onMediaPlay()
            CommandType.MediaPause -> onMediaPause()
            CommandType.MediaRewind -> onMediaRewind(amount = values[0].toInt())
            CommandType.MediaFastForward -> onMediaFastForward(amount = values[0].toInt())
            CommandType.MediaAudioTrack -> onMediaAudioTrack()
            CommandType.MediaChangePosition -> onMediaChangePosition(amount = values[0].toInt())
            CommandType.MediaChangeQuality -> onMediaChangeQuality()
            CommandType.MediaChangeSubtitle -> onMediaChangeSubtitle()
            CommandType.MediaSubtitleIncrease -> onMediaSubtitleIncrease()
            CommandType.MediaSubtitleDecrease -> onMediaSubtitleDecrease()
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