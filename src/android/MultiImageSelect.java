package tech.valiance.ionic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import com.gun0912.tedpicker.ImagePickerActivity;

import java.util.ArrayList;

import garden.sky.app.R;
import gun0912.tedbottompicker.TedBottomPicker;

public class MultiImageSelect extends AppCompatActivity {
    final int INTENT_REQUEST_GET_IMAGES = 13;
//    final int MAX_IMAGE_COUNT= 5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Images", "<------------ Loading images ------------>");

        Intent intent  = new Intent(MultiImageSelect.this, ImagePickerActivity.class);
        startActivityForResult(intent,INTENT_REQUEST_GET_IMAGES);
//        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(MultiImageSelect.this)
//                .setMaxCount(MAX_IMAGE_COUNT)
//                .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
//                    @Override
//                    public void onImageSelected(Uri uri) {
//                        Log.i("Images >>", "Uri ------------> " + uri);
//                    }
//                })
//                .create();
//
//        tedBottomPicker.show(getSupportFragmentManager());
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
    // public void sayYes(View view) {
    //     Intent data = new Intent();
    //     Bundle res = new Bundle();
    //     res.putString("YES", "I say Yes");
    //     data.putExtras(res);
    //     setResult(RESULT_OK, data);
    //     finish();
    // }

    // public void sayNo(View view) {
    //     Intent data = new Intent();
    //     Bundle res = new Bundle();
    //     res.putString("NO", "I say NO");
    //     data.putExtras(res);
    //     setResult(RESULT_CANCELED, data);
    //     finish();
    // }

    // public void sayMaybe(View view) {
    //     finish();
    // }
}
