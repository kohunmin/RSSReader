package rssfeed.android.example.com.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);
    }

    @Override
    public void onRssItemSelected(String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);
            if(fragment != null  && fragment.isInLayout()) {
                fragment.setText(link);
            } else {
                Intent intent = new Intent(getApplicationContext(),
                        DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_URL, link);
                startActivity(intent);
            }
    }
}
