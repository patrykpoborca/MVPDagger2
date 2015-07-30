package com.patryk.mvpdagger2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.patryk.mvpdagger2.demo.models.AnotherClass;
import com.patryk.mvpdagger2.demo.models.dagger.DaggerSomeComponent;

import javax.inject.Inject;

public class SomeActivity extends AppCompatActivity{

    @Inject
    AnotherClass anotherClass;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_some_activity);
        DaggerSomeComponent.builder()
                .build()
                .inject(this);

        ((TextView)findViewById(R.id.sometext)).setText(anotherClass.getSomeText());
    }
}
