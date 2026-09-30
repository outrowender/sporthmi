/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;

public interface IWrappedTexture {
    public ITexture getTexture();

    public TextureDescription getDescription();

    public int releaseTexture(boolean var1, Object var2);

    public int getWidth();

    public int getHeight();

    public EALManager getEALManager();

    public int getRawImageSize();
}

