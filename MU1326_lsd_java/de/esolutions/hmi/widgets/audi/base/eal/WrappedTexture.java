/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;

public class WrappedTexture
implements IWrappedTexture {
    private final ITexture texture;
    private final TextureDescription description;
    private final EALManager ealManager;

    public WrappedTexture(ITexture iTexture, TextureDescription textureDescription, EALManager eALManager) {
        this.texture = iTexture;
        this.description = textureDescription;
        this.ealManager = eALManager;
    }

    @Override
    public ITexture getTexture() {
        return this.texture;
    }

    @Override
    public int getHeight() {
        return (int)this.texture.getHeight();
    }

    @Override
    public int getWidth() {
        return (int)this.texture.getWidth();
    }

    @Override
    public int getRawImageSize() {
        return this.getWidth() * this.getHeight() * this.description.getDepthsInByte();
    }

    @Override
    public TextureDescription getDescription() {
        return this.description;
    }

    @Override
    public EALManager getEALManager() {
        return this.ealManager;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WrappedTexture [description=");
        stringBuffer.append(this.description);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public int releaseTexture(boolean bl, Object object) {
        int n = this.ealManager.releaseTexture(this, bl, object);
        return n;
    }
}

