package dana.assistant.service.model

internal enum class WakeupType(val way: String) {
    Microphone(way = "microphone"),
    ClickOnObject(way = "click_on_object")
}