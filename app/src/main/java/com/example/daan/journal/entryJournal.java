package com.example.daan.journal;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class entryJournal extends AppCompatActivity {

    private int mood = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_journal);
    }

    public void changeMood(View v){
        switch (v.getId()){
            case 2131230802: mood = 0;
                    break;
            case 2131230851: mood = 1;
                    break;
            case 2131230821: mood = 2;
                    break;
            case 2131230749: mood = 3;
                    break;
        }
    }

    public void submit(View v){
        TextInputEditText titelInput = findViewById(R.id.titel);
        TextInputEditText contentInput = findViewById(R.id.content);
        Entry entry = new Entry(titelInput.getText().toString(), contentInput.getText().toString(), mood);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(entry);
        Intent intent = new Intent(entryJournal.this, MainActivity.class);
        startActivity(intent);
    }
}
