object NoteBook {
    var notes = mutableListOf<Note>()
    var comments = mutableListOf<Comment>()

    fun addNote(note: Note): Note {
        val newNote = note.copy(id = notes.size + 1, deleted = false)
        notes.plusAssign(newNote)
        return notes.last()
    }

    fun addComment(id: Int, comment: Comment): Comment {
        for (note in notes) {
            if (!note.deleted) {
                if (id == note.id) {
                    val newComment = comment.copy(noteId = note.id, commentId = comments.size + 1,
                            message = comment.message, deleted = false)
                    comments.plusAssign(newComment)
                    return comments.last()
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }


    fun deleteNote(id: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    notes[index] = note.copy(id = note.id, deleted = true)
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
                    comments[index] = comment.copy(commentId = comment.commentId, deleted = true)
                    return true
                }
            }
        }
        throw CommentNotFoundException("Комментария с таким ID не существует!")
    }

    fun editNote(id: Int, newNote: Note): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {
                    notes[index] = note.copy(id = note.id, userId = note.userId, title = newNote.title,
                            text = newNote.text, deleted = false)
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

    fun getComments(id: Int, comment: Comment) {
        for (note in notes) {
            if (id == comment.noteId) {
                if (!note.deleted) {
                    println(comment)
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
        throw CommentDeleteNotFoundException("Удаленного комментария с таким ID не существует!")
    }
}



class NoteNotFoundException(message: String) : RuntimeException("Заметки с таким ID не существует!")
class CommentNotFoundException(message: String) : RuntimeException("Комментария с таким ID не существует!")
class UserNotFoundException(message: String) : RuntimeException("Пользователя с таким ID не существует!")
class CommentDeleteNotFoundException(message: String) : RuntimeException("Удаленного комментария с таким ID не существует!")