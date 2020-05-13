package com.example.aone.Presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import Model.List;

import com.example.aone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton fabButton;
    Vector<List> sampleList = new Vector<List>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkId();
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditIntent();
            }
        });
    }

    void openEditIntent() {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

    void linkId() {
        listView = (ListView) findViewById(R.id.content_view);
        fabButton = (FloatingActionButton) findViewById(R.id.fab);
        //For testing purposes
        List temp = new List();
        sampleList.addElement(temp);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return sampleList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.activity_listview, container, false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.element);
            name.setText(sampleList.elementAt(position).getActivityName());
            return convertView;
        }
    }
}


