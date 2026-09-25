package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnVoltar, btnProx;
    ImageView imageView;
    int posicao = 0;
    Integer[]imagens = new Integer[]{
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho,
            R.drawable.porquinho,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnVoltar=findViewById(R.id.btnVoltar);
        btnProx=findViewById(R.id.btnProx);
        imageView =findViewById(R.id.ImageView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnProx.setOnClickListener(v ->{
            if (posicao < imagens.length)
                imageView.setImageResource(imagens[posicao]);
            posicao++;
                });

        btnVoltar.setOnClickListener(v ->{
            if (posicao < imagens.length)
                imageView.setImageResource(imagens[posicao]);
            posicao--;
        });

    }
}