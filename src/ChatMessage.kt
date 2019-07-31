// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ChatMessage(var message: String, var user: String = "", time: LocalDateTime = LocalDateTime.now()) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm") // formats date to desired style using java library
    val formatted = time.format(formatter)

    override fun toString(): String {
        return "$user $formatted: \r\n $message"
    }
}