import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:note_app/src/data/local/note.dart';
import 'package:note_app/src/presentation/viewmodel/note_viewmodel.dart';
import 'package:note_app/src/presentation/routing/app_routes.dart';
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
      child: Card(
        child: InkWell(
          onTap: () => context.go(
            '${AppRoutes.homePath}/${AppRoutes.notePath}',
            extra: note,
          ),
          child: ListTile(
            title: Padding(
              padding: const EdgeInsets.only(bottom: 20.0),
              child: Text(
                note.title,
                overflow: TextOverflow.ellipsis,
                maxLines: 1,
              ),
            ),
            subtitle: Text(
              note.body,
              overflow: TextOverflow.ellipsis,
              maxLines: 1,
            ),
            trailing: IconButton(
              onPressed: () => noteViewModel.deleteNote(note),
              icon: const Icon(Icons.delete),
            ),
          ),
        ),
      ),
    );
  }
}
