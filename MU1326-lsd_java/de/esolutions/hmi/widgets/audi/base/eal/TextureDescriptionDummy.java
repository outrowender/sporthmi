/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;

public class TextureDescriptionDummy
extends AbstractTextureDescription {
    protected final ITexture texture;
    protected EALManager eal;

    public TextureDescriptionDummy(ITexture iTexture) {
        super(null, null);
        this.texture = iTexture;
    }

    public TextureDescriptionDummy(ITexture iTexture, EALManager eALManager) {
        super(eALManager, null);
        this.eal = eALManager;
        this.texture = iTexture;
    }

    @Override
    public IWrappedTexture createTexture() {
        return new WrappedTexture(this.texture, this, this.ealManager);
    }

    @Override
    public int[] getUnscaledDimension() {
        return new int[]{(int)this.texture.getWidth(), (int)this.texture.getHeight()};
    }

    @Override
    public Object getCacheKey() {
        return this;
    }

    @Override
    public FlagImage getImageFlags() {
        return null;
    }

    @Override
    public IWrappedTexture getTexture(Object object) {
        return this.createTexture();
    }
}

