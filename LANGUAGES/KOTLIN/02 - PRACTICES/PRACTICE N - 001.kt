// Phone Notifications - practice: 

// The exact number of notifications when there are less than 100 notifications.
// 99+ as the number of notifications when there are 100 notifications or more.


fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You Have $numberOfMessages Message !")
    } else if (numberOfMessages >= 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
