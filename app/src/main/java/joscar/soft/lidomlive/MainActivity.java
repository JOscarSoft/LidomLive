package joscar.soft.lidomlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    WebView Browser;
    Timer Temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Browser = findViewById(R.id.Browser);
        Browser.setWebViewClient(new WebViewClient());

        WebSettings BrowserSettings = Browser.getSettings();
        BrowserSettings.setJavaScriptEnabled(true);

        SetLoop();
    }

    private void SetLoop(){

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(seText);
            }
        };

        Temp = new Timer();
        Temp.schedule(task, 1000,15000);
    }



    final Runnable seText = new Runnable() {
        @Override
        public void run() {
            Browser.loadUrl("https://www.licey.com/wp-content/plugins/licey-gameday/liceygameday_new.html");
        }
    };
}
