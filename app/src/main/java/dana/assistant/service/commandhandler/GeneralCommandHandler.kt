package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType

interface GeneralCommandHandler : CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.BackPress -> onBackPress()
            else -> Unit
        }
    }

    fun onBackPress() = Unit
}