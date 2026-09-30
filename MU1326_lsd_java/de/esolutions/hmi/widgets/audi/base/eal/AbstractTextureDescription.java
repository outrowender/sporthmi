/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;

public abstract class AbstractTextureDescription
implements TextureDescription,
IWidgetLogChannel {
    protected final EALManager ealManager;
    private final ITextureCache cache;
    protected int[] imgDimensions;
    protected float scaling = 1.0f;

    protected AbstractTextureDescription(EALManager eALManager, ITextureCache iTextureCache) {
        this.ealManager = eALManager;
        this.cache = iTextureCache;
    }

    public ITextureCache getCache() {
        return this.cache;
    }

    public IWrappedTexture getTexture(Object object) {
        return this.ealManager.getTexture(this, object);
    }

    public IWrappedTexture getCachedTexture(Object object) {
        ITextureCache iTextureCache = this.getCache();
        if (iTextureCache == null) {
            return null;
        }
        return iTextureCache.getCachedTexture(this, object);
    }

    public boolean isTextureCached() {
        ITextureCache iTextureCache = this.getCache();
        if (iTextureCache == null) {
            return false;
        }
        return iTextureCache.isTextureCached(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractTextureDescription)) {
            return false;
        }
        AbstractTextureDescription abstractTextureDescription = (AbstractTextureDescription)object;
        if (this.getClass() != abstractTextureDescription.getClass()) {
            return false;
        }
        Object object2 = this.getCacheKey();
        Object object3 = abstractTextureDescription.getCacheKey();
        if (object2 == this || object3 == abstractTextureDescription) {
            return this == abstractTextureDescription;
        }
        return Util.equals(this.getCacheKey(), abstractTextureDescription.getCacheKey());
    }

    public int hashCode() {
        Object object = this.getCacheKey();
        if (object == null || object == this) {
            return super.hashCode();
        }
        return object.hashCode();
    }

    public boolean preventRTLFlip() {
        return true;
    }

    public int getDepthsInByte() {
        return 4;
    }

    protected int[] getUnscaledDimension(String string) {
        if (this.imgDimensions == null) {
            this.imgDimensions = this.ealManager.getImageHeaderInformation(string);
        }
        return this.imgDimensions;
    }

    protected boolean checkSize(String string, boolean bl) {
        if (bl) {
            int[] nArray = this.getUnscaledDimension(string);
            if (nArray[0] > 0 && nArray[1] > 0) {
                float f2 = (float)this.ealManager.getScreenWidth() / (float)nArray[0];
                float f3 = (float)this.ealManager.getScreenHeight() / (float)nArray[1];
                this.scaling = Math.min(f2, f3);
                if (this.scaling > 1.0f) {
                    this.scaling = 1.0f;
                }
            } else {
                logChannel3DEngine.log(10000, "AbstractTextureDescription#checkSize(String,bool) incorrect scaling for image %1", (Object)this);
                return true;
            }
        }
        return Float.isNaN(this.scaling);
    }

    public float getScaleFactor() {
        return this.scaling;
    }
}

