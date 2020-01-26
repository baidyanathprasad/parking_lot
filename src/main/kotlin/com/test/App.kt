package com.test

import com.test.model.Vehicle
import com.test.store.ParkingLotImpl
import kotlin.system.exitProcess

fun main() {
    // com.test.main method
    //val input = File("input.txt").readLines()

    val parkingLot = ParkingLotImpl()

    while (true) {
        val input = readLine()!!
        val line = input.split(" ")

        when {
            // create parking lot
            line[0] == "create_parking_lot" -> {
                try {
                    parkingLot.createParkingSlot(line[1].toInt())
                        .apply { println(this) }
                } catch (e: Exception) {
                    printErrorMessage(e.localizedMessage)
                }
            }

            // park vehicle
            line[0] == "park" -> {
                try {
                    parkingLot
                        .park(
                            Vehicle(number = line[1], color = line[2])
                        )
                        .apply { println(this) }
                } catch (e: Exception) {
                    printErrorMessage(e.localizedMessage)
                }
            }

            // leave vehicle
            line[0] == "leave" -> {
                try {
                    parkingLot
                        .leave(slotNumber = line[1].toInt())
                        .apply { println(this) }
                } catch (e: Exception) {
                    printErrorMessage(e.localizedMessage)
                }
            }

            // get current status
            line[0] == "status" -> {
                try {
                    println("Slot No. Registration No Colour")
                    parkingLot
                        .status()
                        .forEach { slot ->
                            if (slot.vehicle != null) {
                                println(
                                    "${slot.number} ${getVehicleNumber(slot.vehicle)} ${getVehicleColor(
                                        slot.vehicle
                                    )}"
                                )
                            }

                        }
                } catch (e: Exception) {
                    printErrorMessage(e.localizedMessage)
                }
            }

            // registration numbers for cars with colors
            line[0] == "registration_numbers_for_cars_with_colour" -> {
                try {
                    parkingLot
                        .filterVehiclesByColor(line[1])
                        .joinToString(", ") { it.number }
                        .apply { println(this) }
                } catch (e: Exception) {
                    println("Not found")
                }
            }

            // slot numbers for cars with colors
            line[0] == "slot_numbers_for_cars_with_colour" -> {
                try {
                    parkingLot
                        .filterSlotNumbersByColor(line[1])
                        .map { it.number }
                        .joinToString(", ")
                        .apply { println(this) }
                } catch (e: Exception) {
                    println("Not found")
                }
            }

            // slot number for registration number
            line[0] == "slot_number_for_registration_number" -> {
                try {
                    parkingLot
                        .filterSlotByRegistrationNumber(line[1])
                        .number
                        .apply { println(this) }
                } catch (e: Exception) {
                    println("Not found")
                }
            }

            // exit
            line[0] == "exit" -> {
                println("Exiting ..")
                exitProcess(200)
            }
        }
    }
}

fun printErrorMessage(message: String) = message.apply { println(this) }

fun getVehicleNumber(vehicle: Vehicle?) = vehicle?.number ?: "NA"

fun getVehicleColor(vehicle: Vehicle?) = vehicle?.color ?: "NA"