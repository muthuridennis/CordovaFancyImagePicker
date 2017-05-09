package tech.valiance.ionic;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import me.iwf.photopicker.PhotoPicker;

public class MultiImageSelect extends AppCompatActivity {
    private int DEFAULT_MAX_IMAGES  = 5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent multiImageIntent = getIntent();
        Integer maxImages = multiImageIntent.getIntExtra("maxImages", DEFAULT_MAX_IMAGES);
        
        PhotoPicker.builder()
                .setPhotoCount(maxImages)
                .setShowCamera(true)
                .setPreviewEnabled(false)
                .start(this, PhotoPicker.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Intent data;
        Bundle res;

        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            ArrayList<String> photos =
                    intent.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);

            data = new Intent();
            res = new Bundle();

            res.putInt("SELECTED", photos.size());
            res.putStringArrayList("PHOTOS", photos);
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
