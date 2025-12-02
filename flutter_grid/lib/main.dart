import 'package:flutter/material.dart';

void main() {
  runApp(const GridNameApp());
}

class GridNameApp extends StatelessWidget {
  const GridNameApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '3x3 Grid Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.indigo),
        useMaterial3: true,
      ),
      home: const GridNamePage(),
    );
  }
}

class GridNamePage extends StatefulWidget {
  const GridNamePage({super.key});

  @override
  State<GridNamePage> createState() => _GridNamePageState();
}

class _GridNamePageState extends State<GridNamePage> {
  late final List<TextEditingController> _controllers;

  @override
  void initState() {
    super.initState();
    _controllers = List.generate(
      9,
      (index) => TextEditingController(text: '셀 ${index + 1}'),
    );
  }

  @override
  void dispose() {
    for (final controller in _controllers) {
      controller.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('3x3 명칭 입력'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            const Text('각 칸에 원하는 명칭을 입력하세요.'),
            const SizedBox(height: 16),
            Expanded(
              child: GridView.count(
                crossAxisCount: 3,
                crossAxisSpacing: 12,
                mainAxisSpacing: 12,
                children: List.generate(9, (index) {
                  return Card(
                    elevation: 2,
                    child: Padding(
                      padding: const EdgeInsets.all(8),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          Text('칸 ${index + 1}',
                              style: Theme.of(context).textTheme.titleMedium),
                          const SizedBox(height: 8),
                          Expanded(
                            child: TextField(
                              controller: _controllers[index],
                              decoration: const InputDecoration(
                                border: OutlineInputBorder(),
                                labelText: '명칭 입력',
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  );
                }),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
