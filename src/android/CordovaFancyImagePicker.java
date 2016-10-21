package tech.valiance.ionic;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CordovaFancyImagePicker extends CordovaPlugin {
    private CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        this.callbackContext = callbackContext;

        if (action.equals("selectPhotos")) {
            Intent intent  = new Intent(cordova.getActivity(), MultiImageSelect.class);
            cordova.startActivityForResult(this, intent, 0);
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            final ArrayList<String> photos = data.getStringArrayListExtra("PHOTOS");
            final ArrayList<String> base64Array = new ArrayList<String>();

            cordova.getThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    for (String photo : photos) {
                        Uri uri = Uri.parse(photo);
                        base64Array.add(convertToBase64(uri));
                    }

                    JSONArray res = new JSONArray(base64Array);

                    callbackContext.success(res);
                }
            });
        } else if (resultCode == Activity.RESULT_CANCELED && data != null) {
            String error = data.getStringExtra("MESSAGE");
            this.callbackContext.error(error);
        } else{
            this.callbackContext.error("Unplanned event");
        }
    }

    private String convertToBase64(Uri uri){
        Bitmap bm = BitmapFactory.decodeFile(String.valueOf(uri));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 60, stream); //bm is the bitmap object
        byte[] byteArrayImage = stream.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        return encodedImage;
    }
}
