fun main() {
  
    val packetMarkerPos = 4
    val messageMarkerPos = 14

    // works for both the parts!  
    fun solution(input: List<String>, pos: Int) = input.single().windowed(pos).takeWhile { it.toSet().size != pos }.count() + pos

}
