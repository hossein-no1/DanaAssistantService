package dana.assistant.service.commandhandler

interface GeneralCommandHandler : CommandHandler {
    fun onBackPress() = Unit
}