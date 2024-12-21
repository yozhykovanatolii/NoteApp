import 'package:note_app/data/local/database_helper.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/data/local/note_database.dart';

class NoteRepository {
  late final NoteDatabase _database;

  NoteRepository._(this._database);

  static Future<NoteRepository> create() async {
    final db = await DatabaseHelper.getDatabase();
    return NoteRepository._(db);
  }

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
