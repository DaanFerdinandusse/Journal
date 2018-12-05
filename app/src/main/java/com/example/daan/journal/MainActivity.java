package com.example.daan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter adapter;
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);

            int indexTitel = cursor.getColumnIndex("titel");
            String titel = cursor.getString(indexTitel);
            int indexContent = cursor.getColumnIndex("content");
            String content = cursor.getString(indexContent);
            int indexMood = cursor.getColumnIndex("mood");
            int mood = cursor.getInt(indexMood);
            Entry entry = new Entry(titel, content, mood);

            int indexTime = cursor.getColumnIndex("time");
            String time = cursor.getString(indexTime);
            entry.setTimestamp(time);

            Intent intent = new Intent(MainActivity.this, details.class);
            intent.putExtra("entry", entry);
            startActivity(intent);
        }
    }

    private class ListItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            int indexID = cursor.getColumnIndex("_id");
            int entryId = cursor.getInt(indexID);
            db.delete(entryId);
            updateData();
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = EntryDatabase.getInstance(getApplicationContext());
        adapter = new EntryAdapter(getApplicationContext(), R.layout.entry_row, db.selectAll());
        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ListItemClickListener());
        lv.setOnItemLongClickListener(new ListItemLongClickListener());
    }

    @Override
    public void onResume(){
        super.onResume();
        updateData();
    }

    private void updateData(){
        adapter.swapCursor(db.selectAll());
    }

    public void newEntry(View v){
        Intent intent = new Intent(MainActivity.this, entryJournal.class);
        startActivity(intent);
    }
}
