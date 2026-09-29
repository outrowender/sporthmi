/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.model.HMIResourceLocator;

public interface IImageLoader {
    default public void clearImageCache() {
    }

    default public Object getImageFromCache(int n, int n2, int n3) {
    }

    default public Object loadImageAbsolutePath(int n, String string, boolean bl, boolean bl2, int n2, int n3, int n4) {
    }

    default public Object loadImage(int n, String string, boolean bl, boolean bl2, int n2, int n3, int n4) {
    }

    default public Object loadImage(HMIResourceLocator hMIResourceLocator, boolean bl, int n, int n2) {
    }

    default public Object getErrorImage() {
    }

    default public Object getEmptyImage() {
    }

    default public int getRealImageSize(int n, int n2, int n3) {
    }

    default public void destroyImage(Object object) {
    }
}

