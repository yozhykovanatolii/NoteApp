import 'package:get_it/get_it.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/data/local/note_database.dart';

class NoteRepository {
  final NoteDatabase _database = GetIt.instance<NoteDatabase>();

  Future<void> insertNote(Note note) async {
    await _database.noteDao.insertNote(note);
  }

  Future<void> deleteNote(Note note) async {
    await _database.noteDao.deleteNote(note);
  }

  Future<void> editNote(Note note) async {
    await _database.noteDao.updateNote(note);
  }

  Future<List<Note>> getAllNotes() async {
    return await _database.noteDao.getNotes() ?? [];
  }

  Future<List<Note>> searchNoteBySearchText(String searchText) async {
    return await _database.noteDao.searchNotes(searchText) ?? [];
  }
}
