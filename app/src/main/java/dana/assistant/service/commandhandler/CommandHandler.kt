package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType

interface CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
            /**
             * Use «ContentDetailCommandHandler.kt»,«HomeCommandHandler.kt» and etc.
             * */
    fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.BackPress -> onBackPress()
            else -> Unit
        }
    }

    fun onBackPress() = Unit

}