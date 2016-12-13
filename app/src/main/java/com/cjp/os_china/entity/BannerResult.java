package com.cjp.os_china.entity;

import java.util.List;

/**
 * Created by panj on 2016/12/12.
 */

public class BannerResult {
    private List<Banner> items;
    private String nextPageToken;
    private String prevPageToken;
    private int requestCount;
    private int responseCount;
    private int totalResults;

    public List<Banner> getItems() {
        return items;
    }

    public void setItems(List<Banner> items) {
        this.items = items;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getPrevPageToken() {
        return prevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        this.prevPageToken = prevPageToken;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public int getResponseCount() {
        return responseCount;
    }

    public void setResponseCount(int responseCount) {
        this.responseCount = responseCount;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
