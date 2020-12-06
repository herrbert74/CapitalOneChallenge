fun main(args: Array<String>) {
    val aCount = readLine()!!.trim().toInt()

    val a = Array<Int>(aCount, { 0 })
    for (i in 0 until aCount) {
        val aItem = readLine()!!.trim().toInt()
        a[i] = aItem
    }

    val rotateCount = readLine()!!.trim().toInt()

    val rotate = Array<Int>(rotateCount, { 0 })
    for (i in 0 until rotateCount) {
        val rotateItem = readLine()!!.trim().toInt()
        rotate[i] = rotateItem
    }

    val result = getMaxElementIndexes(a, rotate)

    println(result.joinToString("\n"))
}

fun getMaxElementIndexes(a: Array<Int>, rotate: Array<Int>): Array<Int> {
    return rotate.map {
        val o = leftRotation(a, it)
        o.indexOf(o.max())
    }.toTypedArray()
}

fun leftRotation(a: Array<Int>, rotateBy: Int): Array<Int> {
    val elementsToTake = a.size - rotateBy.rem(a.size)
    val stay = a.takeLast(elementsToTake)
    val toRotate = a.take(rotateBy)
    return stay.plus(toRotate).toTypedArray()
}

fun getMaxElementIndexesQuicker(a: Array<Int>, rotate: Array<Int>): Array<Int> {
    val maxIndex = a.indexOf(a.max())
    return rotate.map {
        val actualRotation = it.rem(a.size)
        if (actualRotation > maxIndex)
            a.size - actualRotation + maxIndex
        else
            maxIndex - actualRotation
    }.toTypedArray()
}
