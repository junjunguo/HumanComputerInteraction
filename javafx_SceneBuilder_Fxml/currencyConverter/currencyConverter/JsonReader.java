import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** Created by GuoJunjun <junjunguo.com> on 17.01.15. */

public class JsonReader {

    public static String getCurrency(String from, String to) {
        return getJsonStr("http://rate-exchange.appspot.com/currency?from=" + from + "&to=" + to);
    }

    /**
     * get Json String
     *
     * @param urlStr a string url
     * @return Json String
     */
    private static String getJsonStr(String urlStr) {

        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String currencyJsonStr = null;

        try {
            URL url = new URL(urlStr);

            // Create the request , and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                currencyJsonStr = null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                currencyJsonStr = null;
            }
            currencyJsonStr = buffer.toString();
        } catch (IOException e) {
            System.out.println("Json reader " + "Error " + e);
            // If the code didn't successfully get the data, there's no point in attempting to parse it.
            currencyJsonStr = null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    System.out.println("Json reader " + "Error closing stream" + e);
                }
            }
            return currencyJsonStr;
        }
    }
}
