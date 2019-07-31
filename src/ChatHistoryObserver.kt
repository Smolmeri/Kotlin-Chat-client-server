// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

interface ChatHistoryObserver {
    fun newMessage(message: ChatMessage)
}