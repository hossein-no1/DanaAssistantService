package dana.assistant.service.model

enum class CommandType {

    // Player group
    MediaPlay,
    MediaPause,
    MediaRewind,
    MediaFastForward,
    MediaAudioTrack,
    MediaChangePosition,
    MediaChangeQuality,
    MediaChangeSubtitle,
    MediaSubtitleIncrease,
    MediaSubtitleDecrease,

    // General group
    BackPress,

    // Content-Detail group
    PLAY_CONTENT,
    BOOKMARK_CONTENT,
    LIKE_CONTENT,
    DISLIKE_CONTENT,

    // Home group
    SCROLL,
    CHANGE_TAB,
    SELECT_TAB,
    MOVING,

    Unknown
}

fun parseCommand(command: String) = when (command) {
    "MediaPlay" -> CommandType.MediaPlay
    "MediaPause" -> CommandType.MediaPause
    "MediaRewind" -> CommandType.MediaRewind
    "MediaFastForward" -> CommandType.MediaFastForward
    "MediaAudioTrack" -> CommandType.MediaAudioTrack
    "MediaChangePosition" -> CommandType.MediaChangePosition
    "MediaChangeQuality" -> CommandType.MediaChangeQuality
    "MediaChangeSubtitle" -> CommandType.MediaChangeSubtitle
    "MediaSubtitleIncrease" -> CommandType.MediaSubtitleIncrease
    "MediaSubtitleDecrease" -> CommandType.MediaSubtitleDecrease
    "BackPress" -> CommandType.BackPress
    "PlayContent" -> CommandType.PLAY_CONTENT
    "BookmarkContent" -> CommandType.BOOKMARK_CONTENT
    "LikeContent" -> CommandType.LIKE_CONTENT
    "DisLikeContent" -> CommandType.DISLIKE_CONTENT
    "Scroll" -> CommandType.SCROLL
    "ChangeTab" -> CommandType.CHANGE_TAB
    "SelectTab" -> CommandType.SELECT_TAB
    "Moving" -> CommandType.MOVING
    else -> CommandType.Unknown
}