package com.example.playing_cards;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {
    //creating Instance of button and EditText
    Button sort,select;
    EditText e1,e2,e3,e4,e5,e6;
    int[] numbers = new int[5];
    public static int sum;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//intialization
        sort=findViewById(R.id.sortmain);
        select=findViewById(R.id.select);
        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e4=findViewById(R.id.editText4);
        e5=findViewById(R.id.editText5);
        e6=findViewById(R.id.sum);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort();
            }
        });
        try {
            if (sum==0){
                e6.setText("");
            }
            else{
                e6.setText(""+sum);
            }
//getting the Arrray back
            Bundle extras = getIntent().getExtras();
            int[] arrayC = extras.getIntArray("arrayC");
//typecasting
            e1.setText(""+arrayC[0]);
            e2.setText(""+arrayC[1]);
            e3.setText(""+arrayC[2]);
            e4.setText(""+arrayC[3]);
            e5.setText(""+arrayC[4]);
        }
        catch (Exception e){
        }
    }
    //sort function
    private void sort() {
        Intent i = new Intent(MainActivity.this, com.example.playing_cards.MainActivity2.class);
        i.putExtra("numbers", numbers);
        startActivity(i);
    }
    //random number generating
    private void generate() {
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*13 + 1);
        }
        e1.setText(""+numbers[0]);
        e2.setText(""+numbers[1]);
        e3.setText(""+numbers[2]);
        e4.setText(""+numbers[3]);
        e5.setText(""+numbers[4]);
    }
}
