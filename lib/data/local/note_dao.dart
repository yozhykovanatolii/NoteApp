import 'package:floor/floor.dart';
import 'package:note_app/data/local/note.dart';

@dao
abstract class NoteDao {
  @insert
  Future<void> insertNote(Note note);

  @delete
  Future<void> deleteNote(Note note);

  @update
  Future<void> updateNote(Note note);

  @Query('SELECT * FROM Note')
  Future<List<Note>?> getNotes();

  @Query(
      "SELECT * FROM Note WHERE title LIKE '%' || :searchText || '%' OR body LIKE '%' || :searchText || '%'")
  Future<List<Note>?> searchNotes(String searchText);
}
