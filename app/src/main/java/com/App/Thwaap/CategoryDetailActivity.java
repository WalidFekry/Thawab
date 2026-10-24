package com.App.Thwaap;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Thwaap.adapters.DuaAdapter;
import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityCategoryDetailBinding;
import com.App.Thwaap.models.DuaItem;
import com.App.Thwaap.repository.IslamicContentRepository;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;
import com.App.Thwaap.utils.FavoritesManager;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailActivity extends BaseActivity {

    public static final String EXTRA_CATEGORY_TYPE = "extra_category_type";
    public static final String EXTRA_TITLE = "title";

    public static final String TYPE_QURAN = "TYPE_QURAN";
    public static final String TYPE_SUNNAH = "TYPE_SUNNAH";
    public static final String TYPE_POST_PRAYER = "TYPE_POST_PRAYER";
    public static final String TYPE_FRIDAY = "TYPE_FRIDAY";
    public static final String TYPE_ISTIGHFAR = "TYPE_ISTIGHFAR";
    public static final String TYPE_SALAWAT = "TYPE_SALAWAT";
    public static final String TYPE_DISTRESS = "TYPE_DISTRESS";
    public static final String TYPE_FAVORITES = "TYPE_FAVORITES";

    private ActivityCategoryDetailBinding binding;
    private String currentCategoryType;
    private String currentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCategoryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        if (binding.backButton != null) {
            binding.backButton.setOnClickListener(v -> finish());
        }

        currentTitle = getIntent().getStringExtra(EXTRA_TITLE);
        currentCategoryType = getIntent().getStringExtra(EXTRA_CATEGORY_TYPE);

        if (currentTitle != null && binding.toolbarTitle != null) {
            binding.toolbarTitle.setText(currentTitle);
        }

        binding.recDuas.setLayoutManager(new LinearLayoutManager(this));

        displayCategoryContent();

        AdManager.getInstance().loadBanner(binding.adViewCategory);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (TYPE_FAVORITES.equals(currentCategoryType)) {
            displayCategoryContent();
        }
    }

    private void displayCategoryContent() {
        List<DuaItem> items = loadItemsForCategory(currentCategoryType, currentTitle);

        if (items.isEmpty()) {
            binding.tvEmptyState.setVisibility(View.VISIBLE);
            binding.recDuas.setVisibility(View.GONE);
        } else {
            binding.tvEmptyState.setVisibility(View.GONE);
            binding.recDuas.setVisibility(View.VISIBLE);
            DuaAdapter adapter = new DuaAdapter(this, items);
            binding.recDuas.setAdapter(adapter);
        }
    }

    private List<DuaItem> loadItemsForCategory(String categoryType, String title) {
        String safeType = categoryType != null ? categoryType : "";
        switch (safeType) {
            case TYPE_QURAN:
                return IslamicContentRepository.getQuranicDuas();
            case TYPE_SUNNAH:
                return IslamicContentRepository.getSunnahDuas();
            case TYPE_POST_PRAYER:
                return IslamicContentRepository.getPostPrayerAzkar();
            case TYPE_FRIDAY:
                return IslamicContentRepository.getFridayDuas();
            case TYPE_ISTIGHFAR:
                return IslamicContentRepository.getIstighfarAndRepentance();
            case TYPE_SALAWAT:
                return IslamicContentRepository.getSalawat();
            case TYPE_DISTRESS:
                return IslamicContentRepository.getDistressDuas();
            case TYPE_FAVORITES:
                return FavoritesManager.getFavorites(this);
            default:
                if (title != null && !title.isEmpty()) {
                    return IslamicContentRepository.getCategorizedDuasByTopic(title);
                }
                return new ArrayList<>();
        }
    }
}
