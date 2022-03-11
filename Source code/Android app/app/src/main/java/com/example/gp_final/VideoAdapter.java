package com.example.gp_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.viewHolder>
        {

        Context context;
        ArrayList<VideoModel > videoArrayList;
public OnItemClickListener onItemClickListener;

public VideoAdapter (Context context, ArrayList<VideoModel > videoArrayList) {
        this.context = context;
        this.videoArrayList = videoArrayList;
        }

@Override
public VideoAdapter .viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_video, viewGroup, false);
        return new viewHolder(view);
        }

@Override
public void onBindViewHolder(final VideoAdapter .viewHolder holder, final int i) {
        holder.title.setText(videoArrayList.get(i).getVideoTitle());
        holder.duration.setText(videoArrayList.get(i).getVideoDuration());
        holder.radioButton.setChecked(videoArrayList.get(i).isChoose());
        }

@Override
public int getItemCount() {
        return videoArrayList.size();
        }

public class viewHolder extends RecyclerView.ViewHolder {
    TextView title, duration;
    RadioButton radioButton;
    ConstraintLayout constraintLayout;
    public viewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        duration = (TextView) itemView.findViewById(R.id.duration);
        radioButton=itemView.findViewById(R.id.radioButton);
        constraintLayout=itemView.findViewById(R.id.container_item);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(getAdapterPosition(), v);
            }
        });
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoArrayList.get(getAdapterPosition()).isChoose()==false )
                {
                    videoArrayList.get(getAdapterPosition()).choose=true;
                    radioButton.setChecked(true);

                }
                else
                    {
                        videoArrayList.get(getAdapterPosition()).choose=false;
                        radioButton.setChecked(false);
                    }
                notifyItemChanged(getAdapterPosition());
            }
        });
    }

}
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
public interface OnItemClickListener {
    void onItemClick(int pos, View v);
}
}