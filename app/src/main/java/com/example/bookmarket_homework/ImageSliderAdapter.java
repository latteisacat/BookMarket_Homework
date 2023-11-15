package com.example.bookmarket_homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


// https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=ko
// RecyclerView 에 대한 설명.
// 요약하면 화면 밖으로 벗어난 뷰를 제거하지 않고 재사용 하는 클래스이다.
public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.MyViewHolder> {
    private Context context;
    private int[] sliderImage;

    // 여기서 MainActivity의 Context와 이미지의 id를 받아온다.
    public ImageSliderAdapter(Context context, int[] sliderImage) {
        this.context = context;
        this.sliderImage = sliderImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_slider, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindSliderImage(sliderImage[position]);
    }

    @Override
    public int getItemCount() {
        return sliderImage.length;
    }

    // RecyclerView의 ViewHolder를 상속하여 뷰에 이미지를 어떻게 집어넣을 지 커스터마이징 한다.
    // Glide는 이미지를 빠르게 불러오는 라이브러리로, 빠르게 뷰에 이미지를 집어넣을 수 있도록 도와준다.
    // 굳이 안써도 될 것 같긴 한데 편하니까 쓰자.
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageSlider);
        }

        public void bindSliderImage(int imageURL) {
            Glide.with(context)
                    .load(imageURL)
                    .into(mImageView);
        }
    }
}