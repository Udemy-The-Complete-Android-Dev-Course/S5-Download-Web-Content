package ldansorean.s5downloadwebcontent;

import android.os.AsyncTask;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        try {
            URL url = new URL(urls[0]);
            InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream());
            int currentChar = reader.read();
            while (currentChar != -1 ) {
                result += (char) currentChar;
                currentChar = reader.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
