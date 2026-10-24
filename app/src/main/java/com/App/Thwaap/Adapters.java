package com.App.Thwaap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.Thwaap.databinding.ItemRecBinding;

import java.util.List;

public class Adapters extends RecyclerView.Adapter<Adapters.Holder> {
    private final Context context;
    private final List<rec_item> itemList;
    private static Typeface cachedTypeface;

    public Adapters(Context context, List<rec_item> itemList) {
        this.context = context;
        this.itemList = itemList;
        if (cachedTypeface == null && context != null) {
            try {
                cachedTypeface = Typeface.createFromAsset(context.getAssets(), "2.otf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecBinding binding = ItemRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        rec_item item = itemList.get(position);
        holder.binding.texttt.setText(item.getTexttt());
        if (cachedTypeface != null) {
            holder.binding.texttt.setTypeface(cachedTypeface);
        }

        holder.binding.cards.setOnClickListener(v -> {
            String title = item.getTexttt();
            Intent intent;
            if ("أدعية من القرآن الكريم".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_QURAN);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else if ("أدعية من السنة النبوية".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_SUNNAH);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else if ("أذكار بعد الصلاة".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_POST_PRAYER);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else if ("أدعية وأذكار يوم الجمعة".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_FRIDAY);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else if ("الاستغفار والتوبة".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_ISTIGHFAR);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else if ("الصلاة على النبي ﷺ".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_SALAWAT);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else if ("أذكار الكرب والهم والحزن".equals(title)) {
                intent = new Intent(context, CategoryDetailActivity.class);
                intent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY_TYPE, CategoryDetailActivity.TYPE_DISTRESS);
                intent.putExtra(CategoryDetailActivity.EXTRA_TITLE, title);
            } else {
                intent = new Intent(context, Maintitle1.class);
                intent.putExtra("title", title);
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        final ItemRecBinding binding;

        public Holder(@NonNull ItemRecBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
