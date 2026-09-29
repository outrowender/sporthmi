/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

public interface IMediaBrowserSearchListener {
    default public void responseSelectSearchResult(long l, long l2, boolean bl) {
    }

    default public void responseSetSearchCriteria(int n, boolean bl) {
    }

    default public void responseSetSearchString(String string, boolean bl) {
    }

    default public void updateSearchSize(int n, int n2, int n3, int n4) {
    }

    default public void updateSearchSpellerState(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }
}

