package tech.valiance.ionic;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaFancyImagePicker extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("selectPhotos")) {
            String message = args.getString(0);

            if (message != null && message.length() > 0) {
                callbackContext.success(message);
            } else {
                callbackContext.error("Expected one non-empty string argument.");
            }
            // this.selectPhotos(message, callbackContext);
            return true;
        }else{
            callbackContext.error("Something failed baaaaaadly");
            return false;
        }
    }

    private void selectPhotos(String message, CallbackContext callbackContext) {
        callbackContext.success("Test success in selectPhotos");
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
