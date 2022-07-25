package com.gif.gifroject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Gif {
    @JsonProperty
    private String url;
    @JsonProperty
    private List<String> tags;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
