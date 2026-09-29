/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;

public interface IWrappedNode3DQuickDraw
extends IWrappedNode3D {
    default public INode3DQuickDraw getQuickDrawNode() {
    }

    default public void add(float f2, float f3) {
    }

    default public void setLineWidth(float f2) {
    }

    default public void setLineColor(int n) {
    }

    default public void clearArea() {
    }
}

