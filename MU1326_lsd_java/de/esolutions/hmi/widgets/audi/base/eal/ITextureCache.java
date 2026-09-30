/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;

public interface ITextureCache {
    public IWrappedTexture getTexture(TextureDescription var1, Object var2);

    public boolean release(IWrappedTexture var1, Object var2);

    public void destroyAll();

    public IWrappedTexture getCachedTexture(TextureDescription var1, Object var2);

    public boolean isTextureCached(TextureDescription var1);

    public void dump();

    public void dump(LogChannel var1);

    public int getCacheId();

    public TextureDescription getTextureDescriptionByKey(Object var1);
}

