/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;

public interface TextureDescription {
    default public ITextureCache getCache() {
    }

    default public IWrappedTexture createTexture() {
    }

    default public IWrappedTexture getTexture(Object object) {
    }

    default public IWrappedTexture getCachedTexture(Object object) {
    }

    default public boolean isTextureCached() {
    }

    default public Object getCacheKey() {
    }

    default public FlagImage getImageFlags() {
    }

    default public boolean preventRTLFlip() {
    }

    default public int getDepthsInByte() {
    }

    default public int[] getUnscaledDimension() {
    }
}

