package Acitvity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.instagramclone.R;
import Adapters.CenterZoomLayoutManager;
import Adapters.StoriesAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recently_added_stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        CenterZoomLayoutManager centerZoomLayoutManager = new CenterZoomLayoutManager(MainActivity.this, 0, false);
        recently_added_stories = (RecyclerView) findViewById(R.id.recently_added_stories);
        recently_added_stories.setLayoutManager(centerZoomLayoutManager);
    }
    @Override
    protected void onResume() {
        super.onResume();
        StoriesAdapter storiesAdapter = new StoriesAdapter();
        recently_added_stories.setAdapter(storiesAdapter);
    }
}
