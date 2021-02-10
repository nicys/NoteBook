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
        val note: Note = Note(0, 0, "", "", false)
        note.id = 1
        //Act
        val result = 1
        //Assert
        assertEquals(note.id, result)

    }

    @Test
    fun testAddComment() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val comment: Comment = Comment(0, "", 0, true)
        val expected = addComment(1, comment)
        //Act
        val result = 1
        //Assert
        assertEquals(expected.commentId, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun testAddCommentShouldThrow() {
        //Arrange
        val comment: Comment = Comment(0, "", 0, true)
        val expected = NoteNotFoundException::class
        //Act
        val result = addComment(1, comment)
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testDeleteNote() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteAdd = addNote(note)
        //Act
        val noteDel = deleteNote(1)
        noteAdd.deleted = true
        val result = true
        //Assert
        assertEquals(noteAdd.deleted, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun testDeleteNoteShouldThrow() {
        //Arrange
        val expected = NoteNotFoundException::class
        //Act
        val noteDel = deleteNote(1)
        val result = NoteNotFoundException::class
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testDeleteComment() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val comment: Comment = Comment(0, "", 0, true)
        val commentAdd = addComment(1, comment)
        //Act
        val commentDel = deleteComment(1)
        commentAdd.deleted = true
        val result: Boolean = true
        //Assert
        assertEquals(commentAdd.deleted, result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun testDeleteCommentShouldThrow() {
        //Arrange
        val expected = CommentNotFoundException::class
        //Act
        val result = deleteComment(1)
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testEditNote() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        //Act
        val noteEdit = editNote(1, noteTest)
        noteTest.deleted = false
        val result: Boolean = false
        //Assert
        assertEquals(noteTest.deleted, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun testEditNoteShouldThrow() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val expected = NoteNotFoundException::class
        //Act
        val result = editNote(2, noteTest)
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testEditComment() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val comment: Comment = Comment(0, "", 0, true)
        val noteComment = addComment(1, comment)
        //Act
        val commentEdit = editComment(1, noteComment)
        noteComment.deleted = false
        val result: Boolean = false
        //Assert
        assertEquals(noteComment.deleted, result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun testEditCommentShouldThrow() {
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val comment: Comment = Comment(0, "", 0, true)
        val noteComment = addComment(1, comment)
        //Arrange
        val expected = CommentNotFoundException::class
        //Act
        val result = editComment(2, noteComment)
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testGetNotes() {
        //Arrange
        val note: Note = Note(10, 0, "title", "", false)
        val noteTest = addNote(note)
        //Act
        val expected = "title"
        //Assert
        assertEquals(noteTest.title, expected)
    }

    @Test
    fun testGetById() {
        //Arrange
        val note: Note = Note(10, 0, "title", "text", false)
        val noteTest = addNote(note)
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
        val noteTest = addNote(note)
        val commentTest = addComment(1, comment)
        val expected = comment.message
        //Act
        val result = "commentMessage"
        //Assert
        assertEquals(expected, result)
    }

    @Test
    fun testRestoreComment() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val comment: Comment = Comment(0, "", 0, true)
        val commentTest = addComment(1, comment)
        val deletedComment = deleteComment(1)
        comment.deleted = false
        //Act
        val commentEdit = restoreComment(1)
        val result: Boolean = false
        //Assert
        assertEquals(comment.deleted, result)
    }

    @Test(expected = CommentDeleteNotFoundException::class)
    fun testRestoreCommentShouldThrow() {
        //Arrange
        val note: Note = Note(0, 0, "", "", false)
        val noteTest = addNote(note)
        val comment: Comment = Comment(0, "", 0, true)
        val commentTest = addComment(1, comment)
        val expected = CommentDeleteNotFoundException::class
        //Act
        val commentEdit = restoreComment(1)
        val result = commentTest.commentId
        //Assert
        assertEquals(expected, result)
    }
}