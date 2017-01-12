package ykk.handler3.com.handler_03;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button_Id);
        button.setOnClickListener(this);
        WorkerThread wt=new WorkerThread();
        wt.start();

    }

    @Override
    public void onClick(View v) {
        Log.d("Main",Thread.currentThread().getName());
        Message msg=handler.obtainMessage();
        handler.sendMessage(msg);

    }
    class WorkerThread extends Thread {
        @Override
        public void run() {
            //准备Looper对象
            Looper.prepare();
            //在workerThread当中生成一个Handler对象
            handler=new Handler()
            {
                @Override
                public void handleMessage(Message msg) {
                    Log.d("WorkThread",Thread.currentThread().getName());
                }
            };
            Looper.loop();

        }
    }
}
