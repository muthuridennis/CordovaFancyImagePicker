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

        Log.d("Images", "<------------ Loading images ------------>");

        Intent intent  = new Intent(this, ImagePickerActivity.class);
        startActivityForResult(intent,INTENT_REQUEST_GET_IMAGES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resuleCode, Intent intent) {
        super.onActivityResult(requestCode, resuleCode, intent);

        if (requestCode == INTENT_REQUEST_GET_IMAGES && resuleCode == Activity.RESULT_OK ) {
            ArrayList<Uri> image_uris = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);

            // do something with the result
            Log.i("Images >>", image_uris.toString());
        }else{
            Log.i("Images >>", "These images are not there");
        }
    }
}
