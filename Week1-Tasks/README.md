
Command-Line Quiz Generator

This Java program is a command-line based quiz generator that allows the user to:
1. Create quizzes
2. Add questions with multiple-choice options
3. Take quizzes
4. View all available quizzes
5. Exit the program

1. Menu Commands

Command  Functionality
1        Create a new quiz (by providing a unique title)
2        Add a multiple-choice question to an existing quiz
3        Start and take a quiz (answer questions, get score and feedback)
4        List all created quizzes
5        Exit the application

2. Functional Commands

- quizzes.put(title, new Quiz(title))
  Adds a new quiz to the map `quizzes`.
  `title` is the quiz name (key), `new Quiz(title)` is the object stored (value).

- quizzes.containsKey(title)
  Checks if a quiz with the given title already exists to prevent duplicates.

- quizzes.get(title)
  Retrieves a quiz object to add questions or start the quiz.

- questions.add(q)
  Adds a question to the quiz's list of questions.

- Scanner sc = new Scanner(System.in)
  Takes user input from the command line.

- System.out.println(...)
  Prints instructions, questions, options, and results to the user.

- sc.nextInt() / sc.nextLine()
  Reads user input: `nextInt()` for numbers, `nextLine()` for text.

3. Data Structures Used

Structure               Purpose

Map<String, Quiz>       Stores quizzes by title
List<Question>          Stores multiple questions in each quiz
List<String>            Stores multiple options in each question

4. Feedback Logic

After quiz completion:
- If score ≥ 80%, shows "Excellent! "
- If score ≥ 50%, shows "Good job! "
- Otherwise, shows "Keep practicing! "

5. Classes Defined

Question class:
- questionText: Text of the question
- options: List of 4 options
- correctOption: Index (1–4) of the correct option

Quiz class:
- title: Quiz title
- questions: List of Question objects
- addQuestion(): Adds a question to the quiz
- start(): Runs the quiz, scores answers, gives feedback
