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
    OpenWifiSetting,
    OpenBluetoothSetting,
    OpenLanguageSetting,
    OpenSetting,
    OpenProfile,
    Shutdown,
    BackPress,
    HomePress,

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
    "OpenWifiSetting" -> CommandType.OpenWifiSetting
    "OpenBluetoothSetting" -> CommandType.OpenBluetoothSetting
    "OpenLanguageSetting" -> CommandType.OpenLanguageSetting
    "OpenSetting" -> CommandType.OpenSetting
    "OpenProfile" -> CommandType.OpenProfile
    "Shutdown" -> CommandType.Shutdown
    "BackPress" -> CommandType.BackPress
    "HomePress" -> CommandType.HomePress
    else -> CommandType.Unknown
}