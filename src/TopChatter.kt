// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

object TopChatter: ChatHistoryObserver {
    private val topCharts = mutableMapOf<String, Int>() // map with the values

    init {
        ChatHistory.registerObserver(this) // init register
    }

    override fun newMessage(message: ChatMessage) {
        var userName = message.user
        if (!topCharts.containsKey(userName)) {     // check if username isn't on list
            topCharts[userName] = 1 // add to list and give initial value of 1
        } else {
            var posts = topCharts[userName] // if  user already on list then do null check and increment by 1
            if (posts != null) {
               posts += 1
                topCharts.set(userName, posts)
            }
        }
    }

   override fun toString(): String {

      var printOut = ""
       val mostActive = topCharts.maxBy { it.value } // return element with largest value i.e. most messages.

       if (mostActive != null) { // null check
           printOut = "The most active chatter is ${mostActive.key} with ${mostActive.value} messages!"
           System.out.println(printOut)
       }
       return printOut
    }
}
