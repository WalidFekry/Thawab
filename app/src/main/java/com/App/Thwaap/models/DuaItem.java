package com.App.Thwaap.models;

import java.io.Serializable;
import java.util.Objects;

public class DuaItem implements Serializable {
    private String id;
    private String title;
    private String content;
    private String source;
    private String category;
    private int repeatCount;
    private String benefit;

    public DuaItem() {
    }

    public DuaItem(String id, String title, String content, String source, String category, int repeatCount, String benefit) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.source = source;
        this.category = category;
        this.repeatCount = repeatCount;
        this.benefit = benefit;
    }

    public DuaItem(String id, String title, String content, String source, String category) {
        this(id, title, content, source, category, 1, "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DuaItem duaItem = (DuaItem) o;
        return Objects.equals(id, duaItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
