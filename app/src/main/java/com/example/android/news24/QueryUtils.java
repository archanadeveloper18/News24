package com.example.android.news24;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    public static List<News> fetchNewsData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {

        }
        // Extract relevant fields from the JSON response and create a list of {@link news}s
        List<News> news = extractFeatureFromJson(jsonResponse);
        // Return the list of {@link news}s
        return news;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {

        }
        return url;
    }


    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {

            }
        } catch (IOException e) {

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<News> extractFeatureFromJson(String newsJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        List<News> news = new ArrayList<>();

        try {
            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            JSONObject baseJsonResponse = new JSONObject(newsJSON);
            JSONObject responseObject = baseJsonResponse.getJSONObject("response");
            JSONArray newsArray = responseObject.optJSONArray("results");

            for (int i = 0; i < newsArray.length(); i++) {

                JSONObject currentNews = newsArray.getJSONObject(i);

                String articalTittle = currentNews.getString("webTitle");
                String articalSection = currentNews.getString("sectionName");
                String articalAuthor = currentNews.getString("pillarName");
                String date = currentNews.getString("webPublicationDate");
                String url = currentNews.getString("webUrl");

                News newsItem = new News(articalSection, articalTittle, date, url, articalAuthor);
                news.add(newsItem);
            }

        } catch (JSONException e) {

        }
        return news;
    }

}
