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

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextFullName, editTextNewEmail, editTextNewPassword, editTextConfirmPassword;
    private TextInputLayout textInputLayoutFullName, textInputLayoutNewEmail, textInputLayoutNewPassword, textInputLayoutConfirmPassword;
    private Button btnRegister;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextFullName = findViewById(R.id.editTextFullName);
        editTextNewEmail = findViewById(R.id.editTextNewEmail);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        textInputLayoutFullName = findViewById(R.id.textInputLayoutFullName);
        textInputLayoutNewEmail = findViewById(R.id.textInputLayoutNewEmail);
        textInputLayoutNewPassword = findViewById(R.id.textInputLayoutNewPassword);
        textInputLayoutConfirmPassword = findViewById(R.id.textInputLayoutConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    private void registerUser() {
        String fullName = editTextFullName.getText().toString().trim();
        String email = editTextNewEmail.getText().toString().trim();
        String password = editTextNewPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        // Validasi input
        if (TextUtils.isEmpty(fullName)) {
            textInputLayoutFullName.setError("Nama lengkap tidak boleh kosong");
            return;
        } else {
            textInputLayoutFullName.setError(null);
        }

        if (TextUtils.isEmpty(email)) {
            textInputLayoutNewEmail.setError("Email tidak boleh kosong");
            return;
        } else {
            textInputLayoutNewEmail.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            textInputLayoutNewPassword.setError("Password tidak boleh kosong");
            return;
        } else {
            textInputLayoutNewPassword.setError(null);
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            textInputLayoutConfirmPassword.setError("Konfirmasi password tidak boleh kosong");
            return;
        } else {
            textInputLayoutConfirmPassword.setError(null);
        }

        // Validasi password
        if (!password.equals(confirmPassword)) {
            textInputLayoutConfirmPassword.setError("Password dan konfirmasi password harus sama");
            return;
        } else {
            textInputLayoutConfirmPassword.setError(null);
        }

        // TODO: Implementasi logika pendaftaran sesuai kebutuhan aplikasi Anda.
        // Dalam contoh ini, pendaftaran berhasil tanpa validasi email atau password.
        Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();

        // Pindah ke halaman login setelah pendaftaran berhasil
        navigateToLogin();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Selesaikan aktivitas RegisterActivity agar tidak dapat dikembali.
    }
}
