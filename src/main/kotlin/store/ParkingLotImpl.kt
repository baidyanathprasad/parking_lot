package store

import model.Slot
import model.Vehicle

class ParkingLotImpl : ParkingLot {
    override fun createParkingSlot(number: Int) = "Allocated slot number: $number"

    override fun parkVehicle(slot: Slot, vehicle: Vehicle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}