package cn.edu.bistu.pushreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.mapcore.util.p;
import com.igexin.sdk.PushConsts;

public class PushGetuiReceiver extends BroadcastReceiver {
	private static PushMessageHandler messageHandler;
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Log.d("GetuiSdkDemo", "onReceive() action=" + bundle.getInt("action"));
		switch (bundle.getInt(PushConsts.CMD_ACTION)) {
		case PushConsts.GET_MSG_DATA:
			// 获取透传（payload）数据
			byte[] payload = bundle.getByteArray("payload");
			if (payload != null) {
				String data = new String(payload);
				Log.d("GetuiSdkDemo", "Got Payload:" + data);
				Log.d("ppp", "recev:" + data);
				Log.d("ppp","recev:" + context);
				messageHandler = new PushMessageHandler(data);
				// TODO:接收处理透传（payload）数据
			}
			break;
		// 添加其他case
		// .........
		default:
			break;
		}
	}
	
	public static PushMessageHandler getMessageHandler() {
		return messageHandler;
	}
	
	public static void resetMessageHandler() {
		messageHandler = null;
	}
}
