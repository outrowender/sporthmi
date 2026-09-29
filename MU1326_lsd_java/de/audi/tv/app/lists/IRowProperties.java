/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

public interface IRowProperties {
    default public void setElementIsFavorite(boolean bl) {
    }

    default public void setDatabroadcastIsAvailable(boolean bl) {
    }

    default public void setDatabroadcastIsLoading(boolean bl) {
    }

    default public void setDatabroadcastIsCheckingOrUnavailable(boolean bl) {
    }

    default public void setVisualAudioIsAvailable(boolean bl) {
    }

    default public void setVisualAudioIsLoading(boolean bl) {
    }

    default public void setVisualAudioIsUnavailable(boolean bl) {
    }

    default public void setTeletextIsAvailable(boolean bl) {
    }

    default public void setTeletextIsLoading(boolean bl) {
    }

    default public void setTeletextIsUnavailable(boolean bl) {
    }

    default public int[] toArray() {
    }

    default public int getCategory() {
    }
}

