package dana.assistant.service.model

internal enum class WakeupType(val way: String) {
    MICROPHONE(way = "microphone"),
    CLICK_ON_OBJECT(way = "click_on_object")
}