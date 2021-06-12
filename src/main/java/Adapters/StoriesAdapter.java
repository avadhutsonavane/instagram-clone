package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyHolder>{
    Context context;
    @NonNull
    @Override
    public StoriesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_stories, parent, false);
        return new StoriesAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        CircleImageView article_image;
        TextView article_title;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            article_image=(CircleImageView)itemView.findViewById(R.id.article_image);
            article_title=(TextView)itemView.findViewById(R.id.article_title);
        }
    }
}
