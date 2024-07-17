package dana.assistant.service.model

enum class ClientScreenType(val screen: String) {
    Home(screen = "home"),
    DetailContent(screen = "detail_content"),
    Player(screen = "player")
}

fun parseClientScreen(screen: String): ClientScreenType = when (screen) {
    "home" -> ClientScreenType.Home
    "detail_content" -> ClientScreenType.DetailContent
    "player" -> ClientScreenType.Player
    else -> ClientScreenType.Home
}