package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*Button b=  findViewById(R.id.button);

        TextView tv= findViewById(R.id.textView2);

        b.setOnClickListener(view -> {
            c++;
            tv.setText(Integer.toString(c));
        }); */

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Associar componetes da IU
        EditText edMin, edMax;
        edMin = findViewById(R.id.edMIn);
        edMax = findViewById(R.id.edMax);

        TextView textView = findViewById(R.id.textView2);
        Button s= findViewById(R.id.button);


        s.setOnClickListener(view -> {
            Random random = new Random();
            String smin= edMin.getText().toString();
            String smax= edMax.getText().toString();
            if (smin.trim().equals("")){
                edMin.setError("Informar valor");
                edMin.requestFocus();
                return;
            }

            if (smax.trim().equals("")){
                edMax.setError("Informar valor");
                edMax.requestFocus();
                return;
            }


            int min = Integer.parseInt(edMin.getText().toString());
            int max = Integer.parseInt(edMax.getText().toString());
            if (min>=max){
                edMax.setError("Mínimo deve ser menor que o máximo");
                return;
            }

            int r= (random.nextInt(max-min)+min);

            textView.setText(Integer.toString(r)); //setar valor

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("valor", r);

            startActivity(intent);


        });

    }
}