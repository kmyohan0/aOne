package com.example.aone.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aone.R;

public class EditActivity extends AppCompatActivity {

    EditText title_edit;
    Toolbar mToolbar;
    Button submit_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        linkId();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        submit_edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finishIntnet();
            }
        });
        Bundle bundle = getIntent().getExtras();
        settingUp(bundle);
    }

    void settingUp(Bundle bundle) {
        if (bundle.getBoolean("Create")) {
            title_edit.setText("");
        }
        else {
            title_edit.setText(bundle.getString("Title"));
        }
    }

    void linkId() {
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar_edit);
        title_edit = (EditText)findViewById(R.id.title_edit);
        submit_edit = (Button)findViewById(R.id.submit_edit);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK) { // 액티비티가 정상적으로 종료되었을 경우
//            if(requestCode==1) { // ResultCode == 0 -> whether it is from listView
//                String title = data.getExtras().getString("Title");
//                title_edit.setText(title);
//            }
//            else { //ResultCode = 1 (meaning we are creating new element)
//                title_edit.setText("");
//            }
//        }
//    }

    void finishIntnet() {
        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
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
