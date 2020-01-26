package store

import model.Slot
import model.Vehicle

interface ParkingLot {

    /**
     * @param number - no. of slots needs to be created.
     */
    fun createParkingSlot(number: Int): String

    /**
     * @param vehicle
     * park the vehicle
     */
    fun park(vehicle: Vehicle): String

    /**
     * @param slotNumber
     * Leave the given slot and make them available to use
     */
    fun leave(slotNumber: Int): String

    /**
     * Find the current status of parking slot
     */
    fun status(): List<Slot>

    /**
     * @param color
     * Filter vehicles by color
     */
    fun filterVehiclesByColor(color: String): List<Vehicle>

    /**
     * @param color
     * filter slot numbers by color
     */
    fun filterSlotNumbersByColor(color: String): List<Slot>

    /**
     * @param registrationNumber
     * filter slot number by registration number
     */
    fun filterSlotByRegistrationNumber(registrationNumber: String): Slot
}