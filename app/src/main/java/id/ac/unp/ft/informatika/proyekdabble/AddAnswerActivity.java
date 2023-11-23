package id.ac.unp.ft.informatika.proyekdabble;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddAnswerActivity extends AppCompatActivity {

    private EditText answerEditText;
    private Button postAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);

        // Inisialisasi komponen UI
        answerEditText = findViewById(R.id.answerEditText);
        postAnswerButton = findViewById(R.id.postAnswerButton);

        // Set listener untuk menangani klik tombol "Post Jawaban"
        postAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode untuk memposting jawaban
                postAnswer();
            }
        });
    }

    // Metode untuk menangani proses posting jawaban
    private void postAnswer() {
        // Mendapatkan konten jawaban dari formulir
        String answerContent = answerEditText.getText().toString().trim();

        // Validasi input
        if (answerContent.isEmpty()) {
            // Tampilkan pesan kesalahan jika kolom jawaban kosong
            showToast("Kolom jawaban tidak boleh kosong");
            return;
        }

        // Simulasi: Lakukan proses posting jawaban, misalnya, menyimpan ke database
        // Implementasikan logika sesuai dengan kebutuhan aplikasi
        int answerId = saveAnswerToDatabase(answerContent);

        if (answerId != -1) {
            // Jika posting berhasil, Anda dapat menutup activity ini
            showToast("Jawaban berhasil diposting");
            finish();
        } else {
            // Jika posting gagal, tampilkan pesan kesalahan
            showToast("Gagal memposting jawaban. Silakan coba lagi");
        }
    }

    // Metode untuk menyimpan jawaban ke database (simulasi)
    private int saveAnswerToDatabase(String answerContent) {
        // Implementasikan logika penyimpanan ke database di sini
        // pakai database apa belum tau
        // Tempatkan logika ini sesuai dengan arsitektur aplikasi

        // Simulasi: Mengembalikan ID jawaban baru (gagal: -1)
        return 123; // ID jawaban baru
    }

    // Metode untuk menampilkan pesan menggunakan Toast
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}