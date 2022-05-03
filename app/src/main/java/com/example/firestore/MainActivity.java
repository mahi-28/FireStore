package com.example.firestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button logout;
    private Button add;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        add = findViewById(R.id.add);
        name = findViewById(R.id.edit);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged Out!", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MainActivity.this , StartActivity.class));
                finish();
            }
        });

        //FirebaseDatabase.getInstance().getReference().child("Coding").child("Java").setValue("ArrayList");
//        HashMap<String , Object> map = new HashMap<>();
//        map.put("Name" , "Madhuri");
//        map.put("email" , "madhurifarade7@gmail.com");
//
//        FirebaseDatabase.getInstance().getReference().child("Student").child("Info").updateChildren(map);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name = name.getText().toString();
                if(txt_name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No name entered!", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("Student").push().child("Name").setValue(txt_name);
                    Toast.makeText(MainActivity.this, "Name entered successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}