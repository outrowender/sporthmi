/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.api.ITextureShared;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;

public class TextureDescriptionShared
extends AbstractTextureDescription {
    private final String name;
    private final int width;
    private final int height;

    public TextureDescriptionShared(EALManager eALManager, String string, int n, int n2) {
        super(eALManager, null);
        this.name = string;
        this.width = n;
        this.height = n2;
    }

    @Override
    public IWrappedTexture createTexture() {
        ITextureShared iTextureShared = this.ealManager.createSharedTexture(this.name, this.width, this.height);
        if (iTextureShared == null) {
            return null;
        }
        return new WrappedTexture(iTextureShared, this, this.ealManager);
    }

    @Override
    public int[] getUnscaledDimension() {
        return new int[]{this.width, this.height};
    }

    @Override
    public Object getCacheKey() {
        return this;
    }

    @Override
    public FlagImage getImageFlags() {
        return null;
    }
}

