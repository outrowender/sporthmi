/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;

public interface IWrappedNode3DQuickDraw
extends IWrappedNode3D {
    public INode3DQuickDraw getQuickDrawNode();

    public void add(float var1, float var2);

    public void setLineWidth(float var1);

    public void setLineColor(int var1);

    public void clearArea();
}

