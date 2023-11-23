package id.ac.unp.ft.informatika.proyekdabble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class QuestionDetailActivity extends AppCompatActivity {

    private TextView questionTitleTextView;
    private TextView questionDescriptionTextView;
    private RecyclerView answerRecyclerView;
    private Button addAnswerButton;

    private List<Answer> answerList; // Gantilah dengan model jawaban yang Anda miliki
    private AnswerAdapter answerAdapter; // Sesuaikan dengan adapter yang Anda buat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);

        // Inisialisasi komponen UI
        questionTitleTextView = findViewById(R.id.questionTitleTextView);
        questionDescriptionTextView = findViewById(R.id.questionDescriptionTextView);
        answerRecyclerView = findViewById(R.id.answerRecyclerView);
        addAnswerButton = findViewById(R.id.addAnswerButton);

        // Mendapatkan data pertanyaan dari Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("question_id")) {
            int questionId = intent.getIntExtra("question_id", -1);
            // Implementasikan logika untuk mendapatkan data pertanyaan sesuai ID dari database atau sumber data lainnya
            // Misalnya, Question question = getQuestionById(questionId);
            // questionTitleTextView.setText(question.getTitle());
            // questionDescriptionTextView.setText(question.getDescription());
        }

        // Inisialisasi daftar jawaban
        answerList = new ArrayList<>(); // Isi daftar jawaban sesuai kebutuhan

        // Inisialisasi adapter dan atur untuk RecyclerView
        answerAdapter = new AnswerAdapter(answerList); // Sesuaikan dengan adapter yang Anda buat
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        answerRecyclerView.setAdapter(answerAdapter);

        // Set listener untuk menangani klik tombol "Tambah Jawaban"
        addAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAddAnswer();
            }
        });
    }

    // Metode untuk menangani navigasi ke halaman tambah jawaban
    private void navigateToAddAnswer() {
        Intent intent = new Intent(this, AddAnswerActivity.class);
        startActivity(intent);
    }
}