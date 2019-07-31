// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

import java.lang.Exception
import java.net.ServerSocket

class ChatServer  {

    fun serve() {
        val serverSocket = ServerSocket(30001) // init socket, 0 will listen for any free port
        println("port: ${serverSocket.localPort}")
        val console = ChatConsole()
        ChatHistory.registerObserver(console)

        try {
            while (true) {
                val s = serverSocket.accept() // block, listens for traffic => unblocks
                println("accepted")
                val t = Thread(CommandInterpreter(s.getInputStream(), s.getOutputStream())) // create threads that get input and output values.

                t.start() // start new thread
            }
        } catch (e: Exception) {
            println( "Got exception: ${e.message}")
        } finally {
            println("All serving done")
        }
    }
}
