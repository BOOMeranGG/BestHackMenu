package com.example.mireamenu.controller.actionListeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.mireamenu.R;
import com.example.mireamenu.view.activities.MainActivity;
import com.example.mireamenu.view.activities.MainMenuActivity;

import static com.example.mireamenu.Variables.ACTIVITY_LOGGER;
import static com.example.mireamenu.Variables.ECONOM;
import static com.example.mireamenu.Variables.MGUPI;
import static com.example.mireamenu.Variables.MIREA;
import static com.example.mireamenu.Variables.MITHT;

public class MainActivityListener implements View.OnClickListener {
    private Activity activity;

    public MainActivityListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, MainMenuActivity.class);
        String university = "";
        switch (v.getId()) {
            case R.id.btnMIREA:
                Log.d(ACTIVITY_LOGGER, "MIREA was pressed");
                university = MIREA;
                break;
            case R.id.btnMITHT:
                Log.d(ACTIVITY_LOGGER, "MITHT was pressed");
                university = MITHT;
                break;
            case R.id.btnMGUPI:
                Log.d(ACTIVITY_LOGGER, "MGUPI was pressed");
                university = MGUPI;
                break;
        }
        intent.putExtra("university", university);
        intent.putExtra("type", ECONOM);
        MainActivity act = new MainActivity();
        activity.startActivity(intent);
    }
}
