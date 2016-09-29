package tech.valiance.ionic;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;


/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaFancyImagePicker extends CordovaPlugin {
    private  CallbackContext callbackContext;
    final int INTENT_REQUEST_GET_IMAGES = 13;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        this.callbackContext = callbackContext;

        if (action.equals("selectPhotos")) {

            Intent intent  = new Intent(cordova.getActivity(), ImagePickerActivity.class);
            cordova.startActivityForResult(this, intent, INTENT_REQUEST_GET_IMAGES);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resuleCode, Intent intent) {
        super.onActivityResult(requestCode, resuleCode, intent);

        if (requestCode == INTENT_REQUEST_GET_IMAGES && resuleCode == Activity.RESULT_OK ) {

            ArrayList<Uri> image_uris = intent.getParcelableArrayListExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);

            // do something with the result
            Log.i("Images >>", image_uris.toString());
            this.callbackContext.success(image_uris.toString());
        }else{
            this.callbackContext.error("No images selected");
        }
    }
}
