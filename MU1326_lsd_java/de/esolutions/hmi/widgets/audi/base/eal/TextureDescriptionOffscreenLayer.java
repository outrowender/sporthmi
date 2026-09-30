/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;

public class TextureDescriptionOffscreenLayer
extends AbstractTextureDescription {
    private final IWrappedViewport viewport;
    private final FlagImage flagImage;

    public TextureDescriptionOffscreenLayer(IWrappedViewport iWrappedViewport, FlagImage flagImage) {
        super(null, null);
        this.viewport = iWrappedViewport;
        this.flagImage = flagImage;
    }

    public IWrappedTexture createTexture() {
        return this.viewport.enableOffscreen();
    }

    public Object getCacheKey() {
        return this.viewport.getName();
    }

    public FlagImage getImageFlags() {
        return this.flagImage;
    }

    public int[] getUnscaledDimension() {
        return new int[]{this.viewport.getWidth(), this.viewport.getHeight()};
    }

    public IWrappedTexture getTexture(Object object) {
        return this.createTexture();
    }
}

