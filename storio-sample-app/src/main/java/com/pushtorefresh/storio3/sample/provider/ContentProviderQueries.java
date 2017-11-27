package com.pushtorefresh.storio3.sample.provider;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio3.contentresolver.queries.Query;

import static com.pushtorefresh.storio3.sample.provider.meta.TweetMeta.CONTENT_URI;

public final class ContentProviderQueries {

    @NonNull
    public static final Query QUERY_ALL =
            Query.builder()
                    .uri(CONTENT_URI)
                    .build();
}
