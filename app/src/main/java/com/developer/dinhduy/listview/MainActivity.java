package com.developer.dinhduy.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button Process;
    private EditText txt;
    private TextView textView;
    private String GT;
    private String TAG="ABC";
    private int REQUEST_CODE=1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        //Set Click And Get Values Giai Thua
         Process.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 GT=txt.getText().toString();
                 Intent intent=new Intent(MainActivity.this,ProcessActivity.class);
                 intent.putExtra("GT",GT);
                 Log.d(TAG, "GT SEND "+GT);
                 startActivityForResult(intent,REQUEST_CODE);

             }
         });


    }
    private void Anhxa(){
        Process=(Button) findViewById(R.id.bthem);
        txt=(EditText) findViewById(R.id.edit);
        textView=(TextView) findViewById(R.id.id_kq);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE){

            if(resultCode==RESULT_OK) {
                int kq = data.getIntExtra("KQ", 0);
                textView.setText("RESULT: " + kq);

            }

        }
        else {
            Toast.makeText(this, "REQUEST FAIL", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
