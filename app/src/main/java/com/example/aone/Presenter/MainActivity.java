package com.example.aone.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aone.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import Model.Idea;

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
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditIntent();
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
        //TODO: 고쳐서 JSON 이랑 호환되게 바꾸기
        startActivityForResult(intent,1);
        Log.d("tag","TEST");
    }

    void linkId() {
        listView = (ListView) findViewById(R.id.content_view);
        fabButton = (FloatingActionButton) findViewById(R.id.fab);
        jsonFileString = getJsonFromAssets(getApplicationContext());
        Log.d("JsonFileString", jsonFileString);
        //WARNING: idea is NULL
        ideas = gson.fromJson(jsonFileString, Idea.class);
        //For testing purposes
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

    }

    String getJsonFromAssets(Context context) {
        String jsonString;
        try {
            InputStream is = getResources().openRawResource(R.raw.lists);
            Log.d("File cannot be found", is.toString());
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

//TODO: MyAdapter 도 호환되게 바꾸기
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
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
            name.setText(ideas.getLists().get("array").getActivityName());
            return convertView;
        }
    }
}


