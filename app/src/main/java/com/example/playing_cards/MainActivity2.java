package com.example.playing_cards;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playing_cards.MainActivity;
import com.example.playing_cards.R;

import java.util.Arrays;
public class MainActivity2 extends AppCompatActivity {
    //making Instance Of TextView
    Button reply;
    EditText e11, e22, e33, e44, e55;
    //variable for sum of numbers
    int sum = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        reply = findViewById(R.id.reply);
        e11 = findViewById(R.id.editText6);
        e22 = findViewById(R.id.editText7);
        e33 = findViewById(R.id.editText8);
        e44 = findViewById(R.id.editText9);
        e55 = findViewById(R.id.editText10);
//Taking Intent Data in a array
        Bundle extras = getIntent().getExtras();
        int[] arrayB = extras.getIntArray("numbers");
        int[] arrayC = arrayB;
        Arrays.sort(arrayB);
//typecasting
        e11.setText("" + arrayB[0]);
        e22.setText("" + arrayB[1]);
        e33.setText("" + arrayB[2]);
        e44.setText("" + arrayB[3]);
        e55.setText("" + arrayB[4]);
//getting sum of all numbers
        for (int i = 0; i < arrayB.length; i++) {
            sum = sum + arrayB[i];
        }
//click listener for reply
        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//taking intent
                Intent i1 = new Intent(MainActivity2.this, MainActivity.class);
//appending value in sum variable of MainActivity
                MainActivity.sum = sum;
                i1.putExtra("arrayC", arrayC);
                startActivity(i1);
                finish();
            }
        });
    }
}
