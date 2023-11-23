package id.ac.unp.ft.informatika.proyekdabble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddCommunityActivity extends AppCompatActivity {

    private EditText communityNameEditText;
    private Button addCommunityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_community);

        // Inisialisasi UI
        communityNameEditText = findViewById(R.id.communityNameEditText);
        addCommunityButton = findViewById(R.id.addCommunityButton);

        // Set listener untuk tombol "Tambah Komunitas"
        addCommunityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCommunity();
            }
        });
    }

    private void addCommunity() {
        String communityName = communityNameEditText.getText().toString().trim();

        if (communityName.isEmpty()) {
            communityNameEditText.setError("Nama Komunitas tidak boleh kosong");
            return;
        }

        // Implementasikan logika untuk menambah komunitas ke database atau sumber data lainnya
        // Di sini Anda harus menggantinya dengan logika sesuai dengan kebutuhan aplikasi Anda

        // Contoh: Menyimpan ke database (simulasi)
        saveCommunityToDatabase(communityName);

        finish();
    }

    private void saveCommunityToDatabase(String communityName) {
        // Di sini, Anda harus menggantinya dengan logika penyimpanan data sesuai dengan kebutuhan aplikasi Anda
        // Misalnya, menggunakan Room, SQLite, atau backend API
        // Implementasikan sesuai dengan arsitektur aplikasi Anda
    }
}
