import 'package:go_router/go_router.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/presentation/view/home_page.dart';
import 'package:note_app/presentation/view/note_detail_page.dart';

final router = GoRouter(
  initialLocation: '/home',
  routes: [
    GoRoute(
      path: '/home',
      builder: (context, state) {
        return const HomePage();
      },
      routes: <RouteBase>[
        GoRoute(
          path: 'note',
          builder: (context, state) {
            final Note? note = state.extra as Note?;
            return NoteDetailPage(note: note);
          },
        ),
      ],
    ),
  ],
);
