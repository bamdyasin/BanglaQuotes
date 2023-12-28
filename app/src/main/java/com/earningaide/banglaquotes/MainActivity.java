package com.earningaide.banglaquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    HashMap<String, String> myHashMap;
    ArrayList<HashMap <String, String>> myArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.myListView);

        MyAdapter myAdapter = new MyAdapter();
        myListView.setAdapter(myAdapter);

        for (int i = 1; i <= 20; i++) {
            String title = getString(getResources().getIdentifier("quote" + i + "_title", "string", getPackageName()));
            String author = getString(getResources().getIdentifier("quote" + i + "_author", "string", getPackageName()));
            String description = getString(getResources().getIdentifier("quote" + i + "_description", "string", getPackageName()));

            HashMap<String, String> myHashMap = new HashMap<>();
            myHashMap.put("Title", title);
            myHashMap.put("Author", author);
            myHashMap.put("Body", description);

            myArrayList.add(myHashMap);
        }


    }//===================== onCreate End ==============================


    private class MyAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;
        @Override
        public int getCount() {
            return myArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.single_item,parent, false);

            TextView tvTitle = myView.findViewById(R.id.tvTitle);
            TextView tvAuthor = myView.findViewById(R.id.tvAuthor);


            HashMap <String, String> getHashMapItem =myArrayList.get(position);
            String Title = getHashMapItem.get("Title");
            String Author = getHashMapItem.get("Author");
            String Body =getHashMapItem.get("Body");

            tvTitle.setText(Title);
            tvAuthor.setText(Author);

            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ContentActivity.quoteTitle = Title;
                    ContentActivity.quoteAuthor = Author;
                    ContentActivity.quoteBody = Body;

                    Intent i = new Intent(MainActivity.this,ContentActivity.class);
                    startActivity(i);
                }
            });









            return myView;
        }
    }
}