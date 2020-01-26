package model

data class Slot(
    val number: Int,
    val vehicle: Vehicle?,
    val isAvailable: Boolean
)