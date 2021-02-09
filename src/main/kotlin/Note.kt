data class Note(
    val userId: Int,
    val id: Int,
    val title: String,
    val text: String,
    var deleted: Boolean = false,
    ) {
    override fun toString(): String {
        return """|  
            |  Note: (userId = $userId, id = $id, 
            |title = '$title', 
            |text = '$text', 
            |deleted = $deleted)""".trimMargin()
    }
}

data class Comment(
    val noteId: Int = 0,
    val message: String = "",
    val commentId: Int = 0,
    val deleted: Boolean = true
) {
    override fun toString(): String {
        return """|
            |   Comment: (noteId = $noteId, commentId = $commentId, deleted = $deleted
            |   message = '$message')""".trimMargin()
    }
}