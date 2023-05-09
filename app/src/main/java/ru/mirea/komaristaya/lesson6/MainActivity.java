package ru.mirea.komaristaya.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ru.mirea.komaristaya.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences =
                getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        String group = preferences.getString("GROUP", "unknown");
        int number = preferences.getInt("NUMBER", 0);
        String serial = preferences.getString("SERIAL", "unknown");

        binding.NumberGroup.setText(group);
        binding.NumberList.setText(String.valueOf(number));
        binding.Serial.setText(serial);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences =
                        getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = preferences.edit();
                ed.putString("GROUP", binding.NumberGroup.getText().toString());
                ed.putInt("NUMBER", Integer.parseInt(binding.NumberList.getText().toString()));
                ed.putString("SERIAL", binding.Serial.getText().toString());
                ed.apply();
            }
        });


    }
}