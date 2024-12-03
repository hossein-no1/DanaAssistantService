package dana.assistant.service.model

enum class WakeupType(val way: String) {
    Microphone(way = "microphone"),
    ClickOnObject(way = "click_on_object")
}

fun parseWakeup(way: String): WakeupType = when (way) {
    "microphone" -> WakeupType.Microphone
    "click_on_object" -> WakeupType.ClickOnObject
    else -> WakeupType.Microphone
}