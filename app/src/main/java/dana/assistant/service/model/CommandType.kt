package dana.assistant.service.model

enum class CommandType {

    // Player group
    MEDIA_PLAY,
    MEDIA_PAUSE,
    MEDIA_REWIND,
    MEDIA_FAST_FORWARD,
    MEDIA_AUDIO_TRACK,
    MEDIA_CHANGE_POSITION,
    MEDIA_CHANGE_QUALITY,
    MEDIA_CHANGE_SUBTITLE,
    MEDIA_SUBTITLE_INCREASE,
    MEDIA_SUBTITLE_DECREASE,

    // General group
    BACK_PRESS,

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

    Unknown,
}

enum class Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN,
    UNKNOWN,
}

enum class VerticalDirection {
    UP,
    DOWN,
    UNKNOWN,
}

enum class MovingDirection {
    FORWARD,
    BACKWARD,
    FIRST,
    LAST,
    UNKNOWN,
}

fun parseCommand(command: String) = when (command) {
    "MediaPlay" -> CommandType.MEDIA_PLAY
    "MediaPause" -> CommandType.MEDIA_PAUSE
    "MediaRewind" -> CommandType.MEDIA_REWIND
    "MediaFastForward" -> CommandType.MEDIA_FAST_FORWARD
    "MediaAudioTrack" -> CommandType.MEDIA_AUDIO_TRACK
    "MediaChangePosition" -> CommandType.MEDIA_CHANGE_POSITION
    "MediaChangeQuality" -> CommandType.MEDIA_CHANGE_QUALITY
    "MediaChangeSubtitle" -> CommandType.MEDIA_CHANGE_SUBTITLE
    "MediaSubtitleIncrease" -> CommandType.MEDIA_SUBTITLE_INCREASE
    "MediaSubtitleDecrease" -> CommandType.MEDIA_SUBTITLE_DECREASE
    "BackPress" -> CommandType.BACK_PRESS
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

fun parseDirection(direction: String) = when (direction) {
    "left" -> Direction.LEFT
    "right" -> Direction.RIGHT
    "up" -> Direction.UP
    "down" -> Direction.DOWN
    else -> Direction.UNKNOWN
}

fun parseVerticalDirection(direction: String) = when (direction) {
    "up" -> VerticalDirection.UP
    "down" -> VerticalDirection.DOWN
    else -> VerticalDirection.UNKNOWN
}

fun parseMovieDirection(direction: String) = when (direction) {
    "forward" -> MovingDirection.FORWARD
    "backward" -> MovingDirection.BACKWARD
    "first" -> MovingDirection.FIRST
    "last" -> MovingDirection.LAST
    else -> MovingDirection.UNKNOWN
}