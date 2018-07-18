package com.satishdasyam.mvvm.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;

public final class CommonBindingUtils {

    private CommonBindingUtils() {

    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        GlideApp.with(imageView.getContext()).applyDefaultRequestOptions(new RequestOptions()
                .fallback(android.R.drawable.stat_notify_error)
                .error(android.R.drawable.stat_notify_error)).load(url).into(imageView);
    }
}
