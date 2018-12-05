package com.example.daan.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailactivity);

        Intent intent = getIntent();
        Entry entry = (Entry) intent.getSerializableExtra("entry");

        TextView titel = findViewById(R.id.titel);
        titel.setText(entry.getTitle());
        TextView time = findViewById(R.id.time);
        time.setText(entry.getTimestamp());
        TextView content = findViewById(R.id.content);
        content.setText(entry.getContent());
    }
}
