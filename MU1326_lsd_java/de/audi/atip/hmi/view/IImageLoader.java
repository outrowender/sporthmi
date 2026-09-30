/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.model.HMIResourceLocator;

public interface IImageLoader {
    public void clearImageCache();

    public Object getImageFromCache(int var1, int var2, int var3);

    public Object loadImageAbsolutePath(int var1, String var2, boolean var3, boolean var4, int var5, int var6, int var7);

    public Object loadImage(int var1, String var2, boolean var3, boolean var4, int var5, int var6, int var7);

    public Object loadImage(HMIResourceLocator var1, boolean var2, int var3, int var4);

    public Object getErrorImage();

    public Object getEmptyImage();

    public int getRealImageSize(int var1, int var2, int var3);

    public void destroyImage(Object var1);
}

