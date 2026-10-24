package com.App.Thwaap.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.App.Thwaap.models.DuaItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FavoritesManager {
    private static final String PREF_FAVORITES = "thawab_favorites_pref";
    private static final String KEY_FAVORITES_LIST = "favorites_list";

    private static SharedPreferences getPrefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREF_FAVORITES, Context.MODE_PRIVATE);
    }

    public static synchronized boolean isFavorite(Context context, String id) {
        if (id == null) return false;
        List<DuaItem> list = getFavorites(context);
        for (DuaItem item : list) {
            if (id.equals(item.getId())) {
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean toggleFavorite(Context context, DuaItem item) {
        if (item == null || item.getId() == null) return false;
        List<DuaItem> list = getFavorites(context);
        boolean exists = false;
        int removeIndex = -1;

        for (int i = 0; i < list.size(); i++) {
            if (item.getId().equals(list.get(i).getId())) {
                exists = true;
                removeIndex = i;
                break;
            }
        }

        if (exists) {
            list.remove(removeIndex);
        } else {
            list.add(0, item);
        }

        saveFavorites(context, list);
        return !exists;
    }

    public static synchronized List<DuaItem> getFavorites(Context context) {
        List<DuaItem> items = new ArrayList<>();
        String jsonString = getPrefs(context).getString(KEY_FAVORITES_LIST, "[]");
        try {
            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                DuaItem item = new DuaItem(
                        obj.optString("id"),
                        obj.optString("title"),
                        obj.optString("content"),
                        obj.optString("source"),
                        obj.optString("category"),
                        obj.optInt("repeatCount", 1),
                        obj.optString("benefit")
                );
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    private static void saveFavorites(Context context, List<DuaItem> list) {
        try {
            JSONArray array = new JSONArray();
            for (DuaItem item : list) {
                JSONObject obj = new JSONObject();
                obj.put("id", item.getId());
                obj.put("title", item.getTitle() != null ? item.getTitle() : "");
                obj.put("content", item.getContent() != null ? item.getContent() : "");
                obj.put("source", item.getSource() != null ? item.getSource() : "");
                obj.put("category", item.getCategory() != null ? item.getCategory() : "");
                obj.put("repeatCount", item.getRepeatCount());
                obj.put("benefit", item.getBenefit() != null ? item.getBenefit() : "");
                array.put(obj);
            }
            getPrefs(context).edit().putString(KEY_FAVORITES_LIST, array.toString()).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
