package dana.assistant.service.model

enum class ClientScreenType(val screen: String) {
    HOME(screen = "home"),
    CONTENT_DETAIL(screen = "content_detail"),
    PLAYER(screen = "player")
}

fun parseClientScreen(screen: String): ClientScreenType = when (screen) {
    "home" -> ClientScreenType.HOME
    "content_detail" -> ClientScreenType.CONTENT_DETAIL
    "player" -> ClientScreenType.PLAYER
    else -> ClientScreenType.HOME
}