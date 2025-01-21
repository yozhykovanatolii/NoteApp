import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/presentation/page/home_page.dart';
import 'package:note_app/presentation/page/note_detail_page.dart';
import 'package:note_app/presentation/routing/app_routes.dart';

class AppRouterHelper {
  static final AppRouterHelper _instance = AppRouterHelper._internal();
  static late final GoRouter router;
  static final GlobalKey<NavigatorState> _parentNavigatorKey =
      GlobalKey<NavigatorState>();

  static AppRouterHelper get instance => _instance;

  factory AppRouterHelper() {
    return _instance;
  }

  AppRouterHelper._internal() {
    final routes = [
      GoRoute(
        path: AppRoutes.homePath,
        builder: (context, state) {
          return const HomePage();
        },
        routes: <RouteBase>[
          GoRoute(
            path: AppRoutes.notePath,
            builder: (context, state) {
              final Note? note = state.extra as Note?;
              return NoteDetailPage(note: note);
            },
          ),
        ],
      ),
    ];
    router = GoRouter(
      initialLocation: AppRoutes.homePath,
      navigatorKey: _parentNavigatorKey,
      routes: routes,
    );
  }
}
