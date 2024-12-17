package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType

@RestrictTo(RestrictTo.Scope.LIBRARY)
/**
 * Use «ContentDetailCommandHandler.kt»,«HomeCommandHandler.kt» and etc.
 * */
interface CommandHandler {
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    fun onReceiveCommand(commandType: CommandType, values: List<String>)
}