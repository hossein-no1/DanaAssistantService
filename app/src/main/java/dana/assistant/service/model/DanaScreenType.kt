package dana.assistant.service.model

enum class DanaScreenType(val value: String, val activityName: String) {
    OVERLAY(value = "overlay", activityName = "ir.huma.voiceassistant.VoiceActivity"),
    EXPLORER(value = "search", "ir.huma.voiceassistant.SearchActivity")
}