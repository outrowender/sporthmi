/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;

public interface IWrappedTexture {
    default public ITexture getTexture() {
    }

    default public TextureDescription getDescription() {
    }

    default public int releaseTexture(boolean bl, Object object) {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public EALManager getEALManager() {
    }

    default public int getRawImageSize() {
    }
}

