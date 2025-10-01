
// *
open class SmartDevice(val name: String, val category: String, val deviceType: String) {

    fun printDeviceInfo() {
		println("DeviceName: $name, category: $category, type: $deviceType.")
    }
    
}


// *
class SmartTvDevice(name: String, category: String, deviceType: String,var volume: Int, var channel: Int)
	  : SmartDevice(name, category, deviceType) {

	fun decreaseVolume() {
        if (volume>0) {
            volume--
            println("Volume decreased to $volume !")
        }
    }
    
    fun previousChannel() {
            channel--
            println("Channel Changed to $channel !")
    }
}



// *
class SmartLightDevice(name: String, category: String, deviceType: String, var brightness: Int)
	  : SmartDevice(name, category, deviceType) {
    
    fun decreaseBrightness() {
        if (brightness > 0) {
            brightness--
            println("brightness decreased to $brigtness !")
        }
    }
}




  
