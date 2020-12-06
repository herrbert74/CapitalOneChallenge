/*
 * Complete the 'minimumSwaps' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY popularity as parameter.
 */

fun minimumSwaps(popularity: Array<Int>): Int {
    var swapsCount = 0
    for (index in popularity.indices) {
        if ( popularity[index] != popularity.size - index) {
            val otherPosition = popularity.indexOf(popularity.size - index)
            swap(popularity, index, otherPosition)
            swapsCount++
        }
    }
    return swapsCount

}

fun swap(popularity: Array<Int>, a: Int, b: Int) {
    popularity[a] = popularity[b].also { popularity[b] = popularity[a] }
}

fun main(args: Array<String>) {
    val popularityCount = readLine()!!.trim().toInt()

    val popularity = Array<Int>(popularityCount, { 0 })
    for (i in 0 until popularityCount) {
        val popularityItem = readLine()!!.trim().toInt()
        popularity[i] = popularityItem
    }

    val result = minimumSwaps(popularity)

    println(result)
}
