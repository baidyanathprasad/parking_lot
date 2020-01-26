package data

import model.Slot

class ParkingLotDao {
    private var slots: List<Slot>? = null

    fun createSlotOfSize(number: Int) = when {
        slots.isNullOrEmpty() -> {
            slots = MutableList(number) { Slot(it + 1, null, true) }
            "Created a parking lot with $number slots"
        }
        else -> "Can not create/modify the slot once it's already created!"
    }

    fun getSlots() = if (slots.isNullOrEmpty()) emptyList() else slots!!
}