package id.ac.unp.ft.informatika.proyekdabble;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class AddQuestionActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button postQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        // Inisialisasi komponen UI
        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        postQuestionButton = findViewById(R.id.postQuestionButton);

        // Set listener untuk menangani klik tombol "Post Pertanyaan"
        postQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode untuk memposting pertanyaan
                postQuestion();
            }
        });
    }

    // Metode untuk menangani proses posting pertanyaan
    private void postQuestion() {
        // Mendapatkan judul dan deskripsi dari formulir
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        // Validasi input
        if (title.isEmpty() || description.isEmpty()) {
            // Tampilkan pesan kesalahan jika ada kolom yang kosong
            showToast("Judul dan deskripsi pertanyaan tidak boleh kosong");
            return;
        }

        // Simulasi: Lakukan proses posting pertanyaan, misalnya, menyimpan ke database
        // Implementasikan logika sesuai dengan kebutuhan aplikasi Anda
        int questionId = saveQuestionToDatabase(title, description);

        if (questionId != -1) {
            // Jika posting berhasil, Anda dapat menutup activity ini
            showToast("Pertanyaan berhasil diposting");
            finish();
        } else {
            // Jika posting gagal, tampilkan pesan kesalahan
            showToast("Gagal memposting pertanyaan. Silakan coba lagi");
        }
    }

    // Metode untuk menyimpan pertanyaan ke database (simulasi)
    private int saveQuestionToDatabase(String title, String description) {
        // Implementasikan logika penyimpanan ke database di sini
        // belum tau pakai database apa
        // Tempatkan logika ini sesuai dengan arsitektur aplikasi Anda

        // Simulasi: Mengembalikan ID pertanyaan baru (gagal: -1)
        return 456; // ID pertanyaan baru
    }

    // Metode untuk menampilkan pesan menggunakan Toast
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}