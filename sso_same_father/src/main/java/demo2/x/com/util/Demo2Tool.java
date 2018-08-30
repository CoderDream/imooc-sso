package demo2.x.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo2Tool {

	public static String doGet(String url, String cookieName, String cookieValue) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpURLConnection = null;
		try {
			// 创建URL对象
			URL urls = new URL(url + "?cookieName=" + cookieName + "&cookieValue=" + cookieValue);
			// 得到链接
			httpURLConnection = (HttpURLConnection) urls.openConnection();
			// 设置方法
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			InputStream in = httpURLConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			isr.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != httpURLConnection) {
				httpURLConnection.disconnect();
			}
		}

		return sb.toString();
	}
}
