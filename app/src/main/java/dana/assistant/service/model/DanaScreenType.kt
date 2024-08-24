package dana.assistant.service.model

enum class DanaScreenType(val value: String, val activityName: String) {
    Overlay(value = "overlay", activityName = "ir.huma.voiceassistant.VoiceActivity"),
    Explorer(value = "search", "ir.huma.voiceassistant.SearchActivity")
}