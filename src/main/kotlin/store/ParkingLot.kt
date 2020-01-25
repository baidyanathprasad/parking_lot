package store

import model.Slot
import model.Vehicle

interface ParkingLot {

    fun createParkingSlot(number: Int): String

    fun parkVehicle(slot: Slot, vehicle: Vehicle)
}