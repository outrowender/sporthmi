/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import java.util.List;

public interface IWrappedManagedNode {
    default public INode2DManaged getNode() {
    }

    default public ITexture enableOffscreen(int n, int n2, FlagTexture flagTexture) {
    }

    default public boolean addViewport(IWrappedViewport iWrappedViewport) {
    }

    default public boolean addToScreen(INode2D iNode2D, int n) {
    }

    default public boolean addAuto(INode2D iNode2D, int n) {
    }

    default public boolean removeFromScreen(INode2D iNode2D) {
    }

    default public INode2D getChildByIndex(int n) {
    }

    default public boolean remove(IWrappedViewport iWrappedViewport) {
    }

    default public List getViewports() {
    }

    default public String getName() {
    }
}

