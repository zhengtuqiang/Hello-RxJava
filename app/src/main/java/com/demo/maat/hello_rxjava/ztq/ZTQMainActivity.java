package com.demo.maat.hello_rxjava.ztq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.demo.maat.hello_rxjava.R;

import rx.Observable;
import rx.Subscriber;

public class ZTQMainActivity extends AppCompatActivity {

    public static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ztqmain);
        //被观察者
        Observable switcher = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("On");
                subscriber.onNext("Off");
                subscriber.onNext("On");
                subscriber.onNext("On");
                subscriber.onCompleted();
            }
        });
        //观察者
        Subscriber light = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "结束观察。。。");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "handle this -->" + s);
            }
        };

        switcher.subscribe(light);
    }
}
