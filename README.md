# Dana assistant service
This service is a mediator between two android applications.<br/>
With this service, you can open **Dana voice assistant** on your app and receive some commands.
# How to setup service
In the module gradle:
> `implementation 'com.github.hossein-no1:DanaAssistantService:vx,x,x'`

check the latest release version in GitHub.

### Setup `DanaService` in Activity/Fragment

```Kotlin
class MainActivity : AppCompatActivity() {

    lateinit var danaService: DanaService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        danaService = DanaService(
            context = context,
            callBack = object : AssistantCallBack {
                override fun onDisLikeContent() {
                    println("onDisLikeContent")
                }

                override fun onLikeContent() {
                    println("onLikeContent")
                }

                override fun onBookmarkContent() {
                    println("onBookmarkContent")
                }

                override fun onPlayContent() {
                    println("onPlayContent")
                }
            },
        )
        lifecycle.addObserver(danaService)
    }

    override fun onStart() {
        super.onStart()
        lifecycle.addObserver(danaService)
    }

    override fun onStop() {
        super.onStop()
        lifecycle.removeObserver(danaService)
    }
}
```

### Setup `DanaService` in Composable Screen

```Kotlin
@Composable
fun MainScreen() {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    
    val danaService = remember {
        DanaService(
            context = context,
            callBack = object : AssistantCallBack {
                override fun onDisLikeContent() {
                    println("onDisLikeContent")
                }

                override fun onLikeContent() {
                    println("onLikeContent")
                }

                override fun onBookmarkContent() {
                    println("onBookmarkContent")
                }

                override fun onPlayContent() {
                    println("onPlayContent")
                }
            },
        )
    }

    DisposableEffect(lifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(danaService)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(danaService)
        }
    }

    ....

}
```

### Setup `DanaService` in ViewModel

```Kotlin
    private val danaService = DanaService(
        context = context,
        callBack = object : AssistantCallBack {
            override fun onDisLikeContent() {
                println("onDisLikeContent")
            }

            override fun onLikeContent() {
                println("onLikeContent")
            }

            override fun onBookmarkContent() {
                println("onBookmarkContent")
            }

            override fun onPlayContent() {
                println("onPlayContent")
            }
        },
    )

    fun attachToLifecycle(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(danaService)
    }

    fun detachToLifecycle(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.removeObserver(danaService)
    }
```

For use in an Activity/Fragment or Composable function, attach and detach the `DanaService` like setting it up in the two sections above.

# version 1.3.1
##### What's happened in this version?
This commands was supported:
- add thirteen new command
- add startup type for better performance

| command               | group | argument     | default_value |
|-----------------------|-------|--------------|---------------|
| BackPress | General | -            | -             |
| PlayContent | ContentDetail | -            | -             |
| BookmarkContent | ContentDetail | -            | -             |
| LikeContent | ContentDetail | -            | -             |
| DisLikeContent | ContentDetail | -            | -             |

# version 1.2.0
##### What's happened in this version?
This commands was supported:
- disable allowbackup

## Commands version 1.2.0

##### What's happened in this version?
This commands was supported:
- add two new command

| command               | group | argument     | default_value |
|-----------------------|-------|--------------|---------------|
| MediaPlay             | Player | -            | -             |
| MediaPause            | Player | -            | -             |

# version 1.1.0
##### What's happened in this version?
This commands was supported:

| command | group | argument     | default_value |
|---------|-------|--------------|---------------|
| MediaRewind           | Player | 1 unit 36000 | 15            |
| MediaFastForward      | Player | 1 unit 36000 | 15            |
| MediaAudioTrack       | Player | -            | -             |
| MediaChangePosition   | Player | 1 unit 36000 | 0             |
| MediaChangeQuality    | Player | -            | -             |
| MediaChangeSubtitle   | Player | -            | -             |
| MediaSubtitleIncrease | Player | -            | -             |
| MediaSubtitleDecrease | Player | -            | -             |
