package dana.assistant.service.commandhandler

import dana.assistant.service.model.CommandType

interface HomeCommandHandler : CommandHandler {

    override fun onReceiveCommand(commandType: CommandType, values: List<String>) {
        when (commandType) {
            CommandType.SCROLL -> onScroll()
            CommandType.CHANGE_TAB -> onChangeTab()
            CommandType.SELECT_TAB -> onSelectTab()
            CommandType.MOVING -> onMoving()
            else -> Unit
        }
    }

    fun onScroll() = Unit
    fun onChangeTab() = Unit
    fun onSelectTab() = Unit
    fun onMoving() = Unit
}