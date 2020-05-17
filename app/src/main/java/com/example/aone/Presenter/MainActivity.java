package com.example.aone.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import Model.Idea;
import Model.List;

public class MainActivity extends AppCompatActivity {

    //Test
    TextView text_test;
    ListView listView;
    FloatingActionButton fabButton;
    String jsonFileString = "";
    Gson gson = new Gson();
    Idea ideas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_test = (TextView)findViewById(R.id.text_test);

        linkId();
        //For creating New Object
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditIntent();
            }
        });
        //For editing existing object
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), EditActivity.class);
                intent.putExtra("Title", ideas.getIdea().get("array")[position].getActivityName());
                intent.putExtra("Create", false);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) // 액티비티가 정상적으로 종료되었을 경우
        {
            if(requestCode==1) // requestCode==1 로 호출한 경우에만 처리
            {
                String title = data.getExtras().getString("title");
                text_test.setText(title);
            }
        }
    }

    void openEditIntent() {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("Create", true);
        startActivityForResult(intent,1);
    }

    void linkId() {
        listView = (ListView) findViewById(R.id.content_view);
        fabButton = (FloatingActionButton) findViewById(R.id.fab);
        jsonFileString = getJsonFromAssets(getApplicationContext());
        //WARNING: idea is NULL
        ideas = gson.fromJson(jsonFileString, Idea.class);
        //DateFormat = getting current Time
        String dateFormat = DateFormat.getDateInstance(DateFormat.SHORT).format(new Date());
        //For testing purposes
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

    }
    String getJsonFromAssets(Context context) {
        String jsonString;
        try {
            InputStream is = getResources().openRawResource(R.raw.lists);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ideas.getIdea().get("array").length;
        }

        @Override
        public List getItem(int position) {
            return ideas.getIdea().get("array")[position];
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
            TextView name = (TextView) convertView.findViewById(R.id.title);
            name.setText(ideas.getIdea().get("array")[position].getActivityName());
            TextView date = (TextView) convertView.findViewById(R.id.date);
            date.setText(ideas.getIdea().get("array")[position].getDate());
            //date.setText(ideas.getIdea().get("array")[0].getDate());
            return convertView;
        }
    }
}


