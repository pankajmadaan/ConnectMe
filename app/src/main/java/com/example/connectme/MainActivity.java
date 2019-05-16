package com.example.connectme;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView ivmood,ivlocation,ivweb,ivcall;
TextView textView3;
final int activity1=1;
String name ="", number="", web="", location="",mood="";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==activity1){
            if(resultCode==RESULT_OK){
                ivmood.setVisibility(View.VISIBLE);
                ivcall.setVisibility(View.VISIBLE);
                ivweb.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                ivlocation.setVisibility(View.VISIBLE);
                name= data.getStringExtra("name");
                textView3.setText(name);
                number= data.getStringExtra("ph");
                web = data.getStringExtra("web");
                location= data.getStringExtra("location");
                mood = data.getStringExtra("mood");
                if(mood.equals("happy"))
                {
                    ivmood.setImageResource(R.drawable.ic_tag_faces_black_24dp);
                }
                else if (mood.equals("ok")){
                    ivmood.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp);
                }
                else if (mood.equals("sad"))
                {
                    ivmood.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button = findViewById(R.id.button);
        ivmood = findViewById(R.id.ivmood);
        textView3 =findViewById(R.id.textView3);
        ivcall =findViewById(R.id.ivcall);
        ivweb =findViewById(R.id.ivweb);
        ivlocation =findViewById(R.id.ivlocation);
        ivmood.setVisibility(View.GONE);
        ivweb.setVisibility(View.GONE);
        ivcall.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);
        ivlocation.setVisibility(View.GONE);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.example.connectme.activity1.class);
                startActivityForResult(intent, activity1);
            }
        });


        ivcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + number));
startActivity(intent);
            }
        });
        ivweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + web));
                startActivity(intent);
            }
        });
        ivlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);
            }
        });
    }
}
