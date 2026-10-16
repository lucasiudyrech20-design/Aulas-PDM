package com.example.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText edText;
    Button button;
    ListView List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas" + "(id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, conteudo VARCHAR)");

        setContentView(R.layout.activity_main);
        edText = findViewById(R.id.edText);
        button = findViewById(R.id.button);
        List = findViewById(R.id.List);

        button.setOnClickListener(v -> {
            {
                String titulo = edText.getText().toString();
                ContentValues values = new ContentValues();
                values.put("titulo", titulo);
                int id = (int) database.insert("notas", null, values);
                if (id > 0) {
                    Toast.makeText(getApplicationContext(), "Nota salva com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao salvar nota", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        public void listarNotas(){
            Cursor c= database.rawQuery("SELECT * FROM notas LIMIT ? ", new String[]{"100"});
        }



}