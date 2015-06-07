package edu.ucsb.cs.cs185.fstruong.sleepysale;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import java.util.*;
import android.widget.*;


public class MainActivity extends ActionBarActivity {
    ListView list_view;
    List<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.menu);
        list.add("Beauty");
        list.add("Electronics");
        list.add("Fashion");
        list.add("Household");
        list.add("Motors");
        list.add("Misc");
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click event works.", Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("List Item");
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View findView = (inflater.inflate(R.layout.menu, null));
                builder.setView(findView);
                list_view = (ListView) findView.findViewById(R.id.lv);
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, list);
//                list_view.setAdapter(adapter);
                builder.setAdapter(adapter,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String item = adapter.getItem(which);
                                Button btn = (Button) findViewById(R.id.button);
                                btn.setText(item);
                                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void selectCategory(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Category");
        LayoutInflater inflater = LayoutInflater.from(this);
        final View findView = (inflater.inflate(R.layout.menu, null));
//        list_view = (ListView) findView.findViewById(R.id.lv);
//        list.add("Beauty");
//        list.add("Electronics");
//        list.add("Fashion");
//        list.add("Household");
//        list.add("Motors");
//        list.add("Misc");
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
//        list_view.setAdapter(adapter);
//
//        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//
//                String item = ((TextView)view).getText().toString();
//
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
//            }
//        });
        builder.setView(findView);
    }
}
