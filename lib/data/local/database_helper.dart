import 'package:note_app/data/local/note_database.dart';

class DatabaseHelper {
  static NoteDatabase? _database;

  static Future<NoteDatabase> getDatabase() async {
    _database ??=
        await $FloorNoteDatabase.databaseBuilder('app_database.db').build();
    return _database!;
  }
}
