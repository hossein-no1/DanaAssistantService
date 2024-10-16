package dana.assistant.service.model

enum class CommandType {
    VolumeUp,
    VolumeDown,
    VolumeMute,
    MediaPlay,
    MediaPause,
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

    PlayMovie,
    PlaySerial,
    PlayMusic,
    OpenApplication,

    Unknown
}

fun parseCommand(command: String) = when (command) {
    "VolumeUp" -> CommandType.VolumeUp
    "VolumeDown" -> CommandType.VolumeDown
    "VolumeMute" -> CommandType.VolumeMute
    "MediaPlay" -> CommandType.MediaPlay
    "MediaPause" -> CommandType.MediaPause
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
    "PlayMovie" -> CommandType.PlayMovie
    "PlaySerial" -> CommandType.PlaySerial
    "PlayMusic" -> CommandType.PlayMusic
    "OpenApplication" -> CommandType.OpenApplication
    else -> CommandType.Unknown
}