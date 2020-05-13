package ldansorean.s5downloadwebcontent;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String WEBSITE_URL = "https://www.ecowebhosting.co.uk/";

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = findViewById(R.id.status);
        DownloadTask downloadTask = new DownloadTask(status);
        downloadTask.execute(WEBSITE_URL);
    }
}
