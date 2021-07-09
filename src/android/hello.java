package cordova.plugin.hello;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.app.Application; 
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.app.Activity;  
import android.view.Menu;
import android.R;


/**
 * This class echoes a string called from JavaScript.
 */
public class hello extends CordovaPlugin {
    private CallbackContext PUBLIC_CALLBACKS = null;
 

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        PUBLIC_CALLBACKS = callbackContext;
        Context context = this.cordova.getActivity().getApplicationContext();
        if (action.equals("showToast"/* "coolMethod"  *//* "actionShow" */)) {
            Toast.makeText(context/* getApplicationContext() */,"Spaghetaboutit!", Toast.LENGTH_LONG).show();
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            PluginResult result = new PluginResult(PluginResult.Status.OK, "success");
            result.setKeepCallback(true);
            PUBLIC_CALLBACKS.sendPluginResult(result);
            return true;
        }
        return false;
    }
    
    // private void toasty(/* String args */)
    // {
    //     Toast.makeText(context/* getApplicationContext() */, "ok"/* args */, Toast.LENGTH_LONG).show();
    // }

    private void coolMethod(String message, CallbackContext callbackContext) 
    {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    
}
