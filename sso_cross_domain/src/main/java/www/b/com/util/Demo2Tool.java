package www.b.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Demo2Tool {

	public static String doGet(String url, Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpURLConnection = null;
		try {
			StringBuffer t_s = new StringBuffer(url).append("?");
			for (Map.Entry<String, String> entry : map.entrySet()) {
				t_s.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			url = t_s.substring(0, t_s.length() - 1);

			// 创建URL对象
			String urlString = url;
			System.out.println("urlString: \t" + urlString);
			URL urls = new URL(urlString);
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
			System.out.println("sb: \t" + sb);
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
