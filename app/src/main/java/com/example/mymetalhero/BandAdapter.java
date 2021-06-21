package com.example.mymetalhero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BandAdapter extends RecyclerView.Adapter<BandAdapter.ViewHolder> {

    private ArrayList<BandData> bandData;
    private OnItemClickCallback onItemClickCallback;

    // Initialize the dataset of the Adapter.
    public BandAdapter(ArrayList<BandData> bandData) {
        this.bandData = bandData;
    }

    // Create new views for every items(invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        // Create a new view.
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.band_list, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextViewBandName().setText(bandData.get(position).getBand());
        viewHolder.getTextViewBandInfo().setText(bandData.get(position).getAbout());
        viewHolder.getImageViewBandImage().setImageResource(bandData.get(position).getImage());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                onItemClickCallback.onItemClicked(bandData.get(
                        viewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {

        return bandData.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(BandData data);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewBandName, textViewBandInfo;
        private CircleImageView imageViewBandImage;

        public ViewHolder(@NonNull View view) {
            super(view);

            // Set click listener for ViewHolder's View
//            view.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//
//                }
//            });

            textViewBandName = (TextView) view.findViewById(R.id.band_name);
            textViewBandInfo = (TextView) view.findViewById(R.id.band_info);
            imageViewBandImage = (CircleImageView) view.findViewById(R.id.band_image);
        }

        public TextView getTextViewBandName() {

            return textViewBandName;
        }

        public TextView getTextViewBandInfo() {

            return textViewBandInfo;
        }

        public ImageView getImageViewBandImage() {

            return imageViewBandImage;
        }
    }
}
