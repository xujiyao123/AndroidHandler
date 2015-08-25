package com.xujiyao.xujiyao.handler;

import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.logging.Handler;


public class MainActivity extends ActionBarActivity {
    private Button button;
    private android.os.Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.buttonid);
        handler = new FirstHandler();
        button.setOnClickListener(new ButtonLisener());
    }
//当用户点击按钮式我们创建一个消息对象
    class ButtonLisener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
           Message msg = handler.obtainMessage(); //获取消息对象
            msg.what = 2;
            handler.sendMessage(msg);


            //上面一行代码将消息对象放置到消息队列当中
            //looper将会取出消息对象
            //loopre将会找到与消息对象对应的handerle对象
            //looper将会调用handerle 的handlemessage处理消息
        }
    }
    class FirstHandler extends android.os.Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            System.out.println(what);
        }
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
}
