package com.primeclass.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderImageAdapter extends SliderViewAdapter<SliderImageAdapter.Holder>{
    int[] splash_images;

    public SliderImageAdapter(int[] splash_images) {
        this.splash_images = splash_images;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_image,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.image.setImageResource(splash_images[position]);
    }

    @Override
    public int getCount() {
        return splash_images.length;
    }

    public class Holder extends ViewHolder{
        ImageView image;
        public Holder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.sliderImage);
        }
    }
}
