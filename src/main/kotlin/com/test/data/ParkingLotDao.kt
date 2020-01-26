package com.test.data

import com.test.model.Slot
import com.test.model.Vehicle
import kotlin.streams.toList

class ParkingLotDao {
    private var slots: List<Slot>? = null

    fun createSlotOfSize(number: Int) = when {
        slots.isNullOrEmpty() -> {
            slots = MutableList(number) { Slot(it + 1, null, true) }
            "Created a parking lot with $number slots"
        }
        else -> "Can not create/modify the parking slots once it's already created!"
    }

    fun getSlots() = if (slots.isNullOrEmpty()) emptyList() else slots!!

    private fun getFirstAvailableSlot() = slots
        ?.first { it.isAvailable }!!

    fun parkVehicle(vehicle: Vehicle): Slot {
        val slot = getFirstAvailableSlot()
        slots
            ?.stream()
            ?.map {
                if (it.number == slot.number) it.copy(vehicle = vehicle, isAvailable = false)
                else it
            }
            ?.toList()
            ?.apply { slots = this }

        return slot
    }

    fun leaveVehicle(slotNumber: Int): String {
        slots
            ?.stream()
            ?.map {
                if (it.number == slotNumber) it.copy(vehicle = null, isAvailable = true)
                else it
            }
            ?.toList()
            ?.apply { slots = this }

        return "Slot number $slotNumber is free"
    }

}