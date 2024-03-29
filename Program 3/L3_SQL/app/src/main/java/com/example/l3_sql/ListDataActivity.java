package com.example.l3_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class ListDataActivity extends AppCompatActivity
{
    private static final String TAG="ListDataActivity";

    DatabaseHealper mDatabaseHelper;
    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        mlistView= (ListView) findViewById(R.id.listView);
        mDatabaseHelper=new DatabaseHealper(this);
        populateListView();
    }
    private void populateListView() {
        Log.d(TAG,"Populate ListView: Displaying data in ListView");

        Cursor data=mDatabaseHelper.getData();
        ArrayList<String> listData=new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mlistView.setAdapter(adapter);
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}