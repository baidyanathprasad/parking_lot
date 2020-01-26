package store

import model.Slot
import model.Vehicle

class ParkingLotImpl : ParkingLot {
    override fun createParkingSlot(number: Int) = "Allocated slot number: $number"

    override fun park(slot: Slot, vehicle: Vehicle): String {
        TODO("not implemented")
    }

    override fun leave(slotNumber: Int): String {
        TODO("not implemented")
    }

    override fun status(): List<Slot> {
        TODO("not implemented")
    }

    override fun filterVehiclesByColor(color: String): List<Vehicle> {
        TODO("not implemented")
    }

    override fun slotNumbersByColor(color: String): List<Slot> {
        TODO("not implemented")
    }

    override fun filterSlotByRegistrationNumber(registrationNumber: String): Slot {
        TODO("not implemented")
    }
}