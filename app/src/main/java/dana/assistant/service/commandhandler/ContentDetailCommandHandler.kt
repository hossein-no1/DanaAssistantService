package dana.assistant.service.commandhandler

interface ContentDetailCommandHandler : CommandHandler {
    fun onPlayContent() = Unit
    fun onBookmarkContent() = Unit
    fun onLikeContent() = Unit
    fun onDisLikeContent() = Unit
}