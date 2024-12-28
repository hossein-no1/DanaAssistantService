package dana.assistant.service.commandhandler

import androidx.annotation.RestrictTo
import dana.assistant.service.model.CommandType
import dana.assistant.service.model.Direction
import dana.assistant.service.model.ErrorType
import dana.assistant.service.model.MovingDirection
import dana.assistant.service.model.VerticalDirection
import dana.assistant.service.model.parseDirection
import dana.assistant.service.model.parseMovieDirection
import dana.assistant.service.model.parseVerticalDirection

interface HomeCommandHandler : CommandHandler {

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        super.onReceiveCommand(commandType, values)
        try {
            when (commandType) {
                CommandType.SCROLL -> onScroll(direction = parseDirection(direction = values[0]))
                CommandType.CHANGE_TAB -> onChangeTab(direction = parseMovieDirection(direction = values[0]))
                CommandType.SELECT_TAB -> onSelectTab(tabTitle = values[0])
                CommandType.MOVING -> onMoving(direction = parseVerticalDirection(values[0]))
                else -> onError(type = ErrorType.COMMAND_NOT_FOUND)
            }
        } catch (_: Exception) {
            onError(type = ErrorType.RUN_TIME_EXCEPTION)
        }
    }

    fun onScroll(direction: Direction) = Unit
    fun onChangeTab(direction: MovingDirection) = Unit
    fun onSelectTab(tabTitle: String) = Unit
    fun onMoving(direction: VerticalDirection) = Unit
}