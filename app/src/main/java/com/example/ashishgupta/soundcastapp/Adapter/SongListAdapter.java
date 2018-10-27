package com.example.ashishgupta.soundcastapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    private List<Song> mItems;
    private Context mContext;
    private PostItemListener postItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleSongTextView;
        private ImageView songThumbNailImageView;
        private PostItemListener postItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);

            titleSongTextView = (TextView) itemView.findViewById(R.id.item_song_list_song_name);
            songThumbNailImageView = itemView.findViewById(R.id.item_song_list_song_icon);
            this.postItemListener = postItemListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Song item = getItem(getAdapterPosition());
            postItemListener.onPostClick(mItems,getAdapterPosition());

        }
    }

    public SongListAdapter(Context context, List<Song> posts, PostItemListener postItemListener) {

        this.mItems = posts;
        this.mContext = context;
        this.postItemListener = postItemListener;

    }

    @Override
    public SongListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_song_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView,this.postItemListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(SongListAdapter.ViewHolder holder, int position) {

        Song item = mItems.get(position);
        TextView textView = holder.titleSongTextView;
        textView.setText(item.getTitle());
        ImageView imageView = holder.songThumbNailImageView;
        Picasso.get().load(item.getThumbnail()).into(imageView);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private Song getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {

        void onPostClick(List<Song> songs, int position);

    }

}