package com.mc.ultimate_ielts_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mc.ultimate_ielts_quiz.QuizContract.QuestionsTable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UltimateIELTSQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDbHelper instance;
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("What is the synonyms of 'Abate' ", "Reduce", "Intensify", "Enhance", 1);
        addQuestion(q1);
        Question q2 = new Question("What is the synonyms of 'Abundant'?", "Insufficient", "Meager", "Copious", 3);
        addQuestion(q2);
        Question q3 = new Question("What is the synonyms of 'Admire'?", "Mock", "Respect", "Criticise", 2);
        addQuestion(q3);
        Question q4 = new Question("What is the synonyms of 'Anxious'?", "Nervous", "Unwilling", "Assured", 1);
        addQuestion(q4);
        Question q5 = new Question("What is the synonyms of 'Annoy'?", "Clam", "Please", "Irritate", 3);
        addQuestion(q5);

        Question q6 = new Question("What is the antonyms of 'Beneficial'?", "Useful", "Malignant", "Advantageous", 2);
        addQuestion(q6);
        Question q7 = new Question("What is the antonyms of 'Blame'?", "Admire", "Criticize", "Reproach", 1);
        addQuestion(q7);
        Question q8 = new Question("What is the antonyms of 'Bounty'?", "Reward", "Penalty", "Gift", 2);
        addQuestion(q8);
        Question q9 = new Question("What is the antonyms of 'Brief'?", "Short", "Temporary", "Lengthy", 3);
        addQuestion(q9);
        Question q10 = new Question("What is the antonyms of 'Brutal'?", "Cruel", "Inhuman", "Kind", 3);
        addQuestion(q10);

        Question q11 = new Question("What is the synonyms of 'Candid'?", "Frank", "Artful", "Devious", 1);
        addQuestion(q11);
        Question q12 = new Question("What is the synonyms of 'Careless'?", "Aware", "Negligent", "Attentive", 2);
        addQuestion(q12);
        Question q13 = new Question("What is the synonyms of 'Coalesce'?", "Split", "Divide", "Merge", 3);
        addQuestion(q13);
        Question q14 = new Question("What is the synonyms of 'Deliberate'?", "Preplanned", "Hurried", "Rash", 1);
        addQuestion(q14);
        Question q15 = new Question("What is the synonyms of 'Diminish'?", "Intensify", "Reduce", "Appreciate", 2);
        addQuestion(q15);

        Question q16 = new Question("What is the synonyms of 'Durable'?", "Breakable", "Lasting", "Fragile", 2);
        addQuestion(q16);
        Question q17 = new Question("What is the antonyms of 'Endanger'?", "Shield", "Hazard", "Imperil", 1);
        addQuestion(q17);
        Question q18 = new Question("What is the antonyms of 'Expose'?", "Parade", "Reveal", "Cover", 3);
        addQuestion(q18);
        Question q19 = new Question("What is the synonyms of 'Flatter'?", "Toady", "Censure", "Chide", 1);
        addQuestion(q19);
        Question q20 = new Question("What is the synonyms of 'Flexible'?", "Stable", "Elastic", "Stiff", 2);
        addQuestion(q20);

    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " ORDER BY RANDOM() LIMIT 5", null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
