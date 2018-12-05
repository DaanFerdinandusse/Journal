package com.example.daan.journal;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import java.sql.Time;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, int layout, Cursor cursor) {
        super(context, layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int columnIndexTitel = cursor.getColumnIndex("titel");
        String collumTitel = cursor.getString(columnIndexTitel);

        int columnIndexMood = cursor.getColumnIndex("mood");
        int collumMood = cursor.getInt(columnIndexMood);

        int columnIndexTime = cursor.getColumnIndex("time");
        String collumTime = cursor.getString(columnIndexTime);

        TextView titel = view.findViewById(R.id.titel);
        titel.setText(collumTitel);
        System.out.println(R.drawable.happy);
        System.out.println(R.drawable.love);
        System.out.println(R.drawable.sad);
        System.out.println(R.drawable.angry);
        ImageView mood = view.findViewById(R.id.mood);
        switch (collumMood){
            case 0: mood.setImageResource(R.drawable.happy);
                    break;
            case 1: mood.setImageResource(R.drawable.sad);
                break;
            case 2: mood.setImageResource(R.drawable.love);
                break;
            case 3: mood.setImageResource(R.drawable.angry);
                break;
        }

        TextView time = view.findViewById(R.id.time);
        time.setText(collumTime);
    }
}
