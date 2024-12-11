package dana.assistant.service

import dana.assistant.service.commandhandler.ContentDetailCommandHandler
import dana.assistant.service.commandhandler.GeneralCommandHandler
import dana.assistant.service.commandhandler.HomeCommandHandler
import dana.assistant.service.commandhandler.PlayerCommandHandler
import dana.assistant.service.model.CommandType

interface AssistantCallBack : GeneralCommandHandler, PlayerCommandHandler,
    ContentDetailCommandHandler, HomeCommandHandler {
    fun onReceiveCommand(commandType: CommandType, values: List<String>) {

        when (commandType) {
            CommandType.MediaPlay -> onMediaPlay()
            CommandType.MediaPause -> onMediaPause()
            CommandType.MediaRewind -> onMediaRewind(amount = values[0].toInt())
            CommandType.MediaFastForward -> onMediaFastForward(amount = values[0].toInt())
            CommandType.MediaAudioTrack -> onMediaAudioTrack()
            CommandType.MediaChangePosition -> onMediaChangePosition(amount = values[0].toInt())
            CommandType.MediaChangeQuality -> onMediaChangeQuality()
            CommandType.MediaChangeSubtitle -> onMediaChangeSubtitle()
            CommandType.MediaSubtitleIncrease -> onMediaSubtitleIncrease()
            CommandType.MediaSubtitleDecrease -> onMediaSubtitleDecrease()
            CommandType.BackPress -> onBackPress()
            CommandType.PLAY_CONTENT -> onPlayContent()
            CommandType.BOOKMARK_CONTENT -> onBookmarkContent()
            CommandType.LIKE_CONTENT -> onLikeContent()
            CommandType.DISLIKE_CONTENT -> onDisLikeContent()
            CommandType.SCROLL -> onScroll()
            CommandType.CHANGE_TAB -> onChangeTab()
            CommandType.SELECT_TAB -> onSelectTab()
            CommandType.MOVING -> onMoving()
            else -> Unit
        }
    }
}