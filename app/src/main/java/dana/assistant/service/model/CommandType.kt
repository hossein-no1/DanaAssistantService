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