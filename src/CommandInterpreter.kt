// AUTHOR Tuomas Paavolainen
// 1800671


package chatServer

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.util.*

class CommandInterpreter(inputStream: InputStream?, out: OutputStream?, private var quit: Boolean = false): Runnable, ChatHistoryObserver {

    private val inputScanner = Scanner(inputStream)
    private val output = PrintStream(out)
    private val ch = ChatHistory
    private val userInput = Users
    var user = ""

    override fun run() {
        ch.registerObserver(this) // register as ChatHistory observer
        println("Enter a username: ")
        do { // loop starts
            var chatLine = inputScanner.nextLine()

            if (chatLine.startsWith(":user")) {
                if (!userInput.doesExist(chatLine.drop(6))) { // check if user exists
                    userInput.insertUser(chatLine.drop(6)) // if not then add to user list.
                    user = chatLine.drop(6) // save for ChatMessage

                } else println("This username is already taken!")
            } else if (user != "" && !chatLine.startsWith(":")) { // checks that username has been set and if input isn't a command
                val cm = ChatMessage(chatLine, user) // send inputline and username to ChatMessage
                ch.insert(cm)

            } else if (chatLine.startsWith(":history")) { // prints all previous messages
                output.println(ch.toString())
            } else if (chatLine.startsWith(":allusers")) { // prints list of current users
                output.println(userInput.toString())
            } else if (chatLine.startsWith(":remove")) { // removes user (maybe only if admin rights etc??
                println(userInput.removeUser(chatLine.drop(8)))
            } else if (chatLine.startsWith(":topchat")) { // prints user with most messages
                output.println(TopChatter.toString())
            } else if (chatLine.startsWith(":quit")) { // quits loop
                println("you have exited the chat")
                quit = true
            } else if (chatLine.startsWith(":exit")) { // quits loop
                println("you have exited the chat")
                quit = true
            } else {
                println("You need to add a user or that is not a valid command")
            }
        } while (!quit)
    }
    override fun newMessage(message: ChatMessage) {
        output.println(message) // prints message
    }
}


