import 'package:flutter/material.dart';

final themeData = ThemeData(
  scaffoldBackgroundColor: Colors.grey.shade900,
  floatingActionButtonTheme: const FloatingActionButtonThemeData(
    backgroundColor: Colors.amber,
    foregroundColor: Colors.white,
  ),
  textTheme: const TextTheme(
    bodyLarge: TextStyle(
      fontSize: 30,
      color: Colors.white,
    ),
    bodyMedium: TextStyle(
      fontSize: 25,
      color: Colors.white,
    ),
    bodySmall: TextStyle(
      fontSize: 15,
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
    padding: const WidgetStatePropertyAll(
      EdgeInsets.symmetric(horizontal: 15),
    ),
  ),
  textSelectionTheme: const TextSelectionThemeData(
    cursorColor: Colors.blue,
    selectionColor: Colors.blue,
    selectionHandleColor: Colors.blue,
  ),
  cardColor: Colors.grey.shade800,
  iconButtonTheme: const IconButtonThemeData(
    style: ButtonStyle(
      foregroundColor: WidgetStatePropertyAll(Colors.white),
    ),
  ),
);
