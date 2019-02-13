package com.example.kson.ksonanotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kson.ksonanotation.butterknife.BindView;
import com.example.kson.ksonanotation.butterknife.ButterKnife;
import com.example.kson.ksonanotation.butterknife.ContentView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);//绑定
        tv.setText("new");
    }
}
