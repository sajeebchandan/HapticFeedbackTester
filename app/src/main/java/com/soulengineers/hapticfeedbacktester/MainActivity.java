package com.soulengineers.hapticfeedbacktester;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScrollView mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        Switch switchMode = (Switch) findViewById(R.id.switchMode);
        LoadSettings(mainScrollView, switchMode);
    }

    private void LoadSettings(ScrollView mainScrollView, Switch switchMode) {
        SharedPreferences preferences = getSharedPreferences("prefName", MODE_PRIVATE);
        int colorCode = preferences.getInt("colorCode", Color.parseColor("#FFFFFF"));
        mainScrollView.setBackgroundColor(colorCode);
        if (((ColorDrawable) mainScrollView.getBackground()).getColor() == Color.parseColor("#000000")) {
            switchMode.setChecked(true);
        } else {
            switchMode.setChecked(false);
        }
    }

    public void KEYBOARD_TAP(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
    }

    public void LONG_PRESS(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
    }

    public void VIRTUAL_KEY_RELEASE(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY_RELEASE);
    }

    public void VIRTUAL_KEY(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
    }

    public void CLOCK_TICK(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
    }

    public void CONTEXT_CLICK(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
    }

    public void FLAG_IGNORE_GLOBAL_SETTING(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
    }

    public void KEYBOARD_PRESS(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
    }

    public void KEYBOARD_RELEASE(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_RELEASE);
    }

    public void FLAG_IGNORE_VIEW_SETTING(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
    }

    public void TEXT_HANDLE_MOVE(final View view) {
        view.performHapticFeedback(HapticFeedbackConstants.TEXT_HANDLE_MOVE);
    }

    public void SwitchToTheme(View view) {
        ScrollView mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        if (((ColorDrawable) mainScrollView.getBackground()).getColor() == Color.parseColor("#000000")) {
            mainScrollView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            mainScrollView.setBackgroundColor(Color.parseColor("#000000"));
        }
        view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);

        SharedPreferences preferences = getSharedPreferences("prefName", MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("colorCode", ((ColorDrawable) mainScrollView.getBackground()).getColor());
        edit.commit();
    }
}