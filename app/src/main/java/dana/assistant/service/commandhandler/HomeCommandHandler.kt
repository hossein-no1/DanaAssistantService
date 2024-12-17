package dana.assistant.service.commandhandler

import dana.assistant.service.model.CommandType
import dana.assistant.service.model.Direction
import dana.assistant.service.model.MovingDirection
import dana.assistant.service.model.VerticalDirection
import dana.assistant.service.model.parseDirection
import dana.assistant.service.model.parseMovieDirection
import dana.assistant.service.model.parseVerticalDirection

interface HomeCommandHandler : CommandHandler {

    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.SCROLL -> onScroll(direction = parseDirection(direction = values[0]))
            CommandType.CHANGE_TAB -> onChangeTab(direction = parseMovieDirection(direction = values[0]))
            CommandType.SELECT_TAB -> onSelectTab(tabTitle = values[0])
            CommandType.MOVING -> onMoving(direction = parseVerticalDirection(values[0]))
            else -> Unit
        }
    }

    fun onScroll(direction: Direction) = Unit
    fun onChangeTab(direction: MovingDirection) = Unit
    fun onSelectTab(tabTitle: String) = Unit
    fun onMoving(direction: VerticalDirection) = Unit
}