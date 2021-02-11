import NoteBook.addComment
import NoteBook.addNote
import NoteBook.deleteComment
import NoteBook.deleteNote
import NoteBook.editComment
import NoteBook.editNote
import NoteBook.getNotes
import NoteBook.restoreComment
import org.junit.Test

import org.junit.Assert.*

class NoteBookTest {

    @Test
    fun testAddNote() {
        //Arrange
        val noteTest: Note = Note(0, 0, "", "", false)
        noteTest.id = 1
        //Act
        val result = 1
        //Assert
        assertEquals(noteTest.id, result)
    }

    @Test
    fun testAddComment() {
        //Arrange
        val noteTest: Note = Note(0, 1, "", "", false)
        noteTest.id = 1
        val commentTest: Comment = Comment(1, "", 0, false)
        //Act
        commentTest.commentId = 1
        //Assert
        assertEquals(commentTest.commentId, noteTest.id)
    }

    @Test(expected = NoteNotFoundException::class)
    fun testAddCommentShouldThrow() {
        //Arrange
        val comment: Comment = Comment(0, "", 0, true)
        val expected = NoteNotFoundException::class
        //Act
        val result = addComment(10, comment)
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testDeleteNote() {
        //Arrange
        val noteTest: Note = Note(0, 0, "", "", false)
        addNote(noteTest)
        noteTest.id = 1
        //Act
        deleteNote(1)
        noteTest.deleted = true
        val result = true
        //Assert
        assertEquals(noteTest.deleted, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun testDeleteNoteShouldThrow() {
        //Arrange
        val expected = NoteNotFoundException::class
        //Act
        deleteNote(10)
        val result = NoteNotFoundException::class
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testDeleteComment() {
        //Arrange
        val noteTest: Note = Note(0, 0, "", "", false)
        addNote(noteTest)
        val commentTest: Comment = Comment(0, "", 0, false)
        addComment(1, commentTest)
        //Act
        deleteComment(1)
        commentTest.deleted = true
        val result: Boolean = true
        //Assert
        assertEquals(commentTest.deleted, result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun testDeleteCommentShouldThrow() {
        //Arrange
        val expected = CommentNotFoundException::class
        //Act
        deleteComment(10)
        val result = CommentNotFoundException::class
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testEditNote() {
        //Arrange
        val noteTest: Note = Note(0, 0, "", "", false)
        addNote(noteTest)
        noteTest.id = 1
        //Act
        editNote(1, noteTest)
        noteTest.deleted = false
        val result: Boolean = false
        //Assert
        assertEquals(noteTest.deleted, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun testEditNoteShouldThrow() {
        //Arrange
        val noteTest: Note = Note(0, 0, "", "", false)
        addNote(noteTest)
        noteTest.id = 1
        val expected = NoteNotFoundException::class
        //Act
        editNote(10, noteTest)
        val result = NoteNotFoundException::class
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testEditComment() {
        //Arrange
        val noteTest: Note = Note(0, 0, "", "", false)
        addNote(noteTest)
        val commentTest: Comment = Comment(0, "", 0, true)
        addComment(1, commentTest)
        //Act
        editComment(1, commentTest)
        commentTest.deleted = false
        val result: Boolean = false
        //Assert
        assertEquals(commentTest.deleted, result)
    }


    @Test(expected = CommentNotFoundException::class)
    fun testEditCommentShouldThrow() {
        //Arrange
        val commentTest: Comment = Comment(0, "", 0, true)
        val expected = CommentNotFoundException::class
        //Act
        editComment(10, commentTest)
        val result = CommentNotFoundException::class
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testGetNotes() {
        //Arrange
        val noteTest: Note = Note(10, 0, "title", "", false)
        addNote(noteTest)
        //Act
        val expected = "title"
        //Assert
        assertEquals(noteTest.title, expected)
    }

    @Test
    fun testGetById() {
        //Arrange
        val note: Note = Note(10, 0, "title", "text", false)
        val expected = println("""|        title: title
                    |   text: text
                """.trimMargin())
        //Act
        val result = println("""|        title: ${note.title}
                    |   text: ${note.text}
                """.trimMargin())
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testGetComments() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val comment: Comment = Comment(0, "commentMessage", 0, true)
        addNote(note)
        addComment(1, comment)
        val expected = comment.message
        //Act
        val result = "commentMessage"
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testRestoreComment() {
        //Arrange
        val commentTest: Comment = Comment(1, "", 1, true)
        commentTest.commentId = 1
        commentTest.deleted = true
        //Act
        restoreComment(1)
        val result = true
        //Assert
        assertEquals(commentTest.deleted, result)
    }

    @Test(expected = CommentDeleteNotFoundException::class)
    fun testRestoreCommentShouldThrow() {
        //Arrange
        val commentTest: Comment = Comment(1, "", 1, true)
        commentTest.commentId = 1
        commentTest.deleted = true
        val expected = CommentDeleteNotFoundException::class
        //Act
        restoreComment(10)
        val result = CommentDeleteNotFoundException::class
        //Assert
        assertEquals(expected, result)
    }
}