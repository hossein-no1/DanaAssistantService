package dana.assistant.service.model

enum class CommandType {
    VolumeUp,
    VolumeDown,
    VolumeMute,
    MediaNext,
    MediaPrevious,
    MediaRewind,
    MediaFastForward,
    MediaAudioTrack,
    MediaChangePosition,
    MediaChangeQuality,
    MediaChangeSubtitle,
    MediaSubtitleIncrease,
    MediaSubtitleDecrease,

    Unknown
}

fun parseCommand(command: String) = when (command) {
    "VolumeUp" -> CommandType.VolumeUp
    "VolumeDown" -> CommandType.VolumeDown
    "VolumeMute" -> CommandType.VolumeMute
    "MediaNext" -> CommandType.MediaNext
    "MediaPrevious" -> CommandType.MediaPrevious
    "MediaRewind" -> CommandType.MediaRewind
    "MediaFastForward" -> CommandType.MediaFastForward
    "MediaAudioTrack" -> CommandType.MediaAudioTrack
    "MediaChangePosition" -> CommandType.MediaChangePosition
    "MediaChangeQuality" -> CommandType.MediaChangeQuality
    "MediaChangeSubtitle" -> CommandType.MediaChangeSubtitle
    "MediaSubtitleIncrease" -> CommandType.MediaSubtitleIncrease
    "MediaSubtitleDecrease" -> CommandType.MediaSubtitleDecrease
    else -> CommandType.Unknown
}