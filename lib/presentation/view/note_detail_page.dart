import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:note_app/data/local/note.dart';
import 'package:note_app/presentation/viewmodel/note_viewmodel.dart';
import 'package:provider/provider.dart';

class NoteDetailPage extends StatefulWidget {
  final Note? note;

  const NoteDetailPage({
    super.key,
    required this.note,
  });

  @override
  State<NoteDetailPage> createState() => _NoteDetailPageState();
}

class _NoteDetailPageState extends State<NoteDetailPage> {
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _bodyController = TextEditingController();

  @override
  void initState() {
    super.initState();
    _titleController.text = widget.note?.title ?? '';
    _bodyController.text = widget.note?.body ?? '';
  }

  @override
  void dispose() {
    super.dispose();
    _titleController.dispose();
    _bodyController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final viewModel = context.read<NoteViewModel>();
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(8),
        child: ListView(
          children: [
            TextField(
              controller: _titleController,
              decoration: const InputDecoration(
                border: InputBorder.none,
                hintText: 'Title',
              ),
            ),
            TextField(
              maxLines: null,
              keyboardType: TextInputType.multiline,
              controller: _bodyController,
              decoration: const InputDecoration(
                border: InputBorder.none,
                hintText: 'Type something here',
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          viewModel.setNote(
            _titleController.text,
            _bodyController.text,
            widget.note,
          );
          context.go('/home');
        },
        shape: const CircleBorder(),
        child: const Icon(Icons.save),
      ),
    );
  }
}
