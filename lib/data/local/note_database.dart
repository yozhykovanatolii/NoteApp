import 'dart:async';
import 'package:floor/floor.dart';
import 'package:note_app/common/constant.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/data/local/note_dao.dart';
import 'package:sqflite/sqflite.dart' as sqflite;

part 'note_database.g.dart';

@Database(version: Constant.databaseVersion, entities: [Note])
abstract class NoteDatabase extends FloorDatabase {
  NoteDao get noteDao;
}
