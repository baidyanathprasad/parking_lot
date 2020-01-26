import store.ParkingLotImpl

fun main() {
    // main method
    //val input = File("input.txt").readLines()

    val input = readLine()!!
    val parkingLot = ParkingLotImpl()

    // create parking lot of specific size
    parkingLot.createParkingSlot(input.toInt()).apply {
        println(this)
    }

    parkingLot
        .status()
        .stream()
        .forEach { println(it) }
}