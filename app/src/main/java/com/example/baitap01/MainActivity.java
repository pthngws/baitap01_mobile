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

        // Liên kết các View
        Button btnProcessArray = findViewById(R.id.btnProcessArray);
        Button btnProcessString = findViewById(R.id.btnProcessString);
        EditText etInput = findViewById(R.id.etInput);
        TextView tvOutput = findViewById(R.id.tvOutput);
        EditText mangInput = findViewById(R.id.mangInput);
        // Xử lý mảng ArrayList
        btnProcessArray.setOnClickListener(v -> {
            // Lấy chuỗi nhập từ EditText
            String input = mangInput.getText().toString();

            // Kiểm tra nếu chuỗi không rỗng
            if (!input.isEmpty()) {
                try {
                    // Tách chuỗi thành các phần tử bằng dấu phẩy
                    String[] parts = input.split(",");

                    // Chuyển đổi thành ArrayList<Integer>
                    ArrayList<Integer> numbers = new ArrayList<>();
                    for (String part : parts) {
                        numbers.add(Integer.parseInt(part.trim())); // Chuyển chuỗi sang số nguyên
                    }

                    // Phân loại số chẵn và số lẻ
                    ArrayList<Integer> evenNumbers = new ArrayList<>();
                    ArrayList<Integer> oddNumbers = new ArrayList<>();

                    for (int num : numbers) {
                        if (num % 2 == 0) {
                            evenNumbers.add(num);
                        } else {
                            oddNumbers.add(num);
                        }
                    }

                    // In ra log
                    Log.d("EvenNumbers", evenNumbers.toString());
                    Log.d("OddNumbers", oddNumbers.toString());

                    // Hiển thị kết quả trên TextView
                    tvOutput.setText("Số chẵn: " + evenNumbers + "\nSố lẻ: " + oddNumbers);

                } catch (NumberFormatException e) {
                    // Xử lý lỗi nếu người dùng nhập không phải số
                    Toast.makeText(this, "Vui lòng nhập các số hợp lệ, cách nhau bằng dấu phẩy!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập danh sách số!", Toast.LENGTH_SHORT).show();
            }
        });
        btnProcessString.setOnClickListener(v -> {
            String input = etInput.getText().toString();
            if (!input.isEmpty()) {
                // Đảo ngược chuỗi và sắp xếp lại
                String[] words = input.split(" ");
                StringBuilder reversedString = new StringBuilder();

                for (int i = words.length - 1; i >= 0; i--) {
                    reversedString.append(words[i]).append(" ");
                }

                // Hiển thị kết quả
                String result = reversedString.toString().trim();
                tvOutput.setText(result);

                // Hiển thị Toast chuỗi in hoa
                Toast.makeText(this, result.toUpperCase(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}