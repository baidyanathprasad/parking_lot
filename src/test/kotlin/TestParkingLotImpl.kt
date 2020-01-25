import org.junit.Assert
import org.junit.Test
import store.ParkingLotImpl

class TestParkingLotImpl {
    private val parkingLot = ParkingLotImpl()

    @Test
    fun testCreateParkingSlot(){
        Assert.assertEquals("Allocated slot number: 1", parkingLot.createParkingSlot(1))
    }
}