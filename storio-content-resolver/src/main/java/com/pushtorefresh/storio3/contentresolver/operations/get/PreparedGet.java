package com.pushtorefresh.storio3.contentresolver.operations.get;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio3.contentresolver.StorIOContentResolver;
import com.pushtorefresh.storio3.contentresolver.queries.Query;
import com.pushtorefresh.storio3.operations.PreparedOperation;

/**
 * Represents Get Operation for {@link StorIOContentResolver}.
 *
 * @param <Result> type of result.
 */
public abstract class PreparedGet<Result, WrappedResult> implements PreparedOperation<Result, WrappedResult, Query> {

    @NonNull
    protected final StorIOContentResolver storIOContentResolver;

    @NonNull
    protected final Query query;

    PreparedGet(@NonNull StorIOContentResolver storIOContentResolver, @NonNull Query query) {
        this.storIOContentResolver = storIOContentResolver;
        this.query = query;
    }

    @NonNull
    @Override
    public Query getData() {
        return query;
    }

    /**
     * Builder for {@link PreparedGet}.
     */
    public final static class Builder {

        @NonNull
        private final StorIOContentResolver storIOContentResolver;

        public Builder(@NonNull StorIOContentResolver storIOContentResolver) {
            this.storIOContentResolver = storIOContentResolver;
        }

        /**
         * Returns builder for Get Operation that returns result as {@link android.database.Cursor}.
         *
         * @return builder for Get Operation that returns result as {@link android.database.Cursor}.
         */
        @NonNull
        public PreparedGetCursor.Builder cursor() {
            return new PreparedGetCursor.Builder(storIOContentResolver);
        }

        /**
         * Returns builder for Get Operation that returns result as {@link java.util.List} of items.
         *
         * @param type type of items.
         * @param <T>  type of items.
         * @return builder for Get Operation that returns result as {@link java.util.List} of items.
         */
        @NonNull
        public <T> PreparedGetListOfObjects.Builder<T> listOfObjects(@NonNull Class<T> type) {
            return new PreparedGetListOfObjects.Builder<T>(storIOContentResolver, type);
        }

        /**
         * Returns builder for Get Operation that returns result as item instance.
         *
         * @param type type of item.
         * @param <T>  type of item.
         * @return builder for Get Operation that returns result as item instance.
         */
        @NonNull
        public <T> PreparedGetObject.Builder<T> object(@NonNull Class<T> type) {
            return new PreparedGetObject.Builder<T>(storIOContentResolver, type);
        }

        /**
        * Returns builder for Get Operation that returns number of results.
        *
        * @return builder for Get Operation that returns number of results.
        */
        @NonNull
        public PreparedGetNumberOfResults.Builder numberOfResults() {
            return new PreparedGetNumberOfResults.Builder(storIOContentResolver);
        }
    }
}
