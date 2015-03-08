package cn.edu.bistu.pushreceiver;


import com.example.icampus2_2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowPushMessageActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showpushmessage);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String data = bundle.getString("ShowMessage");
		
		TextView textView = (TextView)findViewById(R.id.PushMessageView);
		textView.setText(data);
		
		//Toast toast = Toast.makeText(this, data, Toast.LENGTH_SHORT);
		//toast.show();
		
	}
}
