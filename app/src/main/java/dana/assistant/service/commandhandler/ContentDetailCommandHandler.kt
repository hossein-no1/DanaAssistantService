package dana.assistant.service.commandhandler

import dana.assistant.service.model.CommandType

interface ContentDetailCommandHandler : CommandHandler {

    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.PLAY_CONTENT -> onPlayContent()
            CommandType.BOOKMARK_CONTENT -> onBookmarkContent()
            CommandType.LIKE_CONTENT -> onLikeContent()
            CommandType.DISLIKE_CONTENT -> onDisLikeContent()
            else -> Unit
        }
    }

    fun onPlayContent() = Unit
    fun onBookmarkContent() = Unit
    fun onLikeContent() = Unit
    fun onDisLikeContent() = Unit
}