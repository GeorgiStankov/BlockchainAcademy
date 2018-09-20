package academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.*;

public class ThirdQuestion {

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String title = bf.readLine();
		URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title);
		JsonObject firstPage = getPage(url);
		int pages = firstPage.get("total_pages").getAsInt();
		
		List<String> titles = new ArrayList<String>();
		for (int i = 1; i <= pages; i++) {
			URL urlPerPage = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title + "&page=" + i);
			JsonObject page = getPage(urlPerPage);
			for (JsonElement item : page.get("data").getAsJsonArray()) {
				titles.add(item.getAsJsonObject().get("Title").getAsString());
			}
		}
		Collections.sort(titles);
		printMovies(titles);
		bf.close();
	}

	public static JsonObject getPage(URL url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String output = bf.readLine();
		JsonObject jsonObj = new Gson().fromJson(output, JsonObject.class);
		return jsonObj;
	}
	
	public static void printMovies(List<String> list) {
		for (String item : list) {
			System.out.println(item);
		}
	}
}
