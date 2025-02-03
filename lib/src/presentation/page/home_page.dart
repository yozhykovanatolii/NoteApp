import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:note_app/src/presentation/page/widget/note_card_widget.dart';
import 'package:note_app/src/presentation/viewmodel/note_viewmodel.dart';
import 'package:note_app/src/presentation/routing/app_routes.dart';
import 'package:provider/provider.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final noteViewModel = context.read<NoteViewModel>();
    return Scaffold(
      appBar: AppBar(
        title: const Text('Notes'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(10),
        child: Column(
          spacing: 30,
          children: [
            SearchBar(
              hintText: 'Search notes',
              onChanged: (searchText) =>
                  noteViewModel.setSearchText(searchText),
            ),
            Expanded(
              child: Consumer<NoteViewModel>(
                builder: (_, viewModel, __) {
                  return ListView.builder(
                    itemCount: viewModel.notes.length,
                    itemBuilder: (_, index) {
                      return NoteCardWidget(
                        note: viewModel.notes[index],
                      );
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => context.go(
          '${AppRoutes.homePath}/${AppRoutes.notePath}',
          extra: null,
        ),
        shape: const CircleBorder(),
        child: const Icon(Icons.add),
      ),
    );
  }
}
