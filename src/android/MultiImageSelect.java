package tech.valiance.ionic;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import com.gun0912.tedpicker.ImagePickerActivity;

import java.util.ArrayList;


public class MultiImageSelect extends AppCompatActivity {
    final int INTENT_REQUEST_GET_IMAGES = 13;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent  = new Intent(this, ImagePickerActivity.class);
        startActivityForResult(intent,INTENT_REQUEST_GET_IMAGES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resuleCode, Intent intent) {
        super.onActivityResult(requestCode, resuleCode, intent);
        Intent data;
        Bundle res;

        if (requestCode == INTENT_REQUEST_GET_IMAGES && resuleCode == Activity.RESULT_OK ) {
            ArrayList<Uri> image_uris = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);

            data = new Intent();
            res = new Bundle();

            res.putInt("SELECTED", image_uris.size());
            res.putParcelableArrayList("URIS", image_uris);
            data.putExtras(res);
            setResult(RESULT_OK, data);
            finish();
        }else{
            data = new Intent();
            res = new Bundle();
            res.putString("MESSAGE", "No images selected");
            data.putExtras(res);
            setResult(RESULT_CANCELED, data);
            finish();
        }
    }
}
