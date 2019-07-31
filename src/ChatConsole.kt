// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

class ChatConsole: ChatHistoryObserver {

    init {
        ChatHistory.registerObserver(this) //initialise register
    }

    override fun newMessage(message: ChatMessage) {
        System.out.println(message)
    }
}
