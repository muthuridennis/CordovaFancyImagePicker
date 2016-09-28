package tech.valiance.ionic;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;


/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaFancyImagePicker extends CordovaPlugin {
    private  CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;

        if (action.equals("selectPhotos")) {
            Intent intent = new Intent(cordova.getActivity(), MultiImageSelect.class);

            cordova.startActivityForResult(this, intent, 0);
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            String message = data.getStringExtra("YES");
            this.callbackContext.success(message);
        } else if (resultCode == Activity.RESULT_CANCELED && data != null) {
            String error = data.getStringExtra("NO");
            this.callbackContext.error(error);
        } else {
            this.callbackContext.error("No images selected");
        }
    }
}
