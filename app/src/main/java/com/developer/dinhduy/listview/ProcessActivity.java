package com.developer.dinhduy.listview;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.Toast;


public class ProcessActivity extends MainActivity {
    private String TAG="ABC";
    int gt=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int n= Integer.parseInt(intent.getStringExtra("GT"));
        Log.d(TAG, "Process "+n);

        for (int i=1;i<=n;i++){
            gt*=i;
        }
        Log.d(TAG, "Ket qua: "+gt);

        Intent intent2=new Intent(ProcessActivity.this,MainActivity.class);
        intent2.putExtra("KQ",gt);
        setResult(RESULT_OK,intent2);
        finish();


    }

}
