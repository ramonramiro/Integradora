package com.principal.subnetting.easy.games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.principal.subnetting.easy.R;

import java.util.Locale;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers[] = {
            R.id.rdb_answer_one, R.id.rdb_answer_two, R.id.rdb_answer_three, R.id.rdb_answer_four
    };


    int questionFirst = 0;
    int count = 0;


    private int correctAnswer;
    private int currentQuestion;
    private String[] allQuestions;
    private boolean[] answerIsCorrect;
    private int[] answer;
    private TextView tvQuestion;
    private RadioGroup rdgGroupAnswer;
    private Button btNext, btReturn;

    int [] questionsAnswered = new int[4];

    private int generateQuestion() {
        int value;
        boolean isFound = false;
        do {
            isFound =false;
            Random random = new Random(System.currentTimeMillis());
            random.setSeed(System.currentTimeMillis());
            value = random.nextInt(5);
            for(int i =0; i < answer.length; i++) {
                if (answer[i]== value){
                    isFound = true;
                    break;
                }
            }
        } while(isFound);
        count++;
        return value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion =  findViewById(R.id.text_question_principal);
        rdgGroupAnswer = findViewById(R.id.rdg_answer_group);
        btNext = findViewById(R.id.bt_check);
        btReturn = findViewById(R.id.bt_previous_question);

        init();
        questionsAnswered[questionFirst] = currentQuestion;

        //Carga preguntas
        allQuestions = getResources().getStringArray(R.array.all_questions);
        //Inicializa respuestas correctas
        answerIsCorrect = new boolean[allQuestions.length];
        answer = new int[allQuestions.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        showQuestion();

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Log.d("Contador", count+"");
                if (count<=5) {
                    checkAnswer();
                    currentQuestion = generateQuestion();
                    showQuestion();
                }
                else{
                    Toast.makeText(QuizActivity.this, R.string.finish_question , Toast.LENGTH_LONG).show();
                    int correct = 0, incorrect = 0;
                    for (boolean b : answerIsCorrect) {
                        if (b) correct++;
                        else incorrect++;
                    }
                    String result =
                            String.format(Locale.getDefault(), getString(R.string.correct_answer), correct, incorrect);

                    Toast.makeText(QuizActivity.this, result, Toast.LENGTH_LONG).show();

                    finish();
                }
            }
        });

        btReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (currentQuestion > 0) {
                    currentQuestion--;
                    showQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        int id = rdgGroupAnswer.getCheckedRadioButtonId();
        int ans = -1;
        for (int i = 0; i < ids_answers.length; i++) {
            if (ids_answers[i] == id) {
                ans = i;
            }
        }
        answerIsCorrect[currentQuestion] = (ans == correctAnswer);
        answer[currentQuestion] = ans;

    }


    private void showQuestion() {

        currentQuestion = generateQuestion();

        String q = allQuestions[currentQuestion];
        String[] parts = q.split(";");

        rdgGroupAnswer.clearCheck();

        tvQuestion.setText(count+" " +parts[0]);

        for (int i = 0; i < ids_answers.length; i++) {
            RadioButton rdb = findViewById(ids_answers[i]);
            String ans = parts[i + 1];
            if (ans.charAt(0) == '*') {
                correctAnswer = i;
                ans = ans.substring(1);
            }
            rdb.setText(ans);
        }
    }

    void init() {

        for (int i = 0; i < questionsAnswered.length; i++) {
            questionsAnswered[i] = -1;
        }

    }
}
