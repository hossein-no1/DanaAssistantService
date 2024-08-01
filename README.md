# Dana assistant service
This service is a mediator between two android application.<br/>
With this service, you can open **Dana voice assistant** on your app and receive some commands.
# How to setup service
*1.* in the module gradle:
> `implementation 'com.github.hossein-no1:DanaAssistantService:vx,x,x'`

check the latest release version in github.

*2.* create an instance of `DanaService()`
and use `openAssistant(packageName : String, screenName : String)` function for open Dana overlay.<br/>
**It's important to send your PackageName for receive data with successfully**

*3.* register service when screen created with this function:<br/>
`registerService(object : AssistantCallBack)`

*4.* don't forget call `unregisterService()` when screen destroyed.

# version 1.1.0
##### What's happened in this version?
This commands was supported:

## Commands version 1.1.0

| command | group | is_internal | argument     | default_value |
|---------|-------|-------------|--------------|---------------|
| VolumeUp              | Player | ✖️ | 1 unit 10    | 2             |
| VolumeDown            | Player | ✖️ | 1 unit 10    | 2             |
| VolumeMute            | Player | ✖️ | -            | -             |
| MediaNext             | Player | ✅ | -            | -             |
| MediaPrevious         | Player | ✅ | -            | -             |
| Play                  | Player | ✖️ | -            | -             |
| Pause                 | Player | ✖️ | -            | -             |
| MediaRewind           | Player | ✖️ | 1 unit 36000 | 15            |
| MediaFastForward      | Player | ✖️ | 1 unit 36000 | 15            |
| MediaAudioTrack       | Player | ✖️ | -            | -             |
| MediaChangePosition   | Player | ✖️ | 1 unit 36000 | 0             |
| MediaChangeQuality    | Player | ✖️ | -            | -             |
| MediaChangeSubtitle   | Player | ✖️ | -            | -             |
| MediaSubtitleIncrease | Player | ✖️ | -            | -             |
| MediaSubtitleDecrease | Player | ✖️ | -            | -             |
