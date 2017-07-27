package com.example.telim2.reglogvolley;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {

    TextView name,mail;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name=(TextView)findViewById(R.id.textView4);
        mail=(TextView)findViewById(R.id.textView3);
        logout=(Button)findViewById(R.id.button3);

        Bundle bundle=getIntent().getExtras();
        name.setText("Xosgelmisiniz "+bundle.getString("username"));
        mail.setText("your mail is "+bundle.getString("mail"));


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=loginActivity.this.getSharedPreferences(getString(R.string.file),MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent=new Intent(loginActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
