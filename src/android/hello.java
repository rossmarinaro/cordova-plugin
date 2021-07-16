package cordova.plugin.hello;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.app.Application; 
import android.os.Bundle;
import android.widget.Toast;
import android.view.*;//.View;
import android.widget.TextView;
import android.app.Activity;  
import android.view.Menu;
import io.cordova.hellocordova.R;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;


/**
 * This class echoes a string called from JavaScript as a native toast.
 */
public class hello extends CordovaPlugin {

    private CallbackContext PUBLIC_CALLBACKS = null;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        PUBLIC_CALLBACKS = callbackContext;
        Context context = this.cordova.getActivity().getApplicationContext();

        if (action.equals("showToast")) {
            String msg = args.getString(0);
            Toast toast = Toast.makeText(context, msg/* args */, Toast.LENGTH_LONG);
        ////custom vector
            if (args.getBoolean(1) == false)
            {
                View toastView = toast.getView();
                toastView.setBackgroundResource(R.drawable.hello_drawable);
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                if (v != null) v.setGravity(Gravity.CENTER);
            }
            toast.show();
            //this.coolMethod(message, callbackContext);
            PluginResult result = new PluginResult(PluginResult.Status.OK, "success");
            result.setKeepCallback(true);
            PUBLIC_CALLBACKS.sendPluginResult(result);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) 
    {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    
}
