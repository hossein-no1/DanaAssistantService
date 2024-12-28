package dana.assistant.service.model

import dana.assistant.service.commandhandler.CommandHandler
import dana.assistant.service.commandhandler.ContentDetailCommandHandler
import dana.assistant.service.commandhandler.HomeCommandHandler
import dana.assistant.service.commandhandler.PlayerCommandHandler

internal enum class ClientType(val packageName: String) {

    DONE_TV(packageName = "ir.huma.humaplay") {
        override fun isDanaSupported(danaVersion: Long, type: CommandHandler): Boolean {
            return when (type) {
                is HomeCommandHandler -> danaVersion >= VersionSupportedNote.DANA_IN_DONETV_HOME
                is PlayerCommandHandler -> danaVersion >= VersionSupportedNote.DANA_IN_DONETV_PLAYER
                is ContentDetailCommandHandler -> danaVersion >= VersionSupportedNote.DANA_IN_DONETV_CONTENT_DETAIL
                else -> false
            }
        }
    },
    DONE_UI(packageName = "ir.huma.android.launcher") {

        override fun isDanaSupported(danaVersion: Long, type: CommandHandler): Boolean {
            return when (type) {
                is HomeCommandHandler -> danaVersion >= VersionSupportedNote.DANA_IN_DONEUI_HOME
                else -> false
            }
        }

    },
    UNKNOWN(packageName = "") {
        override fun isDanaSupported(danaVersion: Long, type: CommandHandler): Boolean {
            return false
        }
    };

    abstract fun isDanaSupported(danaVersion: Long, type: CommandHandler): Boolean

}

internal fun parseClient(packageName: String): ClientType =
    when (packageName) {
        ClientType.DONE_TV.packageName -> ClientType.DONE_TV
        ClientType.DONE_UI.packageName -> ClientType.DONE_UI
        else -> ClientType.UNKNOWN
    }