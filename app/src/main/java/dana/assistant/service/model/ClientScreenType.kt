package dana.assistant.service.model

enum class ClientScreenType(val screen: String) {
    Home(screen = "home"),
    ContentDetail(screen = "content_detail"),
    Player(screen = "player")
}

fun parseClientScreen(screen: String): ClientScreenType = when (screen) {
    "home" -> ClientScreenType.Home
    "content_detail" -> ClientScreenType.ContentDetail
    "player" -> ClientScreenType.Player
    else -> ClientScreenType.Home
}