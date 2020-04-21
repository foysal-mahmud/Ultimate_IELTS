package com.example.ultimate_ielts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView pdfListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfListView=(ListView) findViewById(R.id.myPDFList); //casting

        // String array for different names
        String[] pdfFiles={"IELTS এর প্রাথমিক ধারণা", "প্রস্তুতি পর্ব", "IELTS গ্রহণযোগ্যতা", "IELTS: Reading Section","IELTS: Writing Section",
        "IELTS: Listening Section","IELTS: Speaking Section","IELTS পরীক্ষায় GRAMMAR","IELTS VOCABULARY", "IELTS ফ্রি মক টেস্ট", "Barron’s 333 Words","Quiz Test"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1,pdfFiles){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView mytext = (TextView) view.findViewById(android.R.id.text1);

                return view;
            }
            };

        //set array adapter for string list view
        pdfListView.setAdapter(adapter);

        // Onclick listener event generate
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String item = pdfListView.getItemAtPosition(i).toString();

                Intent start = new Intent(getApplicationContext(),PDfOpener.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
    }
}
