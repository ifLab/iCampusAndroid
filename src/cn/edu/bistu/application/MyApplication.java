package cn.edu.bistu.application;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MyApplication extends com.baidu.frontia.FrontiaApplication {
	public static String CASUrl = null;
	public static String OAuthUrl = null;
	public static String AndroidUpgradeUrl = null;
	public static String jwApiUrl = null;
	public static String IcampusApiUrl = null;
	public static String NewsApiUrl = null;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://m.bistu.edu.cn/icampus_config.json",
				new AsyncHttpResponseHandler() {

					@Override
					public void onFailure(int arg0, Header[] arg1, byte[] arg2,
							Throwable arg3) {
						// TODO Auto-generated method stub
						super.onFailure(arg0, arg1, arg2, arg3);
					}

					@Override
					public void onRetry() {
						// TODO Auto-generated method stub
						super.onRetry();
					}

					@Override
					public void onStart() {
						// TODO Auto-generated method stub
						super.onStart();
					}

					@Override
					public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
						// TODO Auto-generated method stub
						super.onSuccess(arg0, arg1, arg2);
						String info = new String(arg2);
						try {
							JSONArray jsonArray = new JSONArray(info);
							JSONObject jsonObject = jsonArray.getJSONObject(0);
							CASUrl = jsonObject.getString("CAS");
							OAuthUrl = jsonObject.getString("oAuth2");
							AndroidUpgradeUrl = jsonObject
									.getString("AndroidUpgrade");
							jwApiUrl = jsonObject.getString("jwApi");
							IcampusApiUrl = jsonObject.getString("icampusApi");
							NewsApiUrl = jsonObject.getString("newsApi");
							SharedPreferences sharedPreferences = getApplicationContext()
									.getSharedPreferences("url",
											Context.MODE_PRIVATE);
							SharedPreferences.Editor editor = sharedPreferences
									.edit();
							editor.putString("CASUrl", CASUrl);
							editor.putString("OAuthUrl", OAuthUrl);
							editor.putString("AndroidUpgradeUrl",
									AndroidUpgradeUrl);
							editor.putString("jwApiUrl", jwApiUrl);
							editor.putString("IcampusApiUrl", IcampusApiUrl);
							editor.putString("NewsApiUrl", NewsApiUrl);
							editor.apply();
						} catch (JSONException e) {
							// TODO Auto-generated catch blockt
						}

					}

					@Override
					public void onFinish() {
						// TODO Auto-generated method stub
						SharedPreferences sharedPreferences = getApplicationContext()
								.getSharedPreferences("url",
										Context.MODE_PRIVATE);
						if (CASUrl == null) {
							CASUrl = sharedPreferences.getString("CASUrl", "https://auth.bistu.edu.cn");
						}
						if (OAuthUrl == null) {
							OAuthUrl = sharedPreferences.getString("OAuthUrl", "https://222.249.250.89:8443");
						}
						if (AndroidUpgradeUrl == null) {
							AndroidUpgradeUrl = sharedPreferences.getString("AndroidUpgradeUrl", "http://m.bistu.edu.cn/upgrade/Android.php");
						}
						if (jwApiUrl == null) {
							jwApiUrl = sharedPreferences.getString("jwApiUrl", "http://m.bistu.edu.cn/jiaowu");
						}
						if (IcampusApiUrl == null) {
							IcampusApiUrl = sharedPreferences.getString("IcampusApiUrl", "http://m.bistu.edu.cn/api");
						}
						if (NewsApiUrl == null) {
							NewsApiUrl = sharedPreferences.getString("NewsApiUrl", "http://m.bistu.edu.cn/newsapi");
						}
						super.onFinish();
					}

				});
	}
}