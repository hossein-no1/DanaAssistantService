package dana.assistant.service.commandhandler

import dana.assistant.service.model.CommandType

interface CommandHandler {
    fun onReceiveCommand(commandType: CommandType, values: List<String>)
}