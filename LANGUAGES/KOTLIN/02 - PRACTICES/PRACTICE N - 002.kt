// Movie Ticket Prices :

// A children's ticket price of $15 for people 12 years old or younger.
// A standard ticket price of $30 for people between 13 and 60 years old. On Mondays, discount the standard ticket price to $25 for this same age group.
// A senior ticket price of $20 for people 61 years old and older. Assume that the maximum age of a moviegoer is 100 years old.
// A -1 value to indicate that the price is invalid when a user inputs an age outside of the age specifications.


fun main() {
    val child = 5
    val adult = 28
    val senior = 87
    
    val isMonday = true
    
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
	println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
    if (age < 0 || age > 100) {
        return -1
        
    } else if (age <=12 ) {
        return 15
        
    } else if (age >= 13 && age <= 60) {
        return if (isMonday) 25 else 30
        
    } else {
        return 20
    }
}
