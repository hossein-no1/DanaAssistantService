package dana.assistant.service.commandhandler

interface PlayerCommandHandler : CommandHandler {
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