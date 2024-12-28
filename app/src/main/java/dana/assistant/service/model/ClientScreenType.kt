package dana.assistant.service.model

enum class ClientScreenType(val screen: String, private val minVersionSupported: Long) {
    HOME(screen = "home", minVersionSupported = VersionSupportedNote.DANA_IN_HOME),
    CONTENT_DETAIL(
        screen = "content_detail",
        minVersionSupported = VersionSupportedNote.DANA_IN_CONTENT_DETAIL
    ),
    PLAYER(screen = "player", minVersionSupported = VersionSupportedNote.DANA_IN_PLAYER);

    fun isDanaSupported(danaVersion: Long) = (danaVersion >= minVersionSupported)
}