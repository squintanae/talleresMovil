package com.example.taller1;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import com.example.taller1.databinding.ActivityFibonacciBinding;

import android.widget.LinearLayout;

public class Fibonacci extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageButton imageButton;
    WebView webView;
    ArrayList<Integer> fibonacci_sequence = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);


        imageButton=findViewById(R.id.image_button);
        webView=findViewById(R.id.web_view);
        linearLayout=findViewById(R.id.linear_layout);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setWebViewClient(new WebViewClient());
                linearLayout.removeAllViewsInLayout();
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
            }
        });

        fibonacci_function();
    }

    public void fibonacci_function(){
        int number = getIntent().getIntExtra("number",0);
        fibonacci_sequence.add(0);
        fibonacci_sequence.add(1);
        int aux1, aux2 = 0;
        for(int i = 1; i < number; i++){
            aux1 = fibonacci_sequence.get(i-1);
            aux2 = fibonacci_sequence.get(i);
            fibonacci_sequence.add(aux1 + aux2);
        }
        for(Integer n: fibonacci_sequence){
            TextView textView = new TextView(this);
            textView.setText(""+n);
            textView.setId(n);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) linearLayout).addView(textView);
        }

    }
}
