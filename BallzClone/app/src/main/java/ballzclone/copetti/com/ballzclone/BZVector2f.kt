package ballzclone.copetti.com.ballzclone

/**
 * Created by Pichau on 06/07/2017.
 */
class BZVector2f(x: Float, y: Float) {

    var x: Float = x
    var y: Float = y


    public operator fun plus(rhs: BZVector2f) : BZVector2f
    {
        x += rhs.x
        y += rhs.y
        return this
    }

    override operator fun equals(rhs: Any?) = when(rhs) {
        is BZVector2f -> x == rhs.x && y == rhs.y
        else -> false
    }

    fun add(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    fun set(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    fun invertX() : BZVector2f {
        this.x = -x
        return this
    }

    fun invertY() : BZVector2f {
        this.y = -y;
        return this
    }

    operator fun times(num: Float) : BZVector2f {
        return BZVector2f(x * num, y * num)
    }

    operator fun  minus(position: BZVector2f) = BZVector2f(x - position.x, y - position.y)

    fun  dot(rhs: BZVector2f): Float {
        return x * rhs.x + y * rhs.y
    }

    override fun toString(): String {
        return "[${x}, ${y}]"
    }

    fun size(): Float {
        return Math.sqrt(Math.pow(x.toDouble(), 2.0) + Math.pow(y.toDouble(), 2.0)).toFloat()
    }

    fun  normalize(): BZVector2f {
        return this / size()
    }

    private operator fun  div(size: Float): BZVector2f {
        return BZVector2f(x / size, y / size)
    }
}