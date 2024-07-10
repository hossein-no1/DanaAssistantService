# Dana assistant service
This service is a mediator between two android application.<br/>
With this service, you can open **Dana voice assistant** on your app and receive some commands.
# How to setup service
*1.* in the module gradle:
> `implementation 'com.github.hossein-no1:DanaAssistantService:vx,x,x'`

check the latest release version in github.

*2.* create an instanse of `DanaService()`
and use `openAssistant(packageName : String, screenName : String)` function for open Dana overlay.<br/>
**It's important to send your packagename for receive data with successfully**

*3.* register service when screen created with this function:<br/>
`registerService(object : AssistantCallBack)`

*4.* don't forget call `unregisterService()` when screen destroyed.

# version 1.0.0
##### What's happened in this version?
This commandes was supported:
- *VolumeUp*
- *VolumeDown*
- *MediaPause*
- *MediaStop*
- *MediaNext*
- *MediaPrevious*
- *MediaRewind*
- *MediaFastForward*
- *MediaAudioTrack*
- *ChangeMediaPosition*
- *ChangeMediaQuality*
- *ChangeMediaSubtitle*
- *ChangeSubtitleSize*
