package com.mdn.androidmaster.ejerciciosAndroidOficial

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

}

fun printNotificationSummary(numberOfNotifications: Int) {

    if (numberOfNotifications <= 99) {
        println("You have $numberOfNotifications notifications.")
    } else {
        println("Your phone in blowing up! You have +99 notifications.")
    }

}
