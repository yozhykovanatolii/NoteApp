import 'package:flutter/material.dart';

final themeData = ThemeData(
  scaffoldBackgroundColor: Colors.grey.shade900,
  appBarTheme: AppBarTheme(
    backgroundColor: Colors.grey.shade900,
    titleTextStyle: const TextStyle(
      fontSize: 30,
      color: Colors.white,
    ),
  ),
  floatingActionButtonTheme: const FloatingActionButtonThemeData(
    backgroundColor: Colors.amber,
    foregroundColor: Colors.white,
  ),
  textTheme: const TextTheme(
    bodyLarge: TextStyle(
      fontSize: 30,
      color: Colors.white,
    ),
  ),
  searchBarTheme: SearchBarThemeData(
    backgroundColor: WidgetStatePropertyAll(Colors.grey.shade800),
    hintStyle: const WidgetStatePropertyAll(
      TextStyle(
        fontSize: 23,
        color: Colors.grey,
      ),
    ),
    textStyle: const WidgetStatePropertyAll(
      TextStyle(
        fontSize: 23,
        color: Colors.white,
      ),
    ),
    padding: const WidgetStatePropertyAll(EdgeInsets.symmetric(horizontal: 15)),
  ),
  textSelectionTheme: const TextSelectionThemeData(
    cursorColor: Colors.blue,
    selectionColor: Colors.blue,
    selectionHandleColor: Colors.blue,
  ),
  cardTheme: CardTheme(
    color: Colors.grey.shade800,
    clipBehavior: Clip.hardEdge,
  ),
  listTileTheme: const ListTileThemeData(
    titleTextStyle: TextStyle(
      fontSize: 20,
      color: Colors.white,
    ),
    subtitleTextStyle: TextStyle(
      fontSize: 18,
      color: Colors.white,
    ),
    iconColor: Colors.white,
  ),
);
