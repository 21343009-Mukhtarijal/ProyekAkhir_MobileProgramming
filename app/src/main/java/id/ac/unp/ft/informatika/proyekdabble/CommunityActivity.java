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

public class CommunityActivity extends AppCompatActivity {

    private TextView communityTitleTextView;
    private RecyclerView questionRecyclerView;
    private Button addQuestionButton;

    private List<Question> questionList; // Gantilah dengan model pertanyaan yang Anda miliki
    private QuestionAdapter questionAdapter; // Sesuaikan dengan adapter yang Anda buat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        // Inisialisasi komponen UI
        communityTitleTextView = findViewById(R.id.communityTitleTextView);
        questionRecyclerView = findViewById(R.id.questionRecyclerView);
        addQuestionButton = findViewById(R.id.addQuestionButton);

        // Mendapatkan data komunitas dari Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("community_id")) {
            int communityId = intent.getIntExtra("community_id", -1);
            // Implementasikan logika untuk mendapatkan data komunitas sesuai ID dari database atau sumber data lainnya
            // Misalnya, communityTitleTextView.setText(getCommunityTitleById(communityId));
        }

        // Inisialisasi daftar pertanyaan
        questionList = new ArrayList<>(); // Isi daftar pertanyaan sesuai kebutuhan

        // Inisialisasi adapter dan atur untuk RecyclerView
        questionAdapter = new QuestionAdapter(questionList); // Sesuaikan dengan adapter yang Anda buat
        questionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionRecyclerView.setAdapter(questionAdapter);

        // Set listener untuk menangani klik pada item pertanyaan
        questionAdapter.setOnItemClickListener(new QuestionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle navigasi ke halaman detail pertanyaan sesuai dengan posisi item yang diklik
                Question selectedQuestion = questionList.get(position);
                navigateToQuestionDetail(selectedQuestion);
            }
        });

        // Set listener untuk menangani klik tombol "Tambah Pertanyaan"
        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAddQuestion();
            }
        });
    }

    // Metode untuk membuat data pertanyaan dummy
    private List<Question> createDummyQuestions() {
        List<Question> dummyQuestions = new ArrayList<>();
        dummyQuestions.add(new Question(1, "Android Studio", "Saya sedang belajar Android Studio, Ajarin dong puh.. sepuh..."));
        dummyQuestions.add(new Question(2, "a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        dummyQuestions.add(new Question(3, "z", "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
        // Tambahkan pertanyaan lainnya sesuai kebutuhan
        return dummyQuestions;
    }

    // Metode untuk menangani navigasi ke halaman detail pertanyaan
    private void navigateToQuestionDetail(Question selectedQuestion) {
        // Implementasikan navigasi ke halaman detail pertanyaan dengan mengirim data yang dibutuhkan
        Intent intent = new Intent(this, QuestionDetailActivity.class);
        intent.putExtra("question_id", selectedQuestion.getId());
        startActivity(intent);
    }

    // Metode untuk menangani navigasi ke halaman tambah pertanyaan
    private void navigateToAddQuestion() {
        Intent intent = new Intent(this, AddQuestionActivity.class);
        startActivity(intent);
    }
}