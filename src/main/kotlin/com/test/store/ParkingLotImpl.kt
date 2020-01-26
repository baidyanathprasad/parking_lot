package com.test.store

import com.test.data.ParkingLotDao
import com.test.model.Vehicle
import kotlin.streams.toList

class ParkingLotImpl : ParkingLot {
    private val parkingLotDao = ParkingLotDao()

    override fun createParkingSlot(number: Int) = parkingLotDao.createSlotOfSize(number)

    override fun park(vehicle: Vehicle) = try {
        val slot = parkingLotDao.parkVehicle(vehicle = vehicle)
        "Allocated slot number: ${slot.number}"
    } catch (e: Exception) {
        "Sorry, parking lot is full"
    }

    override fun leave(slotNumber: Int) = try {
        parkingLotDao.leaveVehicle(slotNumber)
    } catch (e: Exception) {
        "Error: ${e.localizedMessage}"
    }

    override fun status() = parkingLotDao.getSlots()

    override fun filterVehiclesByColor(color: String) = status()
        .stream()
        .filter { it?.vehicle?.color == color }
        .map { it.vehicle!! }
        .toList()

    override fun filterSlotNumbersByColor(color: String) = status()
        .stream()
        .filter { it?.vehicle?.color == color }
        .toList()

    override fun filterSlotByRegistrationNumber(registrationNumber: String) = status()
        .stream()
        .filter { it?.vehicle?.number == registrationNumber }
        .toList()
        .last()!!
}