package com.App.Thwaap.qoutes;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.Thwaap.R;
import com.App.Thwaap.databinding.ItemReslatfoalBinding;
import com.App.Thwaap.utils.CommonUtils;

import java.util.List;
import java.util.Random;

public class Adaptersada extends RecyclerView.Adapter<Adaptersada.Holder2> {
    private final List<new_item_post> list2;
    private final Context context;

    public Adaptersada(List<new_item_post> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    public List<new_item_post> getItems() {
        return list2;
    }

    @NonNull
    @Override
    public Holder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ItemReslatfoalBinding binding = ItemReslatfoalBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new Holder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder2 holder, final int position) {
        new_item_post item = list2.get(position);

        holder.binding.title.setText(item.getTitle() != null ? item.getTitle().replace("_", "\n") : "");
        holder.binding.messageNumber.setText(String.valueOf(item.getId()));

        if (item.getCreatedAt() != null) {
            holder.binding.messageTime.setText(item.getCreatedAt().split(" ")[0]);
        } else {
            holder.binding.messageTime.setText("2021-01-05");
        }

        holder.binding.sharequran.setOnClickListener(v -> {
            String shareText = item.getTitle() + "\nتم النسخ من تطبيق ثواب 💙 👇 https://play.google.com/store/apps/details?id=com.App.Thwaap \n";
            CommonUtils.shareText(context, " تطبيق  (Thawap) ", shareText, "مشاركه نصوص من  تطبيق ثواب :");
        });

        holder.binding.starquran.setOnClickListener(v -> CommonUtils.openPlayStore(context));

        holder.binding.qumsgwhats.setOnClickListener(v -> {
            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.setPackage("com.whatsapp");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, holder.binding.title.getText().toString());
            try {
                context.startActivity(whatsappIntent);
            } catch (ActivityNotFoundException ex) {
                CommonUtils.openUrl(context, "https://play.google.com/store/apps/details?id=com.whatsapp");
            }
        });

        holder.binding.copyquran.setOnClickListener(v -> {
            String copyText = item.getTitle() + "\n\nتم نسخ هذا النص من تطبيق ثواب ^_^";
            CommonUtils.copyToClipboard(context, "", copyText, "تم نسخ النص - قم بمشاركتة الآن مع أصدقائك");
        });

        holder.binding.getRoot().setOnClickListener(v -> {
            try {
                MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.clikkk);
                if (mediaPlayer != null) {
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release);
                    mediaPlayer.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Resources res = context.getResources();
            TypedArray myImages = res.obtainTypedArray(R.array.image);
            Random random = new Random();
            int randomInt = random.nextInt(myImages.length());
            int drawableID = myImages.getResourceId(randomInt, -1);
            myImages.recycle();

            holder.binding.baccc.setBackgroundResource(drawableID);
            holder.binding.title.setTextColor(Color.WHITE);
        });
    }

    @Override
    public int getItemCount() {
        return list2 != null ? list2.size() : 0;
    }

    public interface OnMessengerClick {
        void onMessengerItemClick(new_item_post item);
    }

    public static class Holder2 extends RecyclerView.ViewHolder {
        final ItemReslatfoalBinding binding;

        public Holder2(@NonNull ItemReslatfoalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
