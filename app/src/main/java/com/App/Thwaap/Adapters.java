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
            Intent intent = new Intent(context, Maintitle1.class);
            intent.putExtra("title", item.getTexttt());
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
