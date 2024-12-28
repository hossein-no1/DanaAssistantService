package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType
import dana.assistant.service.model.ErrorType

interface ContentDetailCommandHandler : CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        super.onReceiveCommand(commandType, values)
        try {
            when (commandType) {
                CommandType.PLAY_CONTENT -> onPlayContent()
                CommandType.BOOKMARK_CONTENT -> onBookmarkContent()
                CommandType.LIKE_CONTENT -> onLikeContent()
                CommandType.DISLIKE_CONTENT -> onDisLikeContent()
                else -> onError(type = ErrorType.COMMAND_NOT_FOUND)
            }
        }catch (_: Exception){
            onError(type = ErrorType.RUN_TIME_EXCEPTION)
        }
    }

    fun onPlayContent() = Unit
    fun onBookmarkContent() = Unit
    fun onLikeContent() = Unit
    fun onDisLikeContent() = Unit
}