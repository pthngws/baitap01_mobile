package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnProcessArray = findViewById(R.id.btnProcessArray);
        Button btnProcessString = findViewById(R.id.btnProcessString);
        EditText etInput = findViewById(R.id.etInput);
        TextView tvOutput = findViewById(R.id.tvOutput);
        EditText mangInput = findViewById(R.id.mangInput);
        
        btnProcessArray.setOnClickListener(v -> {
            String input = mangInput.getText().toString();
            if (!input.isEmpty()) {
                try {
                    String[] parts = input.split(",");
                    ArrayList<Integer> numbers = new ArrayList<>();
                    
                    for (String part : parts) {
                        numbers.add(Integer.parseInt(part.trim())); 
                    }

                    ArrayList<Integer> evenNumbers = new ArrayList<>();
                    ArrayList<Integer> oddNumbers = new ArrayList<>();

                    for (int num : numbers) {
                        if (num % 2 == 0) {
                            evenNumbers.add(num);
                        } else {
                            oddNumbers.add(num);
                        }
                    }

                    Log.d("EvenNumbers", evenNumbers.toString());
                    Log.d("OddNumbers", oddNumbers.toString());

                    tvOutput.setText("Số chẵn: " + evenNumbers + "\nSố lẻ: " + oddNumbers);

                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Vui lòng nhập các số hợp lệ, cách nhau bằng dấu phẩy!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập danh sách số!", Toast.LENGTH_SHORT).show();
            }
        });
        btnProcessString.setOnClickListener(v -> {
            String input = etInput.getText().toString();
            if (!input.isEmpty()) {
                String[] words = input.split(" ");
                StringBuilder reversedString = new StringBuilder();

                for (int i = words.length - 1; i >= 0; i--) {
                    reversedString.append(words[i]).append(" ");
                }

                String result = reversedString.toString().trim();
                tvOutput.setText(result);

                Toast.makeText(this, result.toUpperCase(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
