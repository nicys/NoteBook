object NoteBook {
    var notes = listOf<Note>()
    var comments = listOf<Comment>()

    fun addNote(note: Note): Note {
        notes += note.copy(id = notes.size + 1, deleted = false)
        return notes.last()
    }

    fun addComment(id: Int, comment: Comment): Comment {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    comments += comment.copy(commentId = comments.size + 1, message = comment.message, deleted = false)
                    return comments.last()
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    fun deleteNote(id: Int): Boolean {
//        notes.forEachIndexed { index, note ->
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    val newNote = note.copy(id = note.id, deleted = true)
                    val note = newNote
                    return true
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    fun deleteComment(idComment: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.deleted) {
                if (idComment == comment.commentId) {
                    val newComment = comment.copy(commentId = comment.commentId, deleted = true)
                    val comment = newComment
                    return true
                }
            }
        }
        throw CommentNotFoundException("Комментария с таким ID не существует!")
    }

    fun editNote(id: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    val newNote = note.copy(id = note.id)
                    val note = newNote
                    return true
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    fun editComment(idComment: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.deleted) {
                if (idComment == comment.commentId) {
                    val newComment = comment.copy(commentId = comment.commentId)
                    val comment = newComment
                    return true
                }
            }
        }
        throw CommentNotFoundException("Комментария с таким ID не существует!")
    }

    fun get(idUser: Int) {
        for (note in notes) {
            if (!note.deleted) {
                if (idUser == note.userId) {
                    println("Note of User with ID: ${note.userId} - ${note.title}")
                }
            }
        }
        throw UserNotFoundException("Пользователя с таким ID не существует!")
    }

    fun getById(id: Int) {
        for (note in notes) {
            if (id == note.id) {
                println("""|        title: ${note.title}
                    |   text: ${note.text}
                """.trimMargin())
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    fun getComments(id: Int) {
        for (note in notes) {
            if (id == note.id) {
                if (!note.deleted) {
                    println(note.comment)
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }

    fun restoreComment(idComment: Int): Boolean {
        for (comment in comments) {
            if (idComment == comment.commentId) {
                if (comment.deleted) {
                    val newComment = comment.copy(commentId = comment.commentId, deleted = false)
                    val comment = newComment
                    return true
                }
            }
        }
        throw CommentNotFoundException("Удаленного комментария с таким ID не существует!")
    }



}
class NoteNotFoundException(message: String) : RuntimeException()
class CommentNotFoundException(message: String) : RuntimeException()
class UserNotFoundException(message: String) : RuntimeException()

