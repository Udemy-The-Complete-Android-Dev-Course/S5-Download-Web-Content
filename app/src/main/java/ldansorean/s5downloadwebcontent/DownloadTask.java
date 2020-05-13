package ldansorean.s5downloadwebcontent;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.InputStreamReader;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Integer, String> {

    private TextView status;

    public DownloadTask(TextView status) {
        this.status = status;
    }

    @Override
    protected String doInBackground(String... urls) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urls[0]);
            InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream());
            long start = System.currentTimeMillis();

            int currentChar = reader.read();
            while (currentChar != -1 ) {
                result.append((char) currentChar);
                currentChar = reader.read();
                publishProgress(result.length());
            }

            long end = System.currentTimeMillis();
            long durationSec = (end - start) / 1000;
            Log.i("website", "Download duration: " + durationSec + "s.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if (values[0] % 1000 == 0) {
            status.setText("Downloaded " + (values[0] / 1000) + "k characters");
        }
    }

    @Override
    protected void onPostExecute(String result) {
        status.setText("Done! Check logs for content.");
        Log.i("website", result);
    }
}
