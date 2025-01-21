abstract class Constant {
  static const String databaseName = 'app_database.db';
  static const int databaseVersion = 1;
  static const String getNotesQuery = "SELECT * FROM Note";
  static const String searchNotesQuery =
      "SELECT * FROM Note WHERE title LIKE '%' || :searchText || '%' OR body LIKE '%' || :searchText || '%";
}
