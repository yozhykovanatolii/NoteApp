import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';
import 'package:note_app/src/common/theme.dart';
import 'package:note_app/src/di/get_it_setup.dart';
import 'package:note_app/src/presentation/viewmodel/note_viewmodel.dart';
import 'package:note_app/src/presentation/routing/app_router.dart';
import 'package:provider/provider.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  GetItSetup.setupDependencies();
  await GetIt.instance.allReady();
  AppRouterHelper.instance;
  runApp(
    ChangeNotifierProvider(
      create: (_) => NoteViewModel(),
      child: const NoteApp(),
    ),
  );
}

class NoteApp extends StatelessWidget {
  const NoteApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      debugShowCheckedModeBanner: false,
      theme: themeData,
      routerConfig: AppRouterHelper.router,
    );
  }
}
