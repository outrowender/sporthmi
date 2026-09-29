/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;

public interface IWrappedLayer {
    default public IWrappedNode3D getNode() {
    }

    default public String getName() {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public int getIndex() {
    }

    default public boolean invalidateObject() {
    }

    default public void setInvalid(boolean bl) {
    }

    default public boolean isInvalid() {
    }

    default public void setLayoutDirectionLeftToRight(boolean bl) {
    }

    default public void setLayerOpacity(float f2) {
    }

    default public boolean isLayoutDirectionLeftToRight() {
    }

    default public IWrappedNode3D getMainNode() {
    }

    default public void setViewport(IWrappedViewport iWrappedViewport) {
    }

    default public IWrappedViewport getViewport() {
    }
}

