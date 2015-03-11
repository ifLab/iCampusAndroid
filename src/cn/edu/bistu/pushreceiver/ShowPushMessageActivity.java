package cn.edu.bistu.pushreceiver;


import cn.jpush.android.api.JPushInterface;

import com.example.icampus2_2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowPushMessageActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showpushmessage);
		TextView tv = (TextView)findViewById(R.id.PushMessageView);

        //TextView tv = new TextView(this);
        Intent intent = getIntent();
        if (null != intent) {
	        Bundle bundle = getIntent().getExtras();
	        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
	        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
	        tv.setText(content);
        }
       
		/*
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String data = bundle.getString("ShowMessage");
		
		*/
		//Toast toast = Toast.makeText(this, content, Toast.LENGTH_SHORT);
		//toast.show();
        //addContentView(tv, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	}
}
