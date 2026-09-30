/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

public interface IMediaBrowserSearchListener {
    public void responseSelectSearchResult(long var1, long var3, boolean var5);

    public void responseSetSearchCriteria(int var1, boolean var2);

    public void responseSetSearchString(String var1, boolean var2);

    public void updateSearchSize(int var1, int var2, int var3, int var4);

    public void updateSearchSpellerState(int var1);

    public void asyncException(int var1, String var2, int var3);
}

