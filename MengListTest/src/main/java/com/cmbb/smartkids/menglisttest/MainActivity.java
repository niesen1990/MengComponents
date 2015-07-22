package com.cmbb.smartkids.menglist;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.cmbb.smartkids.menglist.db.SmartKidContract;
import com.cmbb.smartkids.menglist.network.PostWonderful;

/**
 * 测试MengList
 * N.Sun
 */
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private CommonListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = new CommonListView(this) {
            @Override
            public CursorAdapter getAdapter(Context context) {
                return new SimpleCursorAdapter(MainActivity.this, android.R.layout.test_list_item, null, new String[]{SmartKidContract.PostModelWonderful.COLUMN_CONTEXT},new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            }

            @Override
            public void getDataFromServer(int currentId) {
                PostWonderful.findByAreaTypeFromPlate();

            }
        };
        listView.enableLoadMore(true);
        listView.setOnItemClickListener(new CompatOnItemClickListener() {
            @Override
            public void onCompatItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hello " + position, Toast.LENGTH_LONG).show();
            }
        });
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
        listView.onGetDataSuccess(-1, data,System.currentTimeMillis());
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
