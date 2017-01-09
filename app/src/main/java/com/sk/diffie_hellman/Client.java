package com.sk.diffie_hellman;

import android.widget.TextView;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Сергій on 24.11.2016.
 */

public class Client {
    BigInteger p;
    BigInteger a;
    BigInteger k;
    BigInteger X;
    int x;
    TextView textView;


    public BigInteger getX() {
        textView.setText(textView.getText()+"\n Клієнт  відправив Х="+String.valueOf(X));
        return X;
    }

    public void setK(BigInteger k) {
        textView.setText(textView.getText()+"\n Клієнт  отримав Х="+String.valueOf(k));
        this.k=k.pow(x).mod(p);
        textView.setText(textView.getText()+"\n Клієнт  обчислив ключ="+String.valueOf(this.k));

    }


    public Client(BigInteger p, BigInteger a,TextView textView) {
        this.p =p.nextProbablePrime() ;
        this.a = a.nextProbablePrime();
        this.textView=textView;

        Random random=new Random();
        this.x=random.nextInt(100);

        X=a.pow(this.x).mod(this.p);

    }

    public Client() {

    }
}
