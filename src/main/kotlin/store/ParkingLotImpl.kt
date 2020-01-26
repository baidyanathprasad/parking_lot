package store

import data.ParkingLotDao
import model.Slot
import model.Vehicle

class ParkingLotImpl : ParkingLot {
    private val parkingLotDao = ParkingLotDao()

    override fun createParkingSlot(number: Int) = parkingLotDao.createSlotOfSize(number)

    override fun park(slot: Slot, vehicle: Vehicle): String {
        TODO("not implemented")
    }

    override fun leave(slotNumber: Int): String {
        TODO("not implemented")
    }

    override fun status() = parkingLotDao.getSlots()

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