/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;

public interface TextureDescription {
    public ITextureCache getCache();

    public IWrappedTexture createTexture();

    public IWrappedTexture getTexture(Object var1);

    public IWrappedTexture getCachedTexture(Object var1);

    public boolean isTextureCached();

    public Object getCacheKey();

    public FlagImage getImageFlags();

    public boolean preventRTLFlip();

    public int getDepthsInByte();

    public int[] getUnscaledDimension();
}

