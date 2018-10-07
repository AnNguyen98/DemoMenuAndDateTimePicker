package com.theannguyen.demomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button showPopUpMenu;
    Spinner spinnerCourse;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPopUpMenu = (Button) findViewById(R.id.btnShowUpMenu);
        spinnerCourse = (Spinner) findViewById(R.id.spCourse);

        arrayList = new ArrayList<>();
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("Unity");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerCourse.setAdapter(arrayAdapter);
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arrayList.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        showPopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,showPopUpMenu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.ios1:
                                Toast.makeText(MainActivity.this,"IOS",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.android1:
                                Toast.makeText(MainActivity.this,"IOS",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        registerForContextMenu(showPopUpMenu);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Course");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.context1:
                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context2:
                Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context3:
                Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.android:
                Toast.makeText(MainActivity.this,"Android",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ios:
                Toast.makeText(MainActivity.this,"IOS",Toast.LENGTH_SHORT).show();
                break;
            case R.id.unity:
                Toast.makeText(MainActivity.this,"Unity",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nodejs:
                Toast.makeText(MainActivity.this,"NodeJS",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                break;
            case R.id.email:
                Toast.makeText(MainActivity.this,"Email",Toast.LENGTH_SHORT).show();
                break;
            case R.id.phone:
                Toast.makeText(MainActivity.this,"Phone",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this,"Default",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
