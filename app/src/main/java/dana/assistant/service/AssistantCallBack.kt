package dana.assistant.service

interface AssistantCallBack {
    fun onReceiveCommand(commandType : CommandType, value : String)
}