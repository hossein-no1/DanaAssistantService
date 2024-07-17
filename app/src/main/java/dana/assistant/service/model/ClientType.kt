package dana.assistant.service.model

enum class ClientType(val packageName : String) {
    Launcher(packageName = "ir.huma.android.launcher"),
    DoneTv(packageName = "ir.huma.humaplay"),
    Namava(packageName = "com.shatelland.namava.tv")
}

fun parseClient(client: String): ClientType = when (client) {
    "ir.huma.android.launcher" -> ClientType.Launcher
    "ir.huma.humaplay" -> ClientType.DoneTv
    "com.shatelland.namava.tv" -> ClientType.Namava
    else -> ClientType.Launcher
}