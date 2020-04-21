package com.example.ultimate_ielts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDfOpener extends AppCompatActivity {

    PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_opener);

        myPDFViewer=(PDFView) findViewById(R.id.pdfViewer);

        String getItem= getIntent().getStringExtra("pdfFileName");

        if(getItem.equals("IELTS এর প্রাথমিক ধারণা")){

            myPDFViewer.fromAsset("intro.pdf").load();
        }

        if(getItem.equals("প্রস্তুতি পর্ব")){

            myPDFViewer.fromAsset("item 2.pdf").load();
        }

        if(getItem.equals("IELTS গ্রহণযোগ্যতা")){

            myPDFViewer.fromAsset("item 3.pdf").load();
        }

        if(getItem.equals("IELTS: Reading Section")){

            myPDFViewer.fromAsset("item 4.pdf").load();
        }

        if(getItem.equals("IELTS: Writing Section")){

            myPDFViewer.fromAsset("item 5.pdf").load();
        }

        if(getItem.equals("IELTS: Listening Section")){

            myPDFViewer.fromAsset("item 6.pdf").load();
        }

        if(getItem.equals("IELTS: Speaking Section")){

            myPDFViewer.fromAsset("item 7.pdf").load();
        }

        if(getItem.equals("IELTS পরীক্ষায় GRAMMAR")){

            myPDFViewer.fromAsset("item 8.pdf").load();
        }

        if(getItem.equals("IELTS VOCABULARY")){

            myPDFViewer.fromAsset("item 9.pdf").load();
        }

        if(getItem.equals("IELTS ফ্রি মক টেস্ট")){

            myPDFViewer.fromAsset("item 10.pdf").load();
        }

        if(getItem.equals("Barron’s 333 Words")){

            myPDFViewer.fromAsset("Barrons333.pdf").load();
        }

        if(getItem.equals("Quiz Test")){


        }

    }
}
