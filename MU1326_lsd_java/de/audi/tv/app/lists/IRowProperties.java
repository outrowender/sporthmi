/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

public interface IRowProperties {
    public void setElementIsFavorite(boolean var1);

    public void setDatabroadcastIsAvailable(boolean var1);

    public void setDatabroadcastIsLoading(boolean var1);

    public void setDatabroadcastIsCheckingOrUnavailable(boolean var1);

    public void setVisualAudioIsAvailable(boolean var1);

    public void setVisualAudioIsLoading(boolean var1);

    public void setVisualAudioIsUnavailable(boolean var1);

    public void setTeletextIsAvailable(boolean var1);

    public void setTeletextIsLoading(boolean var1);

    public void setTeletextIsUnavailable(boolean var1);

    public int[] toArray();

    public int getCategory();
}

