package dana.assistant.service.model

enum class CommandType {
    // Player group
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

    // General group

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
    Reboot,
    BackPress,
    HomePress,

    // Content-Detail group

    Play,
    Bookmark,
    Like,
    DisLike,

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
    "Reboot" -> CommandType.Reboot
    "BackPress" -> CommandType.BackPress
    "HomePress" -> CommandType.HomePress
    "Play" -> CommandType.Play
    "Bookmark" -> CommandType.Bookmark
    "Like" -> CommandType.Like
    "DisLike" -> CommandType.DisLike
    else -> CommandType.Unknown
}