import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/*The APIConnector class provides two methods to access data from the web site.
 *downloadFromURLWithToken() will download data from a URL
 *uploadToURLWithToken() will upload data to a URL
 */
public class APIConnector {

	public static String downloadFromURLWithToken(String url, String token) {

		String tmp = url + "?token=" + token;
		StringBuffer content = new StringBuffer();
		BufferedReader reader = null;
		URLConnection connection = null;
		try {
			connection = new URL(tmp).openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static void uploadToURLWithToken(String url, String token, String data) {

		String tmp = url + "?token=" + token;
		OutputStreamWriter writer = null;
		URLConnection conn = null;
		BufferedReader reader = null;
		try {
			conn = new URL(tmp).openConnection();
			conn.setDoOutput(true);
			writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(data);
			writer.flush();
			writer.close();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}