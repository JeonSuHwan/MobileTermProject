package com.shinplest.mobiletermproject.record;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shinplest.mobiletermproject.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    private ArrayList<RecordItem> mData = null;

    RecordAdapter(ArrayList<RecordItem> list) {
        mData = list;
    }

    @NonNull
    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.record_item, parent, false);
        RecordAdapter.ViewHolder vh = new RecordAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.ViewHolder holder, int position) {
        RecordItem item = mData.get(position);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        String formattedDate = sdf.format(item.getDate());

        holder.tv_date.setText(formattedDate);
        holder.altitude.setText(item.getMaxAltitude() + "m");
        holder.speed.setText(item.getAvgSpeed() + "m/분");
        holder.distance.setText(item.getTotalDistance() + "km");
        holder.time.setText(item.getTime() + "분");
        switch (position % 5) {
            case 0:
                holder.img.setImageResource(R.drawable.sample1);
                break;
            case 1:
                holder.img.setImageResource(R.drawable.sample2);
                break;
            case 2:
                holder.img.setImageResource(R.drawable.sample3);
                break;
            case 3:
                holder.img.setImageResource(R.drawable.sample4);
                break;
            case 4:
                holder.img.setImageResource(R.drawable.sample5);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date;
        TextView altitude;
        TextView speed;
        TextView distance;
        TextView time;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tv_record_date);
            img = itemView.findViewById(R.id.record_img);
            altitude = itemView.findViewById(R.id.txt_maxAltitude);
            speed = itemView.findViewById(R.id.txt_avgSpeed);
            distance = itemView.findViewById(R.id.txt_totalDistance);
            time = itemView.findViewById(R.id.txt_time);
        }
    }
}