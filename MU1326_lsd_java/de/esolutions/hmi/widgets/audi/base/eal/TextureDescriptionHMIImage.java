/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;

public class TextureDescriptionHMIImage
extends AbstractTextureDescription {
    private final boolean useEalAtlas;
    private final HMIImage image;
    private boolean useSizeCheck = false;

    public TextureDescriptionHMIImage(EALManager eALManager, HMIImage hMIImage, ITextureCache iTextureCache, boolean bl) {
        super(eALManager, iTextureCache);
        this.useEalAtlas = bl;
        this.image = hMIImage;
    }

    public TextureDescriptionHMIImage(EALManager eALManager, HMIImage hMIImage, ITextureCache iTextureCache, boolean bl, boolean bl2) {
        this(eALManager, hMIImage, iTextureCache, bl);
        this.useSizeCheck = bl2;
    }

    public IWrappedTexture createTexture() {
        IImage iImage = null;
        if (this.checkSize(this.image.getPath(), this.useSizeCheck)) {
            return null;
        }
        iImage = this.scaling < 1.0f ? this.ealManager.createEALImage(this.image, Math.round((float)this.imgDimensions[0] * this.scaling), Math.round((float)this.imgDimensions[1] * this.scaling)) : this.ealManager.createEALImage(this.image);
        if (iImage == null) {
            logChannel3DEngine.log(10000, "TextureDescriptionHMIImage#createTexture could not load image for %1", (Object)this);
            return null;
        }
        FlagTexture flagTexture = EALManager.getTextureFlags(this.image.getFormat(), this.useEalAtlas);
        ITexture iTexture = this.ealManager.createTexture(iImage, flagTexture);
        this.ealManager.destroy(iImage);
        if (iTexture == null) {
            logChannel3DEngine.log(10000, "TextureDescriptionHMIImage#createTexture could not create texture for %1", (Object)this);
            return null;
        }
        WrappedTexture wrappedTexture = new WrappedTexture(iTexture, this, this.ealManager);
        return wrappedTexture;
    }

    public String getPath() {
        return this.image.getPath();
    }

    public Object getCacheKey() {
        return this.getPath();
    }

    public int[] getUnscaledDimension() {
        return this.getUnscaledDimension(this.image.getPath());
    }

    public FlagImage getImageFlags() {
        return null;
    }

    public boolean preventRTLFlip() {
        return this.image.getPreventRTLFlipFlag();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TextureDescriptionHMIImage [getCacheKey()=");
        stringBuffer.append(this.getCacheKey());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int getDepthsInByte() {
        return HMIImage.getNumBytesPerPixel(this.image.getFormat());
    }
}

