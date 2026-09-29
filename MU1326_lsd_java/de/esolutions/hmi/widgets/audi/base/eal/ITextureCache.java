/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;

public interface ITextureCache {
    default public IWrappedTexture getTexture(TextureDescription textureDescription, Object object) {
    }

    default public boolean release(IWrappedTexture iWrappedTexture, Object object) {
    }

    default public void destroyAll() {
    }

    default public IWrappedTexture getCachedTexture(TextureDescription textureDescription, Object object) {
    }

    default public boolean isTextureCached(TextureDescription textureDescription) {
    }

    default public void dump() {
    }

    default public void dump(LogChannel logChannel) {
    }

    default public int getCacheId() {
    }

    default public TextureDescription getTextureDescriptionByKey(Object object) {
    }
}

