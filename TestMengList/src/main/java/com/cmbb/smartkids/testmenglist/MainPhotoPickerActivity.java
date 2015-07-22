package com.cmbb.smartkids.testmenglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cmbb.smartkids.photopicker.PhotoPickerActivity;
import com.cmbb.smartkids.photopicker.utils.PhotoPickerIntent;
import com.pgyersdk.feedback.PgyFeedbackShakeManager;
import com.pgyersdk.update.PgyUpdateManager;

import java.util.List;

public class MainPhotoPickerActivity extends AppCompatActivity {

    public final static int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_photo_picker);
        assignViews();
    }

    private Button button, button2;

    private void assignViews() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoPickerIntent intent = new PhotoPickerIntent(MainPhotoPickerActivity.this);
                intent.setPhotoCount(9);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PgyUpdateManager.register(MainPhotoPickerActivity.this, App.PGY_APPID);

                /*PgyUpdateManager.register(MainPhotoPickerActivity.this, App.PGY_APPID,
                        new UpdateManagerListener() {

                            @Override
                            public void onUpdateAvailable(final String result) {
                                // 调用sdk的默认下载，apk下载地址为result字符串中downloadURL对应的值
                                String downloadUrl = "apk下载地址";
                                Log.i("pgy", "pgy result = " + result);
                                //startDownloadTask(MainActivity.this, downloadUrl);
                            }

                            @Override
                            public void onNoUpdateAvailable() {
                            }
                        });*/
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        PgyFeedbackShakeManager.register(MainPhotoPickerActivity.this, App.PGY_APPID);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PgyFeedbackShakeManager.unregister();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<String> photos = null;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            }
            if (photos != null) {
                for (int i = 0; i < photos.size(); i++) {
                    Log.i("photo", "photo path = " + photos.get(i));
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_photo_picker, menu);
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
}
