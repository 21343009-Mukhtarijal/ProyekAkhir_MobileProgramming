package id.ac.unp.ft.informatika.proyekdabble;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private TextInputLayout textInputLayoutEmail, textInputLayoutPassword;
    private Button btnLogin;
    private TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegistration();
            }
        });
    }

    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            textInputLayoutEmail.setError("Email tidak boleh kosong");
            return;
        } else {
            textInputLayoutEmail.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            textInputLayoutPassword.setError("Password tidak boleh kosong");
            return;
        } else {
            textInputLayoutPassword.setError(null);
        }

        // TODO: Implementasi logika autentikasi sesuai kebutuhan aplikasi Anda.
        // Dalam contoh ini, autentikasi berhasil jika email adalah "user@example.com" dan password adalah "password".
        if (email.equals("rijal@gmail.com") && password.equals("rahasia")) {
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();

            // Pindah ke halaman utama aplikasi (misalnya, HomeActivity)
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Selesaikan aktivitas LoginActivity agar tidak dapat dikembali.
        } else {
            Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToRegistration() {
        // Pindah ke halaman registrasi (misalnya, RegistrationActivity)
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}