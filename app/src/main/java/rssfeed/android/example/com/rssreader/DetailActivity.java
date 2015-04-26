package rssfeed.android.example.com.rssreader;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by kohunmin on 2015. 4. 26..
 */
public class DetailActivity extends Activity{
    public static final String EXTRA_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Need to check if activity has been switched to landscape mode
        // If yes, finished and go back to the start Activity
        if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        if ( extras != null) {
            String url = extras.getString(EXTRA_URL);
            DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                    .findFragmentById(R.id.detailFragment);
            detailFragment.setText(url);
        }
    }
}
