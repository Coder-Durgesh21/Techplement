import java.util.*;

public class QuizGenerator 
{
    static class Question 
    {
        String questionText;
        List<String> options;
        int correctOption;

        public Question(String questionText, List<String> options, int correctOption) 
        {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    static class Quiz 
    {
        String title;
        List<Question> questions = new ArrayList<>();

        public Quiz(String title) 
        {
            this.title = title;
        }

        public void addQuestion(Question q) 
        {
            questions.add(q);
        }

        public void start() 
        {
            Scanner sc = new Scanner(System.in);
            int score = 0;
            System.out.println("\nStarting quiz: " + title);
            System.out.println("--------------------------");

            for(int i = 0; i < questions.size(); i++) 
            {
                Question q = questions.get(i);
                System.out.println("\nQ" + (i + 1) + ". " + q.questionText);
                for(int j = 0; j < q.options.size(); j++) 
                {
                    System.out.println((j + 1) + ") " + q.options.get(j));
                }

                System.out.print("Your answer (1-4): ");
                int ans = sc.nextInt();

                if (ans == q.correctOption) 
                {
                    System.out.println(" Correct ");
                    score++;
                } 
                else 
                {
                    System.out.println(" Incorrect, Correct answer is: " + q.correctOption);
                }
            }

            System.out.println("\n Quiz Complete");
            System.out.println("Your score: " + score + " / " + questions.size());

            double percent = (score * 100.0) / questions.size();
            if (percent >= 80)
            {
                System.out.println("Excellent");
            }
            else if (percent >= 50)
            {
                System.out.println("Good job ");
            }    
            else
            {
                System.out.println("Keep practicing ");
            }    
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

    System.out.println("--------------------Quiz Generator--------------------");

    System.out.println("--------------------Welcome to Quiz Generator--------------------");

    System.out.println("--------------------Quiz Generator Starts--------------------");
        Map<String, Quiz> quizzes = new HashMap<>();

        while (true) 
        {
            System.out.println("Quiz Generator Menu");
            System.out.println("1. Create a new Quiz");
            System.out.println("2. Add Question to Quiz");
            System.out.println("3. Take a Quiz");
            System.out.println("4. List All Quizzes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter quiz title: ");
                    String title = sc.nextLine();
                    if (quizzes.containsKey(title))
                    {
                        System.out.println("Quiz with that title already exists");
                    } 
                    else 
                    {
                        quizzes.put(title, new Quiz(title));
                        System.out.println("Quiz created: " + title);
                    }
                    break;

                case 2:
                    System.out.print("Enter quiz title to add question: ");
                    String qTitle = sc.nextLine();
                    if (!quizzes.containsKey(qTitle)) 
                    {
                        System.out.println("Quiz not found.");
                        break;
                    }

                    System.out.print("Enter question: ");

                    String qText = sc.nextLine();
                    List<String> options = new ArrayList<>();
                    for (int i = 1; i <= 4; i++)
                    {
                        System.out.print("Option " + i + ": ");
                        options.add(sc.nextLine());
                    }

                    System.out.print("Enter correct option number (1-4): ");
                    int correct = sc.nextInt();
                    sc.nextLine();
                    quizzes.get(qTitle).addQuestion(new Question(qText, options, correct));
                    System.out.println("Question added.");
                    break;

                case 3:
                    System.out.print("Enter quiz title to start: ");
                    String playTitle = sc.nextLine();
                    if (!quizzes.containsKey(playTitle))
                    {
                        System.out.println("Quiz not found.");
                        break;
                    }
                    quizzes.get(playTitle).start();
                    break;

                case 4:
                    System.out.println("Available Quizzes:");
                    if (quizzes.isEmpty()) 
                    {
                        System.out.println("No quizzes available.");
                    } 
                    else 
                    {
                        for (String quizName : quizzes.keySet()) 
                        {
                            System.out.println("- " + quizName);
                        }
                    }
                    break;

                case 5:
                    System.out.println("--------------------Thank you for using Quiz Generator--------------------");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}