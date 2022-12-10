fun main() {

    fun Char.getPriority(): Int {
        return when {
            isUpperCase() -> code - 'A'.code + 27
            else -> code - 'a'.code + 1
        }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val compartment1 = it.take(it.length / 2)
            val compartment2 = it.substring(it.length / 2)
            (compartment1.toSet() intersect compartment2.toSet()).single().getPriority()
        }
    }

    fun part2(input: List<String>): Int {
        return (input.indices step 3)
            .map { listOf(input[it].toSet(), input[it + 1].toSet(), input[it + 2].toSet()) }
            .sumOf { ((it[0] intersect it[1]) intersect it[2]).single().getPriority() }
    }

}
