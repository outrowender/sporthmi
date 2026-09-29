/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.util.Util;
import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;

public class TextureDescriptionGuideImage
extends AbstractTextureDescription {
    private final int index;
    private final Integer key;
    private final boolean useEalAtlas;
    private final HMIImage image;

    public TextureDescriptionGuideImage(EALManager eALManager, int n, boolean bl, int n2) {
        super(eALManager, eALManager.getCache(0));
        this.index = n;
        this.useEalAtlas = bl;
        this.key = Util.createInteger(n);
        this.image = eALManager.getHMIImage(n, n2);
    }

    @Override
    public IWrappedTexture createTexture() {
        IImage iImage;
        if (logChannel3DEngine.isDebug()) {
            logChannel3DEngine.log(-2137614336, "TextureDescriptionGuideImage#createTexture Attempt to load GuideImage: %1", (Object)this.image);
        }
        if ((iImage = this.ealManager.createEALImage(this.image)) == null) {
            logChannel3DEngine.log(10000, "TextureDescriptionGuideImage#createTexture could not load image for %1", (Object)this);
            return null;
        }
        FlagTexture flagTexture = EALManager.getTextureFlags(this.image.getFormat(), this.useEalAtlas);
        ITexture iTexture = this.ealManager.createTexture(iImage, flagTexture);
        this.ealManager.destroy(iImage);
        if (iTexture == null) {
            logChannel3DEngine.log(10000, "TextureDescriptionGuideImage#createTexture could not create texture for %1", (Object)this);
            return null;
        }
        WrappedTexture wrappedTexture = new WrappedTexture(iTexture, this, this.ealManager);
        return wrappedTexture;
    }

    @Override
    public Object getCacheKey() {
        return this.key;
    }

    public HMIImage getImage() {
        return this.image;
    }

    @Override
    public int[] getUnscaledDimension() {
        return super.getUnscaledDimension(this.image.getPath());
    }

    @Override
    public FlagImage getImageFlags() {
        return EALManager.getImageFlags(this.image.getFormat());
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean preventRTLFlip() {
        return this.image.getPreventRTLFlipFlag();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TextureDescriptionGuideImage [getCacheKey()=");
        stringBuffer.append(this.getCacheKey());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public int getDepthsInByte() {
        return HMIImage.getNumBytesPerPixel(this.image.getFormat());
    }
}

