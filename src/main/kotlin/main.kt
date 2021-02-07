import NoteBook.notes
import NoteBook.addNote

fun main(args: Array<String>) {

    val note_1 = Note(0, "txt1", "txt1", deleted = false,
        comment = Comment("",0,0, deleted = false))

    val note_2 = Note(0, "txt2", "txt2", deleted = false,
        comment = Comment("",0,0, deleted = false))


    addNote(note_1)
    addNote(note_2)
    println(notes)


}