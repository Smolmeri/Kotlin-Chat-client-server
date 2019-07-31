// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

object ChatHistory: ChatHistoryObservable{
    private val history = mutableListOf<ChatMessage>()
    private val observers = mutableListOf<ChatHistoryObserver>()

    override fun registerObserver(observer: ChatHistoryObserver){
        observers.add(observer) // adds to list
    }

    override fun deregisterObserver(observer: ChatHistoryObserver) {
        observers.remove(observer) // removes from list
    }

    override fun notifyObservers(message: ChatMessage) {
        observers.forEach{it.newMessage(message)} // notifies observers that list has changed
    }

    fun insert(message: ChatMessage) {
        history.add(message) // adds to history list
        notifyObservers(message) //notifies other observers in other threads
    }

    override fun toString(): String {
        var historyList = ""

        for (i in history) {
          historyList += "\n \r $i" // print out each message,

        }
       return "$historyList"
    }


}




