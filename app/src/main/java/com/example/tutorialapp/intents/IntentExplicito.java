package com.example.tutorialapp.intents;

import static com.example.tutorialapp.R.id.buttonComprar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentExplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_explicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botonComprar = findViewById(buttonComprar);

        EditText editTextComida = findViewById(R.id.editTextComida);
        EditText editTextBebida = findViewById(R.id.editTextBebida);

        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntentExplicito.this, IntentImplicito.class);

                //Add parameters
                i.putExtra("Prueba" , "Hamburguesa");
                i.putExtra("Comida", editTextComida.getText().toString());
                i.putExtra("Bebida", editTextBebida.getText().toString());

                startActivity(i);
            }
        });
    }
}