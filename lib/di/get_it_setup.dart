import 'package:get_it/get_it.dart';
import 'package:note_app/data/local/note_database.dart';
import 'package:note_app/data/note_repository.dart';

abstract class GetItSetup {
  static void setupDependencies() {
    GetIt.instance.registerFactory<NoteRepository>(() => NoteRepository());
    GetIt.instance.registerSingletonAsync<NoteDatabase>(
      $FloorNoteDatabase.databaseBuilder('app_database.db').build,
    );
  }
}
