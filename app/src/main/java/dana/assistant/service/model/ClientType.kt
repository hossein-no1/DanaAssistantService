package dana.assistant.service.model

internal enum class ClientType(val packageName: String) {

    DONE_TV(packageName = "ir.huma.humasuperapp") {
        override fun isDanaSupported(danaVersion: Long, type: ClientScreenType): Boolean {
            return when (type) {
                ClientScreenType.Home -> danaVersion >= VersionSupportedNote.DANA_IN_DONETV_HOME
                ClientScreenType.Player -> danaVersion >= VersionSupportedNote.DANA_IN_DONETV_CONTENT_PLAYER
                ClientScreenType.ContentDetail -> danaVersion >= VersionSupportedNote.DANA_IN_DONETV_CONTENT_DETAIL
            }
        }
    },
    DONE_UI(packageName = "ir.huma.android.launcher") {

        override fun isDanaSupported(danaVersion: Long, type: ClientScreenType): Boolean {
            return when (type) {
                ClientScreenType.Home -> danaVersion >= VersionSupportedNote.DANA_IN_DONEUI_HOME
                else -> false
            }
        }

    },
    UNKNOWN(packageName = "") {
        override fun isDanaSupported(danaVersion: Long, type: ClientScreenType): Boolean {
            return false
        }
    };

    abstract fun isDanaSupported(danaVersion: Long, type: ClientScreenType): Boolean

}

internal fun parseClient(packageName: String): ClientType =
    when (packageName) {
        ClientType.DONE_TV.packageName -> ClientType.DONE_TV
        ClientType.DONE_UI.packageName -> ClientType.DONE_UI
        else -> ClientType.UNKNOWN
    }