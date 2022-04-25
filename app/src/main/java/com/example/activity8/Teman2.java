package com.example.activity8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.activity8.database.dbController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class Teman2 extends AppCompatActivity {
    private TextInputEditText tNama, tTelepon;
    private Button simpanBtn;
    String nm, tlp;
    dbController controller = new dbController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman2);

        tNama = (TextInputEditText)findViewById(R.id.tietNama);
        tTelepon = (TextInputEditText)findViewById(R.id.tietTelepon);
        simpanBtn = (Button)findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNama.getText().toString().equals("") || tTelepon.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Data Belum Komplit!", Toast.LENGTH_SHORT).show();
                }else {
                    nm = tNama.getText().toString();
                    tlp = tTelepon.getText().toString();

                    HashMap<String, String> qvalues = new HashMap<>();
                    qvalues.put("nama", nm);
                    qvalues.put("telepon", tlp);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(Teman2.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}