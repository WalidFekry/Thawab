package com.App.Thwaap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapters extends RecyclerView.Adapter<Adapters.holder> {
    private final Context context;
    private final List<rec_item> listtt;
    private static Typeface cachedTypeface;

    public Adapters(Context context, List<rec_item> listtt) {
        this.context = context;
        this.listtt = listtt;
        if (cachedTypeface == null && context != null) {
            cachedTypeface = Typeface.createFromAsset(context.getAssets(), "2.otf");
        }
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int holder) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder holder, int position) {
        holder.texttt.setText(listtt.get(position).getTexttt());
        if (cachedTypeface != null) {
            holder.texttt.setTypeface(cachedTypeface);
        }
        final rec_item item = listtt.get(position);

        holder.cards.setOnClickListener(v -> {
            Intent intent = new Intent(context, Maintitle1.class);
            intent.putExtra("title", item.getTexttt());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listtt.size();
    }

    public static class holder extends RecyclerView.ViewHolder {
        private final TextView texttt;
        private final CardView cards;

        public holder(@NonNull View itemView) {
            super(itemView);
            texttt = itemView.findViewById(R.id.texttt);
            cards = itemView.findViewById(R.id.cards);
        }
    }
}
