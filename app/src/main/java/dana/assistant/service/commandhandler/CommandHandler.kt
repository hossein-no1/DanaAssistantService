package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType

@RestrictTo(RestrictTo.Scope.LIBRARY)
interface CommandHandler {
    fun onReceiveCommand(commandType: CommandType, values: List<String>)
}