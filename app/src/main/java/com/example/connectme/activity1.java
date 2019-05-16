package com.example.connectme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class activity1 extends AppCompatActivity implements View.OnClickListener {
    ImageView ivhappy,ivok,ivsad;
    EditText edtname,edtph,edtweb,edtaddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        edtname = findViewById(R.id.edtname);
        edtph =findViewById(R.id.edtph);
        edtweb= findViewById(R.id.edtweb);
        edtaddress=findViewById(R.id.edtaddress);
        ivhappy=findViewById(R.id.ivhappy);
        ivok=findViewById(R.id.ivok);
        ivsad=findViewById(R.id.ivsad);
       ivhappy.setOnClickListener(this);
        ivok.setOnClickListener(this);
        ivsad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
if(edtname.getText().toString().isEmpty()||edtph.getText().toString().isEmpty()||edtweb.getText().toString().isEmpty()||edtaddress.getText().toString().isEmpty()){
    Toast.makeText(this,"Please enter all fields",Toast.LENGTH_LONG).show();
}
else
{
    Intent intent = new Intent();
        intent.putExtra("name",edtname.getText().toString().trim());
        intent.putExtra("ph",edtph.getText().toString().trim());
        intent.putExtra("web",edtweb.getText().toString().trim());
        intent.putExtra("location",edtaddress.getText().toString().trim());
        if(view.getId()==R.id.ivhappy)
        {
            intent.putExtra("mood","happy");
        }
        else if(view.getId()==R.id.ivok)
        {
            intent.putExtra("mood","ok");
        }
        else if(view.getId()==R.id.ivsad)
        {
            intent.putExtra("mood","sad");
        }
        setResult(RESULT_OK,intent);
        activity1.this.finish();
}
    }
}
