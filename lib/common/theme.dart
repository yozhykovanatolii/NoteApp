import 'package:flutter/material.dart';

final themeData = ThemeData(
  scaffoldBackgroundColor: Colors.grey.shade900,
  floatingActionButtonTheme: FloatingActionButtonThemeData(
    backgroundColor: Colors.amber,
    foregroundColor: Colors.white,
  ),
  textTheme: TextTheme(
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
    hintStyle: WidgetStatePropertyAll(
      TextStyle(
        fontSize: 23,
        color: Colors.grey,
      ),
    ),
    textStyle: WidgetStatePropertyAll(
      TextStyle(
        fontSize: 23,
        color: Colors.white,
      ),
    ),
    padding: WidgetStatePropertyAll(
      EdgeInsets.symmetric(horizontal: 15),
    ),
  ),
  textSelectionTheme: TextSelectionThemeData(
    cursorColor: Colors.blue,
    selectionColor: Colors.blue,
    selectionHandleColor: Colors.blue,
  ),
  cardColor: Colors.grey.shade800,
  iconButtonTheme: IconButtonThemeData(
    style: ButtonStyle(
      foregroundColor: WidgetStatePropertyAll(Colors.white),
    ),
  ),
);
