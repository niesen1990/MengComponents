package com.cmbb.smartkids.testmenglist;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.cmbb.smartkids.menglist.CommonListView;
import com.cmbb.smartkids.menglist.CompatOnItemClickListener;
import com.cmbb.smartkids.testmenglist.db.SmartKidContract;

/**
 * 测试MengList
 * N.Sun
 */
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CommonListView listView;
    private SimpleCursorAdapter mSimpleCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSimpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.test_list_item, null, new String[]{SmartKidContract.PostModelWonderful.COLUMN_CONTEXT}, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView = new CommonListView(this) {
            @Override
            public CursorAdapter getAdapter(Context context) {
                return mSimpleCursorAdapter;
            }

            @Override
            public void getDataFromServer(int currentId) {
                Log.i(TAG, "getDataFromServer");
                /*PostWonderful.findByAreaTypeFromPlate(new PostWonderful.ResponseCallback() {
                    @Override
                    public void getDataSuccess() {

                    }

                    @Override
                    public void getDataFailure() {

                    }
                });*/
            }
        };
        listView.setOnItemClickListener(new CompatOnItemClickListener() {
            @Override
            public void onCompatItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hello " + position, Toast.LENGTH_LONG).show();
            }
        });
        ((RelativeLayout) findViewById(R.id.container)).addView(listView.getView());
        ((RelativeLayout) findViewById(R.id.container)).post(new Runnable() {
            @Override
            public void run() {
                listView.refresh(false);
            }
        });

        // 加载数据
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, SmartKidContract.PostModelWonderful.TABLE_CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        listView.onGetDataSuccess(1, data, System.currentTimeMillis());
        mSimpleCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mSimpleCursorAdapter.swapCursor(null);
    }
}
