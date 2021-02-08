data class Note(
    val userId: Int,
    val id: Int,
    val title: String,
    val text: String,
    var deleted: Boolean = false,
    val comment: Comment
) {
    override fun toString(): String {
        return """|  
            |  Note: 
            |(userId = $userId, 
            |id = $id, 
            |title = '$title', 
            |text = '$text', 
            |deleted = $deleted, 
            |comment = $comment)""".trimMargin()
    }
}

data class Comment(
    val message: String = "",
    val commentId: Int = 0,
    val deleted: Boolean = true
)


// for fun addNote() return noteId
//val title: String
//val text: String
//fun addNote()

// for fun createComment return commentID
//val noteId: Int
//val ownId: Int
//val message: String
//fun createComment()

// for fun deleteNote: Boolean
// val noteId: Int
//fun deleteNote()

// for fun deleteComment: Boolean
//val commentId: Int
// val ownerId: Int
//fun deleteComment()

// for fun editNote: Boolean
// val noteId: Int
// val title: String
// val text: String
//fun editNote()

// for fun editComment: Boolean
// val commentId: Int
// val ownerId: Int
// val message: String
//fun editComment()
//
//fun get()

// for fun getById:

//fun getById()
// val noteId: Int
// val ownId: Int

//fun getComments()
//
//fun restoreComment()