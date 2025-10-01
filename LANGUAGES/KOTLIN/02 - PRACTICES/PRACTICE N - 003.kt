// You can find this Exerice's questions at the Readme.md file ;) 

fun main() {
    // Fill in the code.
    
	// Celsius to Fahrenheit
    printFinalTemperature(27.0, "C", "F") {
    	celsius -> 9/5 * celsius + 32
    }
    
	// Kelvin to Celsius
    printFinalTemperature(350.0, "K", "C") {
        kelvin -> kelvin - 273.15
    }
    
	// Fahrenheit to Kelvin
    printFinalTemperature(10.0, "F", "K") {
        fahrenheit -> 5/9 * (fahrenheit-32) + 273.15
    }
}


fun printFinalTemperature(initialMeasurement: Double, initialUnit: String, finalUnit: String, conversionFormula: (Double) -> Double) {
    
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
