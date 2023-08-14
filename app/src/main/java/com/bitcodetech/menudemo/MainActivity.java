package com.bitcodetech.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_INFO = 1;
    public static final int MENU_HELP = 2;
    public static final int MENU_SETTINGS = 3;
    public static final int MENU_EXIT = 4;
    public static final int MENU_PHONE_SETTINGS = 11;
    public static final int MENU_SYSTEM_SETTINGS = 12;

    public static final int MENU_COPY = 31;
    public static final int MENU_CUT = 32;
    public static final int MENU_PASTE = 33;
    public static final int MENU_APPEND = 34;

    private String text = "";

    private CheckBox chkSettings;
    private TextView txtInfo;
    private EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        registerForContextMenu(txtInfo);
        registerForContextMenu(edtInfo);

    }

    @Override
    public void onCreateContextMenu(
            ContextMenu menu,
            View view,
            ContextMenu.ContextMenuInfo menuInfo
    ) {
        super.onCreateContextMenu(menu, view, menuInfo);

        mt("onCreateContextMenu");

        if(view == txtInfo) {
            MenuItem menuItem = menu.add(0, MENU_PASTE, 0, "Paste");
            menuItem.setCheckable(true);
            if(chkSettings.isChecked()) {
                menu.add(0, MENU_APPEND, 0, "Append");
            }
        }

        if(view == edtInfo) {
            MenuItem menuItem = menu.add(0, MENU_COPY, 0, "Copy");
            menuItem.setCheckable(true);
            menu.add(0, MENU_CUT, 0, "Cut");
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COPY:
                text = edtInfo.getText().toString();
                break;
            case MENU_CUT:
                text = edtInfo.getText().toString();
                edtInfo.setText("");
                break;
            case MENU_PASTE:
                txtInfo.setText(text);
                break;
            case MENU_APPEND:
                txtInfo.append(text);
                break;
        }
        return true;
    }

    private void initViews(){
        chkSettings = findViewById(R.id.chkSettings);
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mt("onCreateOptionsMenu");

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);



        /*MenuItem item = menu.add(0, MENU_INFO, 0, "Info");
        item.setIcon(R.drawable.info);
        item.setAlphabeticShortcut('i');
        item.setNumericShortcut('0');
        item.setCheckable(true);
        item.setChecked(true);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add(0, MENU_HELP, 0, "Help");

        SubMenu subMenuSettings = menu.addSubMenu(0, MENU_SETTINGS, 0, "Settings");
        subMenuSettings.add(1, MENU_PHONE_SETTINGS, 0, "Phone Settings");
        subMenuSettings.add(1, MENU_SYSTEM_SETTINGS, 0, "System Settings");

        menu.add(0, MENU_EXIT, 0, "Exit");*/

        //menu.setGroupDividerEnabled(true);


        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");

       MenuItem menuItemSettings = menu.findItem(R.id.menuSettings);
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
            case R.id.menuInfo:
                mt("Info selected");
                break;
            case R.id.menuHelp:
                mt("Help Selected");
                break;
            case R.id.menuSettings:
                mt("Settings Selected");
                break;
            case R.id.menuExit:
                finish();
                break;
            case R.id.menuPhoneSettings:
                mt("Phone Settings");
                break;
            case R.id.menuSystemSettings:
                mt("System Settings");
                break;
        }

       /* switch (item.getItemId() ) {
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
*/
        return true;
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}