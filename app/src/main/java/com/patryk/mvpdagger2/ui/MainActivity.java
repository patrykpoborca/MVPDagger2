package com.patryk.mvpdagger2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.patryk.mvpdagger2.MVPApp;
import com.patryk.mvpdagger2.R;
import com.patryk.mvpdagger2.base.BasePresenterActivity;
import com.patryk.mvpdagger2.dagger.BaseComponent;
import com.patryk.mvpdagger2.dagger.DaggerBaseComponent;
import com.patryk.mvpdagger2.dagger.DaggerPresenterComponent;
import com.patryk.mvpdagger2.dagger.PresenterModule;
import com.patryk.mvpdagger2.ui.presenterinterfaces.MainActivityPresenter;
import com.patryk.mvpdagger2.ui.viewinterfaces.MainActivityView;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainActivity extends BasePresenterActivity<MainActivityPresenter> implements MainActivityView{

    @Inject MainActivityPresenter mMainActivityPresenter;

    /*
    Other topics to delve into.. .Lazy && Provider
     */

    private TextView mTextView;
    private View mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mTextView =(TextView) findViewById(R.id.tweet_text);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().getRandomTweet();
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

    @Override
    protected MainActivityPresenter getPresenter() {
        if(mMainActivityPresenter == null){
            //do dagger stuff


            DaggerPresenterComponent.builder()
                                .baseComponent(MVPApp.getBaseComponent())
                                .presenterModule(new PresenterModule())
                                .build().inject(this);
            mMainActivityPresenter.registerView(this);
        }

        return mMainActivityPresenter;
    }

    @Override
    public void postTweet(String tweet) {
        mTextView.setText(tweet);
    }

    //demonstration... not used.
    @Override
    public String getStringById(int id) {
        return getResources().getString(id);
    }
}
