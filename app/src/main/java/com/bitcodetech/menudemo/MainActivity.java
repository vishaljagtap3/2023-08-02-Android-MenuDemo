package com.bitcodetech.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_INFO = 1;
    public static final int MENU_HELP = 2;
    public static final int MENU_SETTINGS = 3;
    public static final int MENU_EXIT = 4;
    public static final int MENU_PHONE_SETTINGS = 11;
    public static final int MENU_SYSTEM_SETTINGS = 12;

    private CheckBox chkSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        chkSettings = findViewById(R.id.chkSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuItem item = menu.add(0, MENU_INFO, 0, "Info");
        item.setIcon(R.drawable.info);
        item.setAlphabeticShortcut('i');
        item.setNumericShortcut('0');
        item.setCheckable(true);
        item.setChecked(true);

        menu.add(0, MENU_HELP, 0, "Help");

        SubMenu subMenuSettings = menu.addSubMenu(0, MENU_SETTINGS, 0, "Settings");
        subMenuSettings.add(1, MENU_PHONE_SETTINGS, 0, "Phone Settings");
        subMenuSettings.add(1, MENU_SYSTEM_SETTINGS, 0, "System Settings");

        menu.add(0, MENU_EXIT, 0, "Exit");

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");

        MenuItem menuItemSettings = menu.findItem(MENU_SETTINGS);

        menuItemSettings.setEnabled(chkSettings.isChecked());

        /*if(chkSettings.isChecked()) {
            menuItemSettings.setEnabled(true);
        }
        else {
            menuItemSettings.setEnabled(false);
        }*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId() ) {
            case MENU_INFO:
                mt("Info selected");
                break;
            case MENU_HELP:
                mt("Help Selected");
                break;
            case MENU_SETTINGS:
                mt("Settings Selected");
                break;
            case MENU_EXIT:
                finish();
                break;
            case MENU_PHONE_SETTINGS:
                mt("Phone Settings");
                break;
            case MENU_SYSTEM_SETTINGS:
                mt("System Settings");
                break;
        }

        return true;
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}