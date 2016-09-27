package tech.valiance.ionic;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaFancyImagePicker extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d("CordovaFancyImagePicker", " >>>>>>>>> >>>>>>>>>>>> Start intent");
        Log.d("CordovaFancyImagePicker",  String.valueOf(action));

        if (action.equals("selectPhotos")) {
            String message = args.getString(0);

            if (message != null && message.length() > 0) {
                callbackContext.success(message);
            } else {
                callbackContext.error("Expected one non-empty string argument.");
            }
            this.selectPhotos(message, callbackContext);
        }else{
            return false;
        }
        return true;
    }

    private void selectPhotos(String message, CallbackContext callbackContext) {
        Log.d("CordovaFancyImagePicker", " >>>>>>>>> >>>>>>>>>>>> Start intent");
        Log.d("CordovaFancyImagePicker",  String.valueOf(message));

        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
