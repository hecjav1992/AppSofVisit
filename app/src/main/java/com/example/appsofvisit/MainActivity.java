package com.example.appsofvisit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText edtuser;
    private EditText edtcontrasena;
    private Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.edtuser=(EditText)findViewById(R.id.edtUser);
        this.edtcontrasena=(EditText) findViewById(R.id.edtcontrasena);
        this.btnLogin=(Button) findViewById(R.id.btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarSeccion(edtuser.getText().toString(),edtcontrasena.getText().toString());
            }
        });

    }

    public void IniciarSeccion(String usuario,String contrasena){
        new Thread(() -> {
            try {
                String apiUrl = "https://easydatasoftvisitback.onrender.com/api/Loging/login";
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; utf-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);

                String jsonInputString = "{ \"usuario\": \"" + "admin" + "\", \"contrasena\": \"" + "$2b$10$r7HgU9cu6TBLb4JTk9EG1udmZpOwZmnTg1B7JQzB.G69C1tW4J8nO" + "\" }";

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {

                    runOnUiThread(() -> {
                        Toast.makeText(this, "leido"+responseCode, Toast.LENGTH_SHORT).show();
                    });

                } else {
                    Log.e("API", "Error en la respuesta: Código " + responseCode);
                }

                connection.disconnect();
            } catch (Exception e) {
                Log.e("API", "Error: " + e.getMessage());
            }
        }).start();
    }
}