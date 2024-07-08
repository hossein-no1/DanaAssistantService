package dana.assistant.service

enum class CommandType {
    VolumeUp,
    VolumeDown,
    MediaPause,
    MediaStop,
    MediaNext,
    MediaPrevious,
    MediaRewind,
    MediaFastForward,
    MediaAudioTrack,
    ChangeMediaPosition,
    ChangeMediaQuality,
    ChangeMediaSubtitle,
    ChangeSubtitleSize,

    Unknown
}