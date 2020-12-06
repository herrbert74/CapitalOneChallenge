import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*


/*
 * Complete the 'interpolate' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY instances
 *  3. FLOAT_ARRAY price
 */

fun interpolate(n: Int, instances: Array<Int>, price: Array<Float>): String {
    val realInstances= mutableListOf<Int>()
    val realPrice= mutableListOf<Float>()
    instances.forEachIndexed { index, i ->
        if(price[index] > 0.0) {
            realInstances.add(i)
            realPrice.add(price[index])
        }
    }
    return when {
        n < realInstances[0] -> calculateSmallPrice(n, realInstances.toTypedArray(), realPrice.toTypedArray())
        n > realInstances[realInstances.size -1] -> calculateLargePrice(n, realInstances.toTypedArray(), realPrice.toTypedArray())
        else -> calculateMedium(n, realInstances.toTypedArray(), realPrice.toTypedArray())
    }

}

fun calculateMedium(n: Int, instances: Array<Int>, price: Array<Float>): String {
    val largeIndex = instances.indexOfFirst { it > n }
    return calculateActualPrice(instances, largeIndex, price, n)
}

private fun calculateActualPrice(instances: Array<Int>, largeIndex: Int, price: Array<Float>, n: Int): String {
    val deltaInstances = instances[largeIndex] - instances[largeIndex - 1]
    val deltaPrices = price[largeIndex] - price[largeIndex - 1]
    val instanceDiff = n - instances[largeIndex - 1]
    val actualPrice = price[largeIndex - 1] + deltaPrices * instanceDiff / deltaInstances
    return actualPrice.toString()
}

fun calculateLargePrice(n: Int, instances: Array<Int>, price: Array<Float>): String {
    val largeIndex = 1
    return calculateActualPrice(instances, largeIndex, price, n)
}

fun calculateSmallPrice(n: Int, instances: Array<Int>, price: Array<Float>): String {
    val largeIndex = instances.size - 1
    return calculateActualPrice(instances, largeIndex, price, n)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val instancesCount = readLine()!!.trim().toInt()

    val instances = Array<Int>(instancesCount, { 0 })
    for (i in 0 until instancesCount) {
        val instancesItem = readLine()!!.trim().toInt()
        instances[i] = instancesItem
    }

    val priceCount = readLine()!!.trim().toInt()

    val price = Array<Float>(priceCount, { 0f })
    for (i in 0 until priceCount) {
        val priceItem = readLine()!!.trim().toFloat()
        price[i] = priceItem
    }

    val result = interpolate(n, instances, price)

    println(result)
}