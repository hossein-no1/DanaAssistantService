package dana.assistant.service.commandhandler

import dana.assistant.service.model.CommandType

interface GeneralCommandHandler : CommandHandler {

    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.BackPress -> onBackPress()
            else -> Unit
        }
    }

    fun onBackPress() = Unit
}