import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/presentation/viewmodel/note_viewmodel.dart';
import 'package:provider/provider.dart';

class NoteCardWidget extends StatelessWidget {
  final Note note;

  const NoteCardWidget({
    super.key,
    required this.note,
  });

  @override
  Widget build(BuildContext context) {
    final noteViewModel = context.read<NoteViewModel>();
    return Padding(
      padding: const EdgeInsets.all(8),
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 15),
        decoration: BoxDecoration(
          color: Theme.of(context).cardColor,
          borderRadius: const BorderRadius.all(
            Radius.circular(10),
          ),
        ),
        child: InkWell(
          onTap: () => context.go('/note', extra: note),
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
                icon: const Icon(Icons.delete),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
