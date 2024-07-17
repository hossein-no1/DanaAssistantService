package dana.assistant.service

import dana.assistant.service.model.CommandType

interface AssistantCallBack {
    fun onReceiveCommand(commandType: CommandType, values: List<String>)
}