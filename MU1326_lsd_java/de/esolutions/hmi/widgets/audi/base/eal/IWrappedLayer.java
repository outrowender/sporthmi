/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;

public interface IWrappedLayer {
    public IWrappedNode3D getNode();

    public String getName();

    public int getWidth();

    public int getHeight();

    public int getIndex();

    public boolean invalidateObject();

    public void setInvalid(boolean var1);

    public boolean isInvalid();

    public void setLayoutDirectionLeftToRight(boolean var1);

    public void setLayerOpacity(float var1);

    public boolean isLayoutDirectionLeftToRight();

    public IWrappedNode3D getMainNode();

    public void setViewport(IWrappedViewport var1);

    public IWrappedViewport getViewport();
}

