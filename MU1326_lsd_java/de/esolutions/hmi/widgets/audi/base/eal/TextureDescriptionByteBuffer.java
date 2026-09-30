/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;
import java.nio.ByteBuffer;

public class TextureDescriptionByteBuffer
extends AbstractTextureDescription {
    private ByteBuffer buffer;
    private final int width;
    private final int height;
    private final int format;
    private final FlagImage flagImage;
    private Object key;

    public TextureDescriptionByteBuffer(EALManager eALManager, ByteBuffer byteBuffer, int n, int n2, int n3, ITextureCache iTextureCache) {
        super(eALManager, iTextureCache);
        this.buffer = byteBuffer;
        this.width = n2;
        this.height = n3;
        this.format = n;
        this.flagImage = EALManager.getImageFlags(n);
        this.key = this;
    }

    public TextureDescriptionByteBuffer(EALManager eALManager, ByteBuffer byteBuffer, int n, int n2, int n3, ITextureCache iTextureCache, Object object) {
        this(eALManager, byteBuffer, n, n2, n3, iTextureCache);
        this.key = object;
    }

    public IWrappedTexture createTexture() {
        if (this.buffer == null) {
            logChannel3DEngine.log(10000, "TextureDescriptionByteBuffer#createTexture a texture can only be created one time from a buffer");
            return null;
        }
        IImage iImage = this.ealManager.createEALImage(this.buffer, this.format, this.width, this.height);
        if (iImage == null) {
            return null;
        }
        FlagTexture flagTexture = EALManager.getTextureFlags(this.format, false);
        ITexture iTexture = this.ealManager.createTexture(iImage, flagTexture);
        this.ealManager.destroy(iImage);
        if (iTexture == null) {
            return null;
        }
        this.buffer = null;
        return new WrappedTexture(iTexture, this, this.ealManager);
    }

    public int[] getUnscaledDimension() {
        return new int[]{this.width, this.height};
    }

    public Object getCacheKey() {
        return this.key;
    }

    public FlagImage getImageFlags() {
        return this.flagImage;
    }
}

