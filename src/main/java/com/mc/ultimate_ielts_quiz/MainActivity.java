package com.mc.ultimate_ielts_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private int highscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

        Button button_listening = findViewById(R.id.button_listening);
        button_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startListening();
            }
        });

        Button button_speaking = findViewById(R.id.button_speaking);
        button_speaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSpeaking();
            }
        });

        Button button_reading = findViewById(R.id.button_reading);
        button_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startReading();
            }
        });

        Button button_writing = findViewById(R.id.button_writing);
        button_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWriting();
            }
        });

        Button button_intro = findViewById(R.id.button_intro);
        button_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntro();
            }
        });

        Button button_grammar = findViewById(R.id.button_grammar);
        button_grammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGrammar();
            }
        });

        Button button_preparation = findViewById(R.id.button_pre);
        button_preparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPre();
            }
        });

        Button button_vocabulary = findViewById(R.id.button_Vocabulary);
        button_vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVocabulary();
            }
        });

    }

    private void startQuiz() {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    private void startListening() {
        Intent intent = new Intent(MainActivity.this, ListeningActivity.class);
        startActivity(intent);
    }

    private void startSpeaking() {
        Intent intent = new Intent(MainActivity.this, SpeakingActivity.class);
        startActivity(intent);
    }

    private void startReading() {
        Intent intent = new Intent(MainActivity.this, ReadingActivity.class);
        startActivity(intent);
    }

    private void startWriting() {
        Intent intent = new Intent(MainActivity.this, WritingActivity.class);
        startActivity(intent);
    }

    private void startIntro() {
        Intent intent = new Intent(MainActivity.this, IntroActivity.class);
        startActivity(intent);
    }

    private void startGrammar() {
        Intent intent = new Intent(MainActivity.this, GrammarActivity.class);
        startActivity(intent);
    }

    private void startPre() {
        Intent intent = new Intent(MainActivity.this, PreparationActivity.class);
        startActivity(intent);
    }

    private void startVocabulary() {
        Intent intent = new Intent(MainActivity.this, VocabularyActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }
    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}