package com.example.heirix.myapp;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class DisplayTableActivity extends Activity
{
    private final String[] letters = { "ก","ข","ฃ","ค","ฅ","ฆ","ง","จ","ฉ","ช","ซ","ฌ","ญ","ฎ","ฏ","ฐ","ฑ","ฒ","ณ","ด","ต","ถ","ท",
                                 "ธ","น","บ","ป","ผ","ฝ","พ","ฟ","ภ","ม","ย","ร","ล","ว","ศ","ษ","ส","ห","ฬ","อ","ฮ", };
    private GridView mGrid;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_table);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.grid_text_item_1 , letters);
        mGrid = findViewById(R.id.gridView1);
        mGrid.setAdapter(adapter);

        GridView.OnItemClickListener onItemClickHandler = new AdapterView.OnItemClickListener() {  // Create a message handling object as an anonymous class.
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText( DisplayTableActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
            }
        };
        mGrid.setOnItemClickListener(onItemClickHandler);
    }

//    public void onClick_buttonChangeFont (View v)
//    {
//        Toast.makeText( this, "onClick_buttonChangeFont", Toast.LENGTH_SHORT).show();
//        TextView text1 = (TextView)findViewById(R.id.tvGrid1);
//        text1.setTextSize(80);
//        text1.setTypeface(typeface2);
//    }

}
