import 'package:flutter/material.dart';
import 'package:note_app/presentation/view/list_notes_section.dart';
import 'package:note_app/presentation/view/note_detail_page.dart';
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
        padding: EdgeInsets.all(10),
        child: Column(
          spacing: 30,
          children: [
            SearchBar(
              hintText: 'Search notes',
              onChanged: (searchText) =>
                  noteViewModel.setSearchText(searchText),
            ),
            Expanded(
              child: const ListNotesSection(),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => NoteDetailPage(note: null),
          ),
        ),
        shape: CircleBorder(),
        child: Icon(Icons.add),
      ),
    );
  }
}
