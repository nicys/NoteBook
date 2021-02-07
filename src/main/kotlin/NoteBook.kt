object NoteBook {
    var notes = emptyArray<Note>()
    var comments = emptyArray<Comment>()

    fun addNote(note: Note): Note {
        notes += note.copy(id = notes.size + 1, deleted = false)
        return notes.last()
    }

    fun addComment(id: Int, comment: Comment): Comment {
        for ((index, note) in notes.withIndex()) {
            if (!note.deleted) {
                if (id == note.id) {

                    comments += comment.copy(commentId = comments.size, message = comment.message,
                        count = comment.count + 1, deleted = false)
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
                    val newNote = note.copy(id = note.id, deleted = true)
                    notes[index] = newNote
                    return true
                }
            }
        }
        throw NoteNotFoundException("Заметки с таким ID не существует!")
    }




}
class NoteNotFoundException(message: String) : RuntimeException()

