package edu.tu.gettingresultbackfromchildactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView replyview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView replyview  = findViewById(R.id.replyView);
        replyview =(TextView)findViewById(R.id.replyView);
        EditText textbox = findViewById(R.id.textBox);
        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textbox.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message",str);//passing some data through this object
                startActivityForResult(intent,101);
                //startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == 101){
            if (resultCode == RESULT_OK) {
                final String str = data.getStringExtra("REPLY_MESSAGE");
                replyview.setText(str);
                Toast.makeText(MainActivity.this, "Message: " +str ,Toast.LENGTH_LONG).show();
            }
            if(resultCode == RESULT_CANCELED) {
                replyview.setText("Reply Button Not Pressed");
            }
    }
}