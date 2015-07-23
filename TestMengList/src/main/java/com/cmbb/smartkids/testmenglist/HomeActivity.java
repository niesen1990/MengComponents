package com.cmbb.smartkids.testmenglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMaterial;
    private Button btnRecycler;
    private Button btnPicker;
    private Button btnBsheets;
    private Button btnPalettle;
    private Button btnUpdate;
    private Button btnTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (null != bar) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
        assignViews();
    }


    private void assignViews() {
        btnMaterial = (Button) findViewById(R.id.btn_material);
        btnMaterial.setOnClickListener(this);
        btnRecycler = (Button) findViewById(R.id.btn_recycler);
        btnRecycler.setOnClickListener(this);
        btnPicker = (Button) findViewById(R.id.btn_picker);
        btnPicker.setOnClickListener(this);
        btnBsheets = (Button) findViewById(R.id.btn_bsheets);
        btnBsheets.setOnClickListener(this);
        btnPalettle = (Button) findViewById(R.id.btn_palettle);
        btnPalettle.setOnClickListener(this);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(this);
        btnTransition = (Button) findViewById(R.id.btn_transition);
        btnTransition.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_material:
                intent = new Intent(this, MainFrescoActivity.class);
                break;
            case R.id.btn_recycler:
                intent = new Intent(this, MainRecyclerActivity.class);
                break;
            case R.id.btn_picker:
                intent = new Intent(this, MainPhotoPickerActivity.class);
                break;
            case R.id.btn_bsheets:
                intent = new Intent(this, MainBottomSheetActivity.class);
                break;
            case R.id.btn_palettle:
                intent = new Intent(this, MainPaletteActivity.class);
                break;
            case R.id.btn_update:
                intent = new Intent(this, MainPgyActivity.class);
                break;
            case R.id.btn_transition:
                intent = new Intent(this, MainTransitionActivity.class);
                break;
        }
        startActivity(intent);
    }
}
