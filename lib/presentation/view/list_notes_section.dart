import 'package:flutter/material.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/presentation/view/note_detail_page.dart';
import 'package:note_app/presentation/viewmodel/note_viewmodel.dart';
import 'package:provider/provider.dart';

class ListNotesSection extends StatelessWidget {
  const ListNotesSection({super.key});

  @override
  Widget build(BuildContext context) {
    final notes = context.watch<NoteViewModel>().notes;
    return ListView.builder(
      itemCount: notes.length,
      itemExtent: 110,
      itemBuilder: (_, index) {
        return _NoteCard(
          note: notes[index],
        );
      },
    );
  }
}

class _NoteCard extends StatelessWidget {
  final Note note;

  const _NoteCard({
    super.key,
    required this.note,
  });

  @override
  Widget build(BuildContext context) {
    final noteViewModel = context.read<NoteViewModel>();
    return Padding(
      padding: EdgeInsets.all(8),
      child: Container(
        padding: EdgeInsets.symmetric(horizontal: 10, vertical: 15),
        decoration: BoxDecoration(
          color: Theme.of(context).cardColor,
          borderRadius: BorderRadius.all(
            Radius.circular(10),
          ),
        ),
        child: InkWell(
          onTap: () => Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => NoteDetailPage(
                note: note,
              ),
            ),
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisSize: MainAxisSize.min,
                  spacing: 20,
                  children: [
                    Text(
                      note.title,
                      style: Theme.of(context).textTheme.bodySmall,
                      overflow: TextOverflow.ellipsis,
                      maxLines: 1,
                    ),
                    Text(
                      note.body,
                      style: Theme.of(context).textTheme.bodySmall,
                      overflow: TextOverflow.ellipsis,
                      maxLines: 1,
                    ),
                  ],
                ),
              ),
              IconButton(
                onPressed: () => noteViewModel.deleteNote(note),
                icon: Icon(Icons.delete),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
