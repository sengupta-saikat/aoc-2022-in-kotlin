fun main() {

    data class Datum(val firstRange: IntRange, val secondRange: IntRange)

    fun List<String>.toRanges(): List<Datum> {
        val pattern = Regex("""(\d+)-(\d+),(\d+)-(\d+)""")
        return map {
            val (a, b, c, d) = pattern.find(it)!!.destructured
            Datum(a.toInt()..b.toInt(), c.toInt()..d.toInt())
        }
    }

    fun part1(input: List<String>): Int {
        return input.toRanges().count { (r1, r2) -> r1.all { r2.contains(it) } || r2.all { r1.contains(it) } }
    }

    fun part2(input: List<String>): Int {
        return input.toRanges().count { (r1, r2) -> r1.any { r2.contains(it) } || r2.any { r1.contains(it) } }
    }

}
