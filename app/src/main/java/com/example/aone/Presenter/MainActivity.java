package com.example.aone.Presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aone.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView date;
    Button fabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkId();
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Intent / Fragment open to have Time Picker add date etc etc.
            }
        });
    }

    void linkId() {
        listView = (ListView) findViewById(R.id.content_view);
        date = (TextView) findViewById(R.id.date);
        fabButton = (Button) findViewById(R.id.fab);
    }
}
