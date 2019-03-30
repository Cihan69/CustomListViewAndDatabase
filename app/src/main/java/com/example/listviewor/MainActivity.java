package com.example.listviewor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_nameSurname, et_mail, et_adress;
    Button btn_list, btn_apply;
    ListView listView_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit();

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et_nameSurname.getText().toString();
                String email = et_mail.getText().toString();
                String adress = et_adress.getText().toString();


                Person person = new Person(name, email, adress);

                Database db = new Database(getApplicationContext());

                long id = db.addRecord(person);

                if (id == -1) {
                    Toast.makeText(MainActivity.this, "Sorry! Record can not add...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Adding records successfully completed...", Toast.LENGTH_SHORT).show();

                    et_adress.setText("");
                    et_mail.setText("");
                    et_nameSurname.setText("");
                }
            }
        });


        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this);
                listView_item.setAdapter(customAdapter);


            }
        });
    }


    private void unit() {

        et_nameSurname = findViewById(R.id.et_nameSurname);

        et_mail = findViewById(R.id.et_mail);
        et_adress = findViewById(R.id.et_adress);

        btn_list = findViewById(R.id.btn_list);
        btn_apply = findViewById(R.id.btn_apply);

        listView_item = findViewById(R.id.listView_item);

    }
}
