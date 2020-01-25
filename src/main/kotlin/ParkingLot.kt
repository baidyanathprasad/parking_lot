import java.io.File

fun main() {
    // main method
    val input = File("input.txt").readLines()

    input.stream()
        .forEach {
            println(it)
        }
}