package dana.assistant.service.action_handler

import android.os.SystemClock
import android.view.KeyEvent
import android.view.View

fun View.simulateKeyDown(count: Int = 1) {
    repeat(times = count) {
        simulateKeyEvent(view = this, keyCode = KeyEvent.KEYCODE_DPAD_DOWN)
    }
}

fun View.simulateKeyUp(count: Int = 1) {
    repeat(times = count) {
        simulateKeyEvent(view = this, keyCode = KeyEvent.KEYCODE_DPAD_UP)
    }
}

fun View.simulateKeyLeft(count: Int = 1) {
    repeat(times = count) {
        simulateKeyEvent(view = this, keyCode = KeyEvent.KEYCODE_DPAD_LEFT)
    }
}

fun View.simulateKeyRight(count: Int = 1) {
    repeat(times = count) {
        simulateKeyEvent(view = this, keyCode = KeyEvent.KEYCODE_DPAD_RIGHT)
    }
}

private fun simulateKeyEvent(view: View, keyCode: Int) {
    val downTime = SystemClock.uptimeMillis()
    val eventTime = SystemClock.uptimeMillis()

    val keyDownEvent = KeyEvent(downTime, eventTime, KeyEvent.ACTION_DOWN, keyCode, 0)
    val keyUpEvent = KeyEvent(downTime, eventTime, KeyEvent.ACTION_UP, keyCode, 0)

    view.dispatchKeyEvent(keyDownEvent)
    view.dispatchKeyEvent(keyUpEvent)
}