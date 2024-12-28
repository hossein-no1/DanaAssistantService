package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType
import dana.assistant.service.model.ErrorType

interface CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
            /**
             * Use «ContentDetailCommandHandler.kt»,«HomeCommandHandler.kt» and etc.
             * */
    fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.BACK_PRESS -> onBackPress()
            else -> Unit
        }
    }

    fun onBackPress() = Unit
    fun onError(type: ErrorType) = Unit

}