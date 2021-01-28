package edu.tu.gettingresultbackfromchildactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView data=findViewById(R.id.data);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        data.setText(str);

        EditText replybox = findViewById(R.id.replyBox);
        Button reply = findViewById(R.id.reply);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                final String str = replybox.getText().toString();
                i.putExtra("REPLY_MESSAGE",str);
                setResult(RESULT_OK, i);
                finish();

            }
        });

    }
}