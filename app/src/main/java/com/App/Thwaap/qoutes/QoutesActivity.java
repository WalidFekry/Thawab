package com.App.Thwaap.qoutes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Thwaap.R;
import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityQoutesBinding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;
import com.App.Thwaap.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class QoutesActivity extends BaseActivity implements Adaptersada.OnMessengerClick {
    private static final String TAG = "QoutesActivity";
    private static final String API_URL = "https://post.walid-fekry.com/auto_notification/auto_notification_apps/api_post_apps.php";

    private ActivityQoutesBinding binding;
    private List<new_item_post> list2;

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQoutesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        if (binding.backButton != null) {
            binding.backButton.setOnClickListener(v -> finish());
        }

        if (binding.adsContainer != null) {
            binding.adsContainer.setVisibility(View.VISIBLE);
        }

        AdManager.getInstance().loadBanner(binding.rsttfal);
        AdManager.getInstance().loadInterstitial(this, getString(R.string.Biny1));
        getHandler().postDelayed(() -> AdManager.getInstance().showInterstitial(this), 4000);

        if (!NetworkUtils.isConnected(this)) {
            Toast.makeText(this, "لمزيد من الرسائل المتجدده يوميا تاكد انك متصل بالانترنت", Toast.LENGTH_LONG).show();
        }

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.rec2.setLayoutManager(mLayoutManager);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_anmation);
        binding.rec2.setLayoutAnimation(animation);

        fetchQuotesData();
    }

    private void fetchQuotesData() {
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "Error fetching data: " + e.getMessage());
                runOnUiThread(() -> {
                    if (isFinishing() || isDestroyed()) return;
                    onDataFetched(false);
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                boolean success = false;
                List<new_item_post> fetchedList = null;
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful() && responseBody != null) {
                        String result = responseBody.string();
                        fetchedList = parseResult(result);
                        success = !fetchedList.isEmpty();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error processing response: " + e.getMessage());
                }

                final boolean isSuccess = success;
                final List<new_item_post> finalPosts = fetchedList;
                runOnUiThread(() -> {
                    if (isFinishing() || isDestroyed()) return;
                    if (isSuccess) {
                        list2 = finalPosts;
                    }
                    onDataFetched(isSuccess);
                });
            }
        });
    }

    private List<new_item_post> parseResult(String result) {
        List<new_item_post> parsedList = new ArrayList<>();
        try {
            JSONObject response = new JSONObject(result);
            JSONArray post = response.optJSONArray("post");
            if (post != null) {
                for (int i = 0; i < post.length(); i++) {
                    JSONObject posts = post.optJSONObject(i);
                    if (posts != null) {
                        String title = posts.optString("title");
                        String imageurl = posts.optString("imageurl");
                        int id = posts.optInt("id");
                        String createdAt = posts.optString("created_at");
                        parsedList.add(new new_item_post(title, imageurl, id, createdAt));
                    }
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSON parsing error: " + e.getMessage());
        }
        return parsedList;
    }

    private void onDataFetched(boolean success) {
        if (success && list2 != null && !list2.isEmpty()) {
            Adaptersada adaptersada = new Adaptersada(list2, this);
            binding.rec2.setAdapter(adaptersada);
        } else {
            loadStaticFallbackQuotes();
        }
    }

    private void loadStaticFallbackQuotes() {
        list2 = new ArrayList<>();
        list2.add(new new_item_post(getString(R.string.my42)));
        list2.add(new new_item_post(getString(R.string.my1)));
        list2.add(new new_item_post(getString(R.string.my2)));
        list2.add(new new_item_post(getString(R.string.my3)));
        list2.add(new new_item_post(getString(R.string.my4)));
        list2.add(new new_item_post(getString(R.string.my5)));
        list2.add(new new_item_post(getString(R.string.my6)));
        list2.add(new new_item_post(getString(R.string.my7)));
        list2.add(new new_item_post(getString(R.string.my8)));
        list2.add(new new_item_post(getString(R.string.my9)));
        list2.add(new new_item_post(getString(R.string.my10)));
        list2.add(new new_item_post(getString(R.string.my11)));
        list2.add(new new_item_post(getString(R.string.my12)));
        list2.add(new new_item_post(getString(R.string.my13)));
        list2.add(new new_item_post(getString(R.string.my14)));
        list2.add(new new_item_post(getString(R.string.my15)));
        list2.add(new new_item_post(getString(R.string.my16)));
        list2.add(new new_item_post(getString(R.string.my17)));
        list2.add(new new_item_post(getString(R.string.my18)));
        list2.add(new new_item_post(getString(R.string.my19)));
        list2.add(new new_item_post(getString(R.string.my21)));
        list2.add(new new_item_post(getString(R.string.my22)));
        list2.add(new new_item_post(getString(R.string.my23)));
        list2.add(new new_item_post(getString(R.string.my26)));
        list2.add(new new_item_post(getString(R.string.my27)));
        list2.add(new new_item_post(getString(R.string.my28)));
        list2.add(new new_item_post(getString(R.string.my29)));
        list2.add(new new_item_post(getString(R.string.my30)));
        list2.add(new new_item_post(getString(R.string.my31)));
        list2.add(new new_item_post(getString(R.string.my32)));
        list2.add(new new_item_post(getString(R.string.my33)));
        list2.add(new new_item_post(getString(R.string.my34)));
        list2.add(new new_item_post(getString(R.string.my35)));
        list2.add(new new_item_post(getString(R.string.my36)));
        list2.add(new new_item_post(getString(R.string.my37)));
        list2.add(new new_item_post(getString(R.string.my38)));
        list2.add(new new_item_post(getString(R.string.my39)));
        list2.add(new new_item_post(getString(R.string.my40)));
        list2.add(new new_item_post(getString(R.string.my41)));
        list2.add(new new_item_post(getString(R.string.staticvalue)));

        Adaptersada adapter2 = new Adaptersada(list2, this);
        binding.rec2.setAdapter(adapter2);
    }

    @Override
    public void onMessengerItemClick(new_item_post item) {
    }

    @Override
    protected void onDestroy() {
        okHttpClient.dispatcher().cancelAll();
        super.onDestroy();
    }
}
