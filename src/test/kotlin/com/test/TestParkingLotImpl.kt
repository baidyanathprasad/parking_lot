package com.test

import com.test.model.Slot
import com.test.model.Vehicle
import com.test.store.ParkingLotImpl
import org.junit.Assert
import org.junit.Test

class TestParkingLotImpl {
    private val parkingLot = ParkingLotImpl()

    @Test
    fun testCreateParkingSlot() {
        val noOfSlots = 2
        Assert.assertEquals("Created a parking lot with $noOfSlots slots", parkingLot.createParkingSlot(2))
    }

    @Test
    fun testPark() {
        val noOfSlots = 1

        // create slot
        Assert.assertEquals("Created a parking lot with $noOfSlots slots", parkingLot.createParkingSlot(1))

        // test parking
        val vehicle = Vehicle("test_vehicle", "test_color")
        Assert.assertEquals("Allocated slot number: $noOfSlots", parkingLot.park(vehicle))
    }

    @Test
    fun testLeave() {
        val noOfSlots = 1

        // create slot
        Assert.assertEquals("Created a parking lot with $noOfSlots slots", parkingLot.createParkingSlot(1))

        // test parking
        val vehicle = Vehicle("test_vehicle", "test_color")
        Assert.assertEquals("Allocated slot number: $noOfSlots", parkingLot.park(vehicle))

        // test leave park
        val leaveAtSlot = 1
        Assert.assertEquals("Slot number $leaveAtSlot is free", parkingLot.leave(leaveAtSlot))
    }

    @Test
    fun testStatus() {
        val noOfSlots = 2

        // create slot
        Assert.assertEquals("Created a parking lot with $noOfSlots slots", parkingLot.createParkingSlot(2))

        // test parking
        val vehicle = Vehicle("test_vehicle", "test_color")
        Assert.assertEquals("Allocated slot number: 1", parkingLot.park(vehicle))

        // test leave park
        val leaveAtSlot = 1
        Assert.assertEquals("Slot number $leaveAtSlot is free", parkingLot.leave(leaveAtSlot))

        // park vehicle
        Assert.assertEquals("Allocated slot number: 1", parkingLot.park(vehicle))
        Assert.assertEquals(
            listOf(
                Slot(number = 1, vehicle = vehicle, isAvailable = false),
                Slot(number = 2, vehicle = null, isAvailable = true)
            ),
            parkingLot.status()
        )
    }
}