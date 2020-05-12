package ldansorean.s5downloadwebcontent;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask downloadTask = new DownloadTask();
        try {
            String download = downloadTask.execute("https://www.ecowebhosting.co.uk/").get();

            TextView statusLabel = findViewById(R.id.status);
            statusLabel.setText("Done! Check logs.");
            Log.i("website", download);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
O