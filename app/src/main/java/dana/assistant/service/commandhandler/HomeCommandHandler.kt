package dana.assistant.service.commandhandler

interface HomeCommandHandler : CommandHandler {
    fun onScroll() = Unit
    fun onChangeTab() = Unit
    fun onSelectTab() = Unit
    fun onMoving() = Unit
}