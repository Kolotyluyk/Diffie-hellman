package com.sk.diffie_hellman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit1,edit2;
    TextView textView;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit1=(EditText)findViewById(R.id.editText);
        edit2=(EditText)findViewById(R.id.editText2);

        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.TextView);
    }


    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(edit1.getText().toString());
        int p=Integer.parseInt(edit2.getText().toString());

        if (a>p){
            int e=a;
            a=p;
            p=e;
        }
        Client A=new Client( BigInteger.valueOf(p),BigInteger.valueOf(a),textView);
        Client B=new Client(BigInteger.valueOf(p),BigInteger.valueOf(a),textView);

         A.setK(B.getX());
        B.setK(A.getX());

        edit1.setText(String.valueOf(A.a));
        edit2.setText(String.valueOf(A.p));

    }
}
