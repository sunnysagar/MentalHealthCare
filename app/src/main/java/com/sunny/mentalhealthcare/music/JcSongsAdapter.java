package com.sunny.mentalhealthcare.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sunny.mentalhealthtracker.R;

import java.util.List;

public class JcSongsAdapter  extends RecyclerView.Adapter<JcSongsAdapter.SongsAdapterViewHolder>{


    private  int seletedPosition;
    Context context ;
    List<GetSongs> arraylistSongs;
    private final RecyclerItemClickListener listener;

    public JcSongsAdapter(Context context, List<GetSongs> arraylistSongs, RecyclerItemClickListener listener) {
        this.context = context;
        this.arraylistSongs = arraylistSongs;
        this.listener = listener;


    }

    @NonNull
    @Override
    public SongsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.songs_row,parent,false);

        return new SongsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsAdapterViewHolder holder, int position) {


        GetSongs getSongs = arraylistSongs.get(position);

        if(getSongs != null){
            if(seletedPosition == position){
//                holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.hover));
                holder.tv_title.setTextColor(ContextCompat.getColor(context,R.color.hover));
                holder.iv_play_active.setVisibility(View.VISIBLE);
                holder.iv_play_Inactive.setVisibility(View.INVISIBLE);
            }else {
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
                holder.iv_play_active.setVisibility(View.INVISIBLE);
            }

        }


        assert getSongs != null;
        holder.tv_title.setText(getSongs.getSongTitle());
        holder.tv_artist.setText(getSongs.getArtist());
        String duration = Utility.convertDuration(Long.parseLong(getSongs.getSongDuration()));
        holder.tv_duration.setText(duration);

        holder.bind(getSongs, listener);

    }

    @Override
    public int getItemCount() {
        return arraylistSongs.size();
    }

    public static class SongsAdapterViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_title;
        private final TextView tv_artist;
        private final TextView tv_duration;

        RelativeLayout tit;
        ImageView iv_play_active;
        ImageView iv_play_Inactive;
        public SongsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_artist = itemView.findViewById(R.id.tv_artist);
            tv_duration = itemView.findViewById(R.id.tv_duration);
            iv_play_Inactive = itemView.findViewById(R.id.iv_play_inactive);
            iv_play_active = itemView.findViewById(R.id.iv_play_active);
//            tit = itemView.findViewById(R.id.tit);


        }

        public void bind(final GetSongs getSongs, final RecyclerItemClickListener listener) {


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onClickListener(getSongs,getAdapterPosition());
                }
            });
        }
    }

    public interface RecyclerItemClickListener {

        void onClickListener (GetSongs songs, int postion);

    }

    public int getSeletedPosition() {
        return seletedPosition;
    }

    public void setSeletedPosition(int seletedPosition) {
        this.seletedPosition = seletedPosition;
    }
}
