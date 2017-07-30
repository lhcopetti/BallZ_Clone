package ballzclone.copetti.com.ballzclone

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class GameActivity : FullScreenActivity() {

    private var gameView: View? = null
    private var gameLayout: ViewGroup? = null

    private var renderView : RenderView? = null

    private var scaleView: Point = Point(0, 0);

    init {
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event == null)
            return super.onTouchEvent(event)

        val gameViewImmutable = gameView
        val offset: Float = if (gameViewImmutable != null) gameViewImmutable.top.toFloat() else 0f

        val transformedTouch = normalizeTouchInput(event, offset)

        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.d("Touch", "TouchEvent (Transformed) at: ${transformedTouch.x}, ${transformedTouch.y}")
            renderView?.onInput(transformedTouch)
        }
        return false
    }

    private fun normalizeTouchInput(event: MotionEvent, offset: Float) : BZVector2f {

        val ratio = BZVector2f(event.x / scaleView.x, (event.y - offset) / scaleView.y)
        return BZVector2f(ratio.x * GameDefine.GAME_SCREEN_WIDTH, ratio.y * GameDefine.GAME_SCREEN_HEIGHT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        gameView = findViewById(R.id.mainGameView)
        gameLayout = findViewById(R.id.gameViewLayout) as ViewGroup

        val display = windowManager.defaultDisplay
        var displayDimensions = Point()
        display.getSize(displayDimensions)
        scaleView = Point(displayDimensions.x, displayDimensions.y)
        Log.d("Touch", "This is the dimensions: ${displayDimensions.x}, ${displayDimensions.y}")

        renderView = RenderView(this)
        renderView?.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        gameLayout!!.addView(renderView)
    }

    fun btnPauseGameClicked(v : View)
    {

    }
}
