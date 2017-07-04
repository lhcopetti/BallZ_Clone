package ballzclone.copetti.com.ballzclone

import android.content.Context
import android.graphics.*
import android.view.View
import ballzclone.copetti.com.ballzclone.ballzclone.copetti.com.game.GameLoopManager
import ballzclone.copetti.com.ballzclone.ballzclone.copetti.com.game.GameManager

/**
 * Created by LuisCopetti on 29/06/2017.
 */

class RenderView(context: Context) : View(context) {


//    private val src = Rect()
//    private val dst = Rect()
//    private var bird: Bitmap? = null

    private var lastElapsedTime : Long = 0


    private var deltaTime: Float = 0.0f
    private var lastTimeStart: Float = 0.0f

    private val FRAME_RATE = 20.0f

    private var gameManager = GameManager()
    private var viewManager = ViewManager()
    private var loopManager = GameLoopManager(gameManager, System::nanoTime, FRAME_RATE)

    private val GAME_SCREEN_WIDTH = 240 * 2
    private val GAME_SCREEN_HEIGHT = 320 * 2

    init {
//        val assetManager = context.assets
//        try {
//            val inputStream = assetManager.open("bird.png")
//            bird = BitmapFactory.decodeStream(inputStream)
//            inputStream.close()
//        } catch (e: IOException) {
//            e.printStackTrace()
//            Toast.makeText(context, "Erro ao carregar asset: bird.png", Toast.LENGTH_LONG).show()
//        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var frameBuffer = Bitmap.createBitmap(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT, Bitmap.Config.RGB_565)
        var normalizedCanvas = Canvas(frameBuffer)
        val dstRect = Rect(0, 0, canvas.width, canvas.height)
        loopManager.update(normalizedCanvas)

        var paint = Paint()
        paint.strokeMiter = 1.0f
        paint.color = Color.rgb(240, 240, 240)

        normalizedCanvas.drawCircle(GAME_SCREEN_WIDTH / 2.0f, 0.0f, 25.0f, paint)
        normalizedCanvas.drawCircle(GAME_SCREEN_WIDTH / 2.0f, GAME_SCREEN_HEIGHT.toFloat(), 25.0f, paint)

        canvas.drawBitmap(frameBuffer, null, dstRect, null)
        invalidate()

//        val timeStart = getCurrentTimeInSeconds()
//        deltaTime += timeStart - lastTimeStart;
//        lastTimeStart = timeStart
//
//        if (deltaTime < fixedTimeStep) {
//            invalidate()
//            return
//        }
//
//        gameManager.update(deltaTime)
//        deltaTime = 0.0f
//        gameManager.draw(canvas)
//        val image = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565)
//        val imageCanvas = Canvas(image)
//        val paint = Paint()
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 10f
//        paint.color = Color.RED
//        imageCanvas.drawCircle((image.width / 2).toFloat(), (image.height / 2).toFloat(), 50f, paint)
//        canvas.drawBitmap(bird!!, 100f, 100f, null)
//        canvas.drawBitmap(image, 300f, 300f, null)
//        //dst.set(300, 100, 700, 900);
//        dst.set(0, 0, canvas.width, canvas.height)
//        canvas.drawBitmap(bird!!, null, dst, null)
//
//        src.set(0, 0, 75, 75)
//        dst.set(canvas.width - 150, canvas.height - 150, canvas.width, canvas.height)
//        canvas.drawBitmap(bird!!, src, dst, null)
    }
}