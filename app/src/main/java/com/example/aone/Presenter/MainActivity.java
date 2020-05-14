package com.example.aone.Presenter;

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

import java.util.Vector;

import Model.List;

public class MainActivity extends AppCompatActivity {

    //Test
    TextView text_test;

    ListView listView;
    FloatingActionButton fabButton;
    Vector<List> sampleList = new Vector<List>(5);

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

        if(sampleList.size()>0) //If schedule data is already formed
        {
            intent.putExtra("title","Test Title");
        }

        startActivityForResult(intent,1);
        Log.d("tag","TEST");
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


