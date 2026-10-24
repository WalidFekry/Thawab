package com.App.Thwaap.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.App.Thwaap.R;
import com.App.Thwaap.databinding.ItemDuaCardBinding;
import com.App.Thwaap.models.DuaItem;
import com.App.Thwaap.utils.CommonUtils;
import com.App.Thwaap.utils.FavoritesManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuaAdapter extends RecyclerView.Adapter<DuaAdapter.DuaViewHolder> {

    private final Context context;
    private final List<DuaItem> items;
    private final Map<String, Integer> counterStateMap = new HashMap<>();
    private static Typeface cachedTypeface;

    public DuaAdapter(Context context, List<DuaItem> items) {
        this.context = context;
        this.items = items;
        if (cachedTypeface == null && context != null) {
            try {
                cachedTypeface = Typeface.createFromAsset(context.getAssets(), "uthmanii.otf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    @Override
    public DuaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDuaCardBinding binding = ItemDuaCardBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new DuaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DuaViewHolder holder, int position) {
        DuaItem item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public class DuaViewHolder extends RecyclerView.ViewHolder {
        private final ItemDuaCardBinding binding;

        public DuaViewHolder(@NonNull ItemDuaCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(DuaItem item) {
            binding.tvDuaTitle.setText(item.getTitle());
            binding.tvDuaContent.setText(item.getContent());

            if (cachedTypeface != null) {
                binding.tvDuaContent.setTypeface(cachedTypeface);
            }

            if (item.getCategory() != null && !item.getCategory().isEmpty()) {
                binding.tvCategoryBadge.setText(item.getCategory());
                binding.tvCategoryBadge.setVisibility(View.VISIBLE);
            } else {
                binding.tvCategoryBadge.setVisibility(View.GONE);
            }

            if (item.getSource() != null && !item.getSource().isEmpty()) {
                binding.tvDuaSource.setText(item.getSource());
                binding.tvDuaSource.setVisibility(View.VISIBLE);
            } else {
                binding.tvDuaSource.setVisibility(View.GONE);
            }

            if (item.getBenefit() != null && !item.getBenefit().isEmpty()) {
                binding.tvDuaBenefit.setText(item.getBenefit());
                binding.tvDuaBenefit.setVisibility(View.VISIBLE);
            } else {
                binding.tvDuaBenefit.setVisibility(View.GONE);
            }

            // Counter Setup
            int totalRepeat = item.getRepeatCount();
            if (totalRepeat > 1) {
                binding.btnCounter.setVisibility(View.VISIBLE);
                Integer currentRemaining = counterStateMap.get(item.getId());
                if (currentRemaining == null) {
                    currentRemaining = totalRepeat;
                    counterStateMap.put(item.getId(), currentRemaining);
                }
                updateCounterButton(currentRemaining);

                binding.btnCounter.setOnClickListener(v -> {
                    int rem = counterStateMap.get(item.getId());
                    if (rem > 0) {
                        rem--;
                        counterStateMap.put(item.getId(), rem);
                        updateCounterButton(rem);
                        if (rem == 0) {
                            Toast.makeText(context, "تقبل الله منكم الصالحات", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Reset
                        counterStateMap.put(item.getId(), totalRepeat);
                        updateCounterButton(totalRepeat);
                    }
                });
            } else {
                binding.btnCounter.setVisibility(View.GONE);
            }

            // Favorite State
            updateFavoriteIcon(item.getId());

            binding.btnFavorite.setOnClickListener(v -> {
                boolean added = FavoritesManager.toggleFavorite(context, item);
                updateFavoriteIcon(item.getId());
                Toast.makeText(context, added ? "تمت الإضافة إلى المفضلة" : "تمت الإزالة من المفضلة", Toast.LENGTH_SHORT).show();
            });

            // Copy Action
            binding.btnCopy.setOnClickListener(v -> {
                String copyText = item.getTitle() + "\n" + item.getContent();
                if (item.getSource() != null && !item.getSource().isEmpty()) {
                    copyText += "\nالمصدر: " + item.getSource();
                }
                copyText += "\n\nتم النسخ من تطبيق ثواب";
                CommonUtils.copyToClipboard(context, item.getTitle(), copyText, "تم نسخ النص إلى الحافظة");
            });

            // Share Action
            binding.btnShare.setOnClickListener(v -> {
                String shareText = item.getTitle() + "\n\n" + item.getContent();
                if (item.getSource() != null && !item.getSource().isEmpty()) {
                    shareText += "\n\nالمصدر: " + item.getSource();
                }
                shareText += "\n\nتطبيق ثواب - حصن المسلم\nhttps://play.google.com/store/apps/details?id=" + context.getPackageName();
                CommonUtils.shareText(context, item.getTitle(), shareText, "مشاركة الدعاء عبر:");
            });
        }

        private void updateCounterButton(int remaining) {
            if (remaining > 0) {
                binding.btnCounter.setText("المتبقي: " + remaining);
            } else {
                binding.btnCounter.setText("تم القرائة ✓ (إعادة)");
            }
        }

        private void updateFavoriteIcon(String itemId) {
            boolean isFav = FavoritesManager.isFavorite(context, itemId);
            binding.btnFavorite.setImageResource(isFav ? R.drawable.ic_favorite_filled : R.drawable.ic_favorite_outline);
        }
    }
}
