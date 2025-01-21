import 'package:floor/floor.dart';
import 'package:note_app/common/constant.dart';
import 'package:note_app/data/local/note.dart';

@dao
abstract class NoteDao {
  @insert
  Future<void> insertNote(Note note);

  @delete
  Future<void> deleteNote(Note note);

  @update
  Future<void> updateNote(Note note);

  @Query(Constant.getNotesQuery)
  Future<List<Note>?> getNotes();

  @Query(Constant.searchNotesQuery)
  Future<List<Note>?> searchNotes(String searchText);
}
