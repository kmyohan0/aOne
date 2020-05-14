package com.example.aone.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aone.R;

public class EditActivity extends AppCompatActivity {

    public EditText title_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar_edit);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title_edit = (EditText)findViewById(R.id.title_edit);
        Button submit_edit = (Button)findViewById(R.id.submit_edit);
        submit_edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finishIntnet();
            }
        });
        Intent intent = getIntent();
        String title = "" + intent.getExtras().getString("title");
        title_edit.setText(title);
    }

    void finishIntnet() {
        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
        //보낼 데이터
        intent.putExtra("title",title_edit.getText());
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
