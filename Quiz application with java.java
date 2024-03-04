/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp{
    static int currentQuestionIndex=0;
    static int userScore=0;
    static Question[] questions;
    static Timer timer;
    
    public static void main(astring[] args){
        initialiseQuestions();
        startQuiz();
    }
    static void initialiseQuestions(){
        
        questions=new Question[3];
        questions[0]=new Question(questionText:"What is the capital of France?",new String[]{"London","Paris","Delhi"});
        questions[1]=new Question(questionText:"Which planet is known as Red Planet?",new String[]{"Earth","Mars","Jupiter","Venus"});
        questions[2]=new Question(questionText:"What is the Largest Mammal?",new String[]{"Blue Whale","Tiger","Lion","Bat"});
        
    }
    static void startQuiz(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the Quiz!");
        System.out.println("-------------");
        timer =new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                System.out.println(x:"\nTime's up! Moving to the next question." );
                displayNextQuestion();
            }
        },delay:20000);
        
        displayNextQuestion();
    }
    static void displayNextQuestion(){
        if(currentQuestionIndex<questions.length){
            Question currentQuestion=questions[currentQuestionIndex];
            System.out.println("\n"+currentQuestion.getOptions());
            
            for(int i=0;i<currentQuestion.getOptions().length;i++){
                System.out.println((i+1)+"."+currentQuestion.getOptions()[i]);
            }
            Scanner scanner =new Scanner(System.in);
            System.out.println("Select your answer(1-" +currentQuestionQuestion.getOptions().length+"):");
            int userAnswer=scanner.nextInt()-1;
            if(userAnswer==currentQuestion.getCorrectAnswer()){
                userScore++;
            }
            currentQuestionIndex++;
            timer.cancel();
            timer=new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    System.out.println("\nTime's up! Moving to the next question.");
                    displayNextQuestion();
                }
            },delay:20000);
            displayNextQuestion();
            
        }else{
            endQuiz();
        }
    }
    static void endQuiz(){
        System.out.println("\nQuiz Finished!");
        System.out.println("Your score:"+userScore+"/"+questions.length);
        System.out.println("Thank You for playing!");
    }
}
class Question{
    private String questionText;
    private String[] options;
    private int correctAnswer;
    
    public Question(String questionText,String[] options,int correctAnswer){
        this.questionText=questionText;
        this.options=options;
        this.correctAnswer=correctAnswer;
}
public String getQuestionText(){
    return questionText;
}
public String[] getOptions(){
    return options;
}}