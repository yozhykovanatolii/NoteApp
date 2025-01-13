import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:note_app/presentation/view/widget/note_card_widget.dart';
import 'package:note_app/presentation/viewmodel/note_viewmodel.dart';
import 'package:provider/provider.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final noteViewModel = context.read<NoteViewModel>();
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).scaffoldBackgroundColor,
        title: Text(
          'Notes',
          style: Theme.of(context).textTheme.bodyLarge,
        ),
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
                builder: (context, viewModel, child) {
                  return ListView.builder(
                    itemCount: viewModel.notes.length,
                    itemExtent: 110,
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
        onPressed: () => context.go('/note', extra: null),
        shape: const CircleBorder(),
        child: const Icon(Icons.add),
      ),
    );
  }
}
