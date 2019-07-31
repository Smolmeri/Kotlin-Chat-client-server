// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

interface ChatHistoryObservable {
    fun registerObserver(observer: ChatHistoryObserver)

    fun deregisterObserver(observer: ChatHistoryObserver)

    fun notifyObservers(message: ChatMessage)
}