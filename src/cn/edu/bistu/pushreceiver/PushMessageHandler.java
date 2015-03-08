package cn.edu.bistu.pushreceiver;



import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PushMessageHandler {
	private static Context context;
	private static String data;
	
	public Context getContext() {
		return context;
	}

	public PushMessageHandler setContext(Context context) {
		PushMessageHandler.context = context;
		return this;
	}

	public String getData() {
		return data;
	}


	public PushMessageHandler(){
		
	}
	
	public PushMessageHandler(String data){
		this.data = data;
	}

	public  void handle() {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, ShowPushMessageActivity.class);
		intent.putExtra("ShowMessage", data);
		Log.d("ppp", "re:" + data);
		context.startActivity(intent);

		
	}
	
}
