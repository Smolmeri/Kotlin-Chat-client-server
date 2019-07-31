// AUTHOR Tuomas Paavolainen
// 1800671
package chatServer

object Users {
    private var allUsers = mutableSetOf<String>()

    fun insertUser(uName: String) {
        allUsers.add(uName) // add to set
        println("User $uName added")
    }

    fun removeUser(uName: String) {
        allUsers.remove(uName) // remove from set
        println("The user $uName was removed")
    }

    fun doesExist(uName: String): Boolean {
        allUsers.contains(uName) // check if username is in use
        return allUsers.contains(uName)
    }

    override fun toString(): String {
        var userString = ""

        for (i in allUsers) {
            userString += "\n \r $i" // prints list of users
        }
        return userString
    }
}