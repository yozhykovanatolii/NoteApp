import 'package:floor/floor.dart';

@entity
class Note {
  @PrimaryKey(autoGenerate: true)
  int? id;
  String title;
  String body;

  Note({
    this.id,
    required this.title,
    required this.body,
  });
}
