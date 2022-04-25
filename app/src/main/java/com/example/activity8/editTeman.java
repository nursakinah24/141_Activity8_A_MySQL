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

public class editTeman extends AppCompatActivity {
    TextInputEditText Nama, Telepon;
    Button Save;
    String nm, tlp, id;
    dbController controller = new dbController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teman);

        Nama = findViewById(R.id.edNama);
        Telepon = findViewById(R.id.edTelp);
        Save = findViewById(R.id.simpanBtn);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nama");
        tlp = getIntent().getStringExtra("telpon");

        setTitle("Edit Data");
        Nama.setText(nm);
        Telepon.setText(tlp);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (Nama.getText().toString().equals("") || Telepon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu.", Toast.LENGTH_LONG).show();
                }else {
                    nm = Nama.getText().toString();
                    tlp = Telepon.getText().toString();
                    HashMap<String, String> values = new HashMap<>();
                    values.put("id", id);
                    values.put("nama", nm);
                    values.put("telepon", tlp);
                    controller.UpdateData(values);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(editTeman.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}