package com.designsapps.challenge;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> charcters = new ArrayList<>();
    ArrayList<Integer>  ids = new ArrayList<>();
    TextView textView;
    TableLayout tableLayout;
    ImageView imageView;
    ScrollView scrollView;
    String word = "asdfghjtklomnbvcewqz",AcWord="";
    int shakeNum;
    SharedPreferences prefs ;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs= getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        editor = prefs.edit();
        addShared();
        saveArrayList();
        addIds();
        shakeArrayList();
        textView = findViewById(R.id.textview);
        tableLayout = findViewById(R.id.table);
        imageView = findViewById(R.id.image);
        scrollView = findViewById(R.id.sc);
    }

    private void addShared() {
        if(!prefs.contains("shakeNum")) {
            shakeNum = 1;
            editor.putInt("shakeNum", 1);
            editor.apply();
        }else{
            getshakeNum();
        }
    }

    private int getshakeNum() {
            shakeNum = prefs.getInt("shakeNum", 1); //0 is the default value.
            if(shakeNum >10){editor.putInt("shakeNum",1);editor.apply();shakeNum =1; return 1;}else {shakeNum++;}
            editor.putInt("shakeNum",shakeNum);
            editor.apply();
            return shakeNum;
    }

    private void addIds() {
        ids.add(R.id.b1);
        ids.add(R.id.b2);
        ids.add(R.id.b3);
        ids.add(R.id.b4);
        ids.add(R.id.b5);
        ids.add(R.id.b6);
        ids.add(R.id.b7);
        ids.add(R.id.b8);
        ids.add(R.id.b9);
        ids.add(R.id.b10);
        ids.add(R.id.b11);
        ids.add(R.id.b12);
        ids.add(R.id.b13);
        ids.add(R.id.b14);
        ids.add(R.id.b15);
        ids.add(R.id.b16);
        ids.add(R.id.b17);
        ids.add(R.id.b18);
        ids.add(R.id.b19);
        ids.add(R.id.b20);

    }

    private void shakeArrayList() {
            for(int i = 0; i<20;i++){
                    Button x= findViewById(ids.get(i));
                    x.setText(charcters.get(i));
            }
    }

    private void saveArrayList() {
        for(int i=0;i<word.length();i++){
            charcters.add(String.valueOf(word.charAt(i)));
        }
        for (int index = 1; index < charcters.size(); index += shakeNum) { // Swap on even indices.
            // Swap values at positions index-1 and index.
            Object temp = charcters.get(index-1); // Save value before overwrite.
            charcters.set(index-1, charcters.get(index)); // First half of swap.
            charcters.set(index, (String) temp); // Final operation for swap.
        }
    }

    public void getkey(View view) {
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        AcWord+=buttonText;
        textView.setText(AcWord);
        checkWord(AcWord);
    }

    private void checkWord(String acWord) {
        if(acWord.toLowerCase().equals("cat")){
            scrollView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }
    }

    public void again(View view) {
        AcWord ="";
        textView.setText("");
    }
}


