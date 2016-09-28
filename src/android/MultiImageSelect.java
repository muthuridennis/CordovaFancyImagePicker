package tech.valiance.ionic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import garden.sky.app.R;

public class MultiImageSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multi_image_select);
    }

    public void sayYes(View view) {
        Intent data = new Intent();
        Bundle res = new Bundle();
        res.putString("YES", "I say Yes");
        data.putExtras(res);
        setResult(RESULT_OK, data);
        finish();
    }

    public void sayNo(View view) {
        Intent data = new Intent();
        Bundle res = new Bundle();
        res.putString("NO", "I say NO");
        data.putExtras(res);
        setResult(RESULT_CANCELED, data);
        finish();
    }

    public void sayMaybe(View view) {
        finish();
    }
}
