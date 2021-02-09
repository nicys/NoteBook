import NoteBook.addComment
import NoteBook.notes
import NoteBook.addNote
import NoteBook.comments
import NoteBook.deleteComment
import NoteBook.deleteNote
import NoteBook.editComment
import NoteBook.editNote
import NoteBook.getById
import NoteBook.getComments
import NoteBook.getNotes
import NoteBook.restoreComment

fun main(args: Array<String>) {

    val note_1 = Note(100,0, "txt1", "txt1", deleted = true)
    val note_2 = Note(100,0, "txt2", "txt2", deleted = true)
    val note_3 = Note(100,0, "txt3", "txt3", deleted = true)
    val note_4 = Note(100,0, "txt4", "txt4", deleted = true)

    addNote(note_1)
    addNote(note_2)
    addNote(note_3)
    addNote(note_4)
//    println(notes)

    val comment_1 = Comment(4,"comment_4", 0, true)
    val comment_2 = Comment(2,"comment_2", 0, true)

    addComment(4, comment_1)
    addComment(4, comment_2)
//    println(notes[3])
    println(comments)
    println("****************************************************")

    deleteNote(2)
//    println(notes)

    deleteComment(1)
    println(comments)
    println("****************************************************")

    val note_30 = Note(100,0, "txt300", "txt300", deleted = true)
    editNote(3, note_30)
//    println(notes)

    val comment_20 = Comment(20,"comment_20 for change", 10, true)
    editComment(2, comment_20)
//    println(comments)

    getNotes(10) // вылетает Exception

    getById(1)      // вылетает Exception

    getComments(4)  // вылетает Exception

    restoreComment(3)
    println(comments)

}